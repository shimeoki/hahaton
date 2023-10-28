package com.virtech.spacez.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.virtech.spacez.entities.Satellite;
import com.virtech.spacez.logic.satellite.SatelliteLogic;
import com.virtech.spacez.logic.satellite.SatelliteProcess;
import com.virtech.spacez.repositories.SatelliteRepository;
import com.virtech.spacez.utils.SatelliteConverter;

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
        Satellite newSatellite = repository.save(satellite);

        Optional<SatelliteLogic> optionalLogicSatellite = SatelliteConverter.getSatellite(newSatellite);
        if (optionalLogicSatellite.isPresent()) {
            SatelliteProcess.addSatellite(optionalLogicSatellite.get()); 
        }
        
        return newSatellite;
    }
}