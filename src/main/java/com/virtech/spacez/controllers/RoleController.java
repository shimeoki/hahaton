package com.virtech.spacez.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.virtech.spacez.entities.Role;
import com.virtech.spacez.services.RoleService;


@RestController
public class RoleController {

    private final RoleService service;

    public RoleController(RoleService service) {
        this.service = service;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/api/roles")
    public Role create(@RequestBody Role role) {
        return service.create(role);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/api/roles")
    public List<Role> all() {
        return service.getAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/api/roles/{id}")
    public Role one(@PathVariable int id) {
        return service.getById(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/api/roles/{id}")
    public void deleteById(@PathVariable int id) {
        service.delete(id);
    }
}