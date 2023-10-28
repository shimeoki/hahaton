package com.virtech.spacez.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.virtech.spacez.entities.Order;
import com.virtech.spacez.repositories.OrderRepository;


@Service
public class OrderService {
    private final OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public List<Order> getAll() {
        return repository.findAll();
    }

    public Order create(Order order) {
        return repository.save(order);
    }
}