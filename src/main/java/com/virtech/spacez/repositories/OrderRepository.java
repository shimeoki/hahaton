package com.virtech.spacez.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtech.spacez.entities.Order;


public interface OrderRepository extends JpaRepository<Order, Integer> {
    
}