package com.lmoura.api.service.impl;

import com.lmoura.api.domain.User;
import com.lmoura.api.domain.dto.UserDTO;
import com.lmoura.api.repositories.UserRepository;
import com.lmoura.api.service.UserService;
import com.lmoura.api.service.exceptions.DataIntegretyViolationException;
import com.lmoura.api.service.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public User findById(Integer id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<User> findAll(){
        return repository.findAll();
    }

    @Override
    public User create(UserDTO obj) {
        findByEmail(obj);
        return repository.save(mapper.map(obj, User.class));
    }

    private void findByEmail(UserDTO obj){
        Optional<User> user = repository.findByEmail(obj.getEmail());
        if (user.isPresent()){
            throw new DataIntegretyViolationException("E-mail já cadastrado.");
        }
    }
}
