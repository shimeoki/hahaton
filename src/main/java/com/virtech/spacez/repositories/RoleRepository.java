package com.virtech.spacez.repositories;

import org.springframework.data.repository.CrudRepository;

import com.virtech.spacez.entities.Role;

// This will be AUTO IMPLEMENTED by Spring into a Bean called roleRepository

public interface RoleRepository extends CrudRepository<Role, Integer> {
    
}