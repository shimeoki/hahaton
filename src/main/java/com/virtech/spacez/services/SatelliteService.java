package com.virtech.spacez.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.virtech.spacez.entities.Satellite;
import com.virtech.spacez.repositories.SatelliteRepository;

@Service
public class SatelliteService {
    private final SatelliteRepository repository;

    public SatelliteService(SatelliteRepository repository) {
        this.repository = repository;
    }

    public List<Satellite> getAll() {
        return repository.findAll();
    }

    public Satellite getById(int id) {
        return repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Satellite does not exist."));
    }

    public Satellite create(Satellite satellite) {
        return repository.save(satellite);
    }
}