package com.example.h2exemple.controller;

import com.example.h2exemple.model.User;
import com.example.h2exemple.repository.UserRepository;
import com.example.h2exemple.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public Iterable<User> getAllUsers() {
        return userService.findAllUsers();
    }

    @GetMapping("/user/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        return userService.findUserById(id);
    }
}
