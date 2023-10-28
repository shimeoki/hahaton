package com.virtech.spacez.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.virtech.spacez.entities.ShotOrder;
import com.virtech.spacez.repositories.ShotOrderRepository;


@Service
public class ShotOrderService {
    private final ShotOrderRepository repository;

    public ShotOrderService(ShotOrderRepository repository) {
        this.repository = repository;
    }

    public List<ShotOrder> getAll() {
        return repository.findAll();
    }

    public ShotOrder create(ShotOrder order) {
        return repository.save(order);
    }
}