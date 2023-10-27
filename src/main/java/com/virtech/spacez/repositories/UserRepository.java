package com.virtech.spacez.repositories;

import org.springframework.data.repository.CrudRepository;

import com.virtech.spacez.entities.User;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository

public interface UserRepository extends CrudRepository<User, Integer> {
    
}
