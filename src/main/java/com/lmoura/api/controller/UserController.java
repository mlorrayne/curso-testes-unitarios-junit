package com.lmoura.api.controller;

import com.lmoura.api.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.GeneratedValue;

@RestController
@RequestMapping(value = "user")
public class UserController {

    @GetMapping(value = "{id}")
    public ResponseEntity<User> findById(@PathVariable Integer id){
        return ResponseEntity.ok().body(new User(1, "Lorrayne", "lo@email.com", "123"));

    }

}
