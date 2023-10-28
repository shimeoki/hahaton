package com.virtech.spacez.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.virtech.spacez.entities.ShotOrder;
import com.virtech.spacez.services.ShotOrderService;


@RestController
public class ShotOrderController {
    
    private final ShotOrderService service;

    public ShotOrderController(ShotOrderService service) {
        this.service = service;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/api/shot-orders")
    public ShotOrder create(@RequestBody ShotOrder order) {
        return service.create(order);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/api/shot-orders")
    public List<ShotOrder> all() {
        return service.getAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/api/shot-orders/{id}")
    public ShotOrder one(@PathVariable int id) {
        return service.getById(id);
    }
}