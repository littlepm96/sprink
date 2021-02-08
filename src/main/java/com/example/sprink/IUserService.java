package com.example.sprink;

import com.example.sprink.domain.User;

import java.util.Optional;



public interface IUserService {

    Integer saveUser(User user);

    Optional<User> findByUsername(String username);
}