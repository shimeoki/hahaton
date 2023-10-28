package com.virtech.spacez.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.virtech.spacez.entities.User;
import com.virtech.spacez.repositories.UserRepository;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> getAll() {
        return repository.findAll();
    }

    public User getById(int id) {
        return repository.findById(id)
            .orElseThrow(() -> new RuntimeException("User does not exist."));
    }

    public User create(User user) {
        return repository.save(user);
    }
}