package com.lmoura.api.service;

import com.lmoura.api.domain.User;

import javax.persistence.criteria.CriteriaBuilder;

public interface UserService {

    User findById(Integer id);
}
