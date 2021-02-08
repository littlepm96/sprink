package com.example.sprink.services;

import com.example.sprink.domain.User;

import java.util.List;
import java.util.Optional;



public interface IUserService {

    Integer saveUser(User user);

    Optional<User> findByUsername(String username);

    List<User> findAll();
}