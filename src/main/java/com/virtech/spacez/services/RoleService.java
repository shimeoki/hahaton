package com.virtech.spacez.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.virtech.spacez.entities.Role;
import com.virtech.spacez.repositories.RoleRepository;

@Service
public class RoleService {
    private final RoleRepository repository;

    public RoleService(RoleRepository repository) {
        this.repository = repository;
    }

    public List<Role> getAll() {
        return repository.findAll();
    }

    public Role getById(int id) {
        return repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Role does not exist."));
    }

    public Role create(Role role) {
        return repository.save(role);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

    public Role updateById(Role updatedRole, int id) {
        Role role = getById(id);

        role.setName(updatedRole.getName());
        
        return repository.save(role);
    }
}