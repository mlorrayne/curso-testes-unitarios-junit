package com.lmoura.api.service;

import com.lmoura.api.domain.User;
import com.lmoura.api.domain.dto.UserDTO;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface UserService {

    User findById(Integer id);

    List<User> findAll();

    User create(UserDTO obj);

    User update(UserDTO obj);

}
