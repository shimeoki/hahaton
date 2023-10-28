package com.virtech.spacez.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtech.spacez.entities.User;


public interface UserRepository extends JpaRepository<User, Integer> {
    
}