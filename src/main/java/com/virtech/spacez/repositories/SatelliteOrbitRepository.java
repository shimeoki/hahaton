package com.virtech.spacez.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtech.spacez.entities.SatelliteOrbit;


public interface SatelliteOrbitRepository extends JpaRepository<SatelliteOrbit, Integer> {
    
}