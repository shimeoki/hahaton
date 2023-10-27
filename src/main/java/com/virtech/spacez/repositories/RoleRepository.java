package com.virtech.spacez.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtech.spacez.entities.Role;

// This will be AUTO IMPLEMENTED by Spring into a Bean called roleRepository

public interface RoleRepository extends JpaRepository<Role, Long> {
    
}