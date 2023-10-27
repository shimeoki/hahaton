package com.virtech.spacez.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.virtech.spacez.entities.SatelliteOrbit;
import com.virtech.spacez.services.SatelliteOrbitService;


@RestController
public class SatelliteOrbitController {

    private final SatelliteOrbitService service;

    public SatelliteOrbitController(SatelliteOrbitService service) {
        this.service = service;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/api/satellite-orbits")
    public SatelliteOrbit create(@RequestBody SatelliteOrbit satelliteOrbit) {
        return service.create(satelliteOrbit);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/api/satellite-orbits")
    public List<SatelliteOrbit> all() {
        return service.getAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/api/satellite-orbits/{id}")
    public SatelliteOrbit one(@PathVariable int id) {
        return service.getById(id);
    }
}