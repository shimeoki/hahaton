package com.virtech.spacez.repositories;

import org.springframework.data.repository.CrudRepository;

import com.virtech.spacez.entities.Role;

// This will be AUTO IMPLEMENTED by Spring into a Bean called roleRepository
// CRUD refers Create, Read, Update, Delete

public interface RoleRepository extends CrudRepository<Role, Integer> {
    
}