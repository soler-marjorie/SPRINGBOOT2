package com.example.h2exemple.service;

import com.example.h2exemple.model.User;
import com.example.h2exemple.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Iterable<User> findAllUsers() {
        if(userRepository.count() == 0) {
            return null;
        }
        return userRepository.findAll();
    }

    public Optional<User> findUserById(Long id) {
        return Optional.of(userRepository.findById(id).orElse(new User()));
    }
}
