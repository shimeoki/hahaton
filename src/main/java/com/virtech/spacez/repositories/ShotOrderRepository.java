package com.virtech.spacez.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtech.spacez.entities.ShotOrder;


public interface ShotOrderRepository extends JpaRepository<ShotOrder, Integer> {
    
}