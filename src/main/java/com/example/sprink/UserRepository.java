package com.example.sprink;

import java.util.Optional;

import com.example.sprink.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String username);

    Optional<User> findUserByEmail(String email);
}