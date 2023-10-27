package com.virtech.spacez.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.virtech.spacez.entities.SatelliteOrbit;
import com.virtech.spacez.repositories.SatelliteOrbitRepository;

@Service
public class SatelliteOrbitService {
    private final SatelliteOrbitRepository repository;

    public SatelliteOrbitService(SatelliteOrbitRepository repository) {
        this.repository = repository;
    }

    public List<SatelliteOrbit> getAll() {
        return repository.findAll();
    }

    public SatelliteOrbit getById(int id) {
        return repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Satellite Orbit does not exist."));
    }

    public SatelliteOrbit create(SatelliteOrbit satelliteOrbit) {
        return repository.save(satelliteOrbit);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

    public SatelliteOrbit updateById(SatelliteOrbit updatedSatelliteOrbit, int id) {
        SatelliteOrbit satelliteOrbit = getById(id);

        satelliteOrbit.setHorizontalAngle(updatedSatelliteOrbit.getHorizontalAngle());
        satelliteOrbit.setVerticalAngle(updatedSatelliteOrbit.getVerticalAngle());
        satelliteOrbit.setSemiMajorAxis(updatedSatelliteOrbit.getSemiMajorAxis());
        satelliteOrbit.setSemiMinorAxis(updatedSatelliteOrbit.getSemiMinorAxis());

        return repository.save(satelliteOrbit);
    }
}