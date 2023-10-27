package com.virtech.spacez.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtech.spacez.entities.Satellite;

// This will be AUTO IMPLEMENTED by Spring into a Bean called satelliteRepository

public interface SatelliteRepository extends JpaRepository<Satellite, Long> {
    
}