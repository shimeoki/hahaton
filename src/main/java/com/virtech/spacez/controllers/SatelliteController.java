package com.virtech.spacez.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.virtech.spacez.entities.Satellite;
import com.virtech.spacez.services.SatelliteService;


@RestController
public class SatelliteController {
    
    private final SatelliteService service;

    public SatelliteController(SatelliteService service) {
        this.service = service;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/api/satellites")
    public Satellite create(@RequestBody Satellite satellite) {
        return service.create(satellite);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/api/satellites")
    public List<Satellite> all() {
        return service.getAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/api/satellites/{id}")
    public Satellite one(@PathVariable int id) {
        return service.getById(id);
    }
}