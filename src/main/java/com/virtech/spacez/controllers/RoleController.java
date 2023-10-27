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

import com.virtech.spacez.entities.Role;
import com.virtech.spacez.repositories.RoleRepository;


@Controller
@RequestMapping("/api")
public class RoleController {
    @Autowired
    private RoleRepository roleRepository;

    @PostMapping("/role")
    public ResponseEntity<Role> createRole(@RequestBody Role role) {
        Role newRole = new Role(role.getName());
        roleRepository.save(newRole);
        return new ResponseEntity<>(newRole, HttpStatus.CREATED);
    }

    @GetMapping("/role")
    public ResponseEntity<List<Role>> readRoles() {
        List<Role> roles = new ArrayList<Role>();
        roleRepository.findAll().forEach(roles::add);

        return new ResponseEntity<>(roles, HttpStatus.OK);
    }
}