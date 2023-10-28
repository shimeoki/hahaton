package com.virtech.spacez.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.virtech.spacez.entities.Order;
import com.virtech.spacez.services.OrderService;


@RestController
public class OrderController {
    
    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/api/orders")
    public Order create(@RequestBody Order order) {
        return service.create(order);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/api/orders")
    public List<Order> all() {
        return service.getAll();
    }
}