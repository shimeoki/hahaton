package com.virtech.spacez.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtech.spacez.entities.Satellite;


public interface SatelliteRepository extends JpaRepository<Satellite, Integer> {
    
}