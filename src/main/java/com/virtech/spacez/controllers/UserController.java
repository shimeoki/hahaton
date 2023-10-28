package com.virtech.spacez.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.virtech.spacez.entities.User;
import com.virtech.spacez.services.UserService;


@RestController
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/api/users")
    public User createUser(@RequestBody User user) {
        return service.create(user);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/api/users")
    public List<User> all() {
        return service.getAll();
    }
}