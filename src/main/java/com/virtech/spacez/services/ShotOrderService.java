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

    public ShotOrder getById(int id) {
        return repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Shot Order does not exist."));
    }

    public ShotOrder create(ShotOrder shotOrder) {
        return repository.save(shotOrder);
    }
}