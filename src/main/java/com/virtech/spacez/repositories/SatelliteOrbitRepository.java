package com.virtech.spacez.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtech.spacez.entities.SatelliteOrbit;

// This will be AUTO IMPLEMENTED by Spring into a Bean called satelliteOrbitRepository

public interface SatelliteOrbitRepository extends JpaRepository<SatelliteOrbit, Long> {
    
}