package com.virtech.spacez.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.virtech.spacez.entities.User;
import com.virtech.spacez.repositories.UserRepository;

@Controller
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserRepository userRepository;
}
