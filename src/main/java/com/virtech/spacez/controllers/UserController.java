package com.virtech.spacez.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.virtech.spacez.entities.User;
import com.virtech.spacez.repositories.UserRepository;

@Controller
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserRepository userRepository; 

    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User newUser = new User(user.getName(), user.getSurname(), user.getLogin(), user.getPasswordBcrypt(), user.getRole());
        userRepository.save(newUser);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @GetMapping("user")
    public ResponseEntity<List<User>> readUsers() {
        List<User> users = new ArrayList<User>();
        userRepository.findAll().forEach(users::add);
        
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}