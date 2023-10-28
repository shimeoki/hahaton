package com.virtech.spacez.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtech.spacez.entities.Role;


public interface RoleRepository extends JpaRepository<Role, Integer> {
    
}