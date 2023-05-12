package com.lmoura.api.config;

import com.lmoura.api.domain.User;
import com.lmoura.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;
import java.util.List;

@Configuration
@Profile("local")
public class LocalConfig {

    @Autowired
    private UserRepository repository;

    @Bean
    public void startDB(){
        User u1 = new User(null,"Lorrayne", "lorrayne@email.com", "1234");
        User u2 = new User(null, "Luiz", "luiz@email.com", "1234");

        repository.saveAll(List.of(u1, u2));
    }
}
