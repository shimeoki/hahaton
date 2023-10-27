package com.virtech.spacez.controllers;


import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.virtech.spacez.entities.SatelliteOrbit;
import com.virtech.spacez.repositories.SatelliteOrbitRepository;


@Controller
@RequestMapping("/api")
public class SatelliteOrbitController {
    @Autowired
    private SatelliteOrbitRepository satelliteOrbitRepository;

    @PostMapping("/satellite_orbit")
    public ResponseEntity<SatelliteOrbit> createSatelliteOrbit(@RequestBody SatelliteOrbit satelliteOrbit) {
        SatelliteOrbit newSatelliteOrbit = new SatelliteOrbit(satelliteOrbit.getHorizontalAngle(), satelliteOrbit.getVerticalAngle(), satelliteOrbit.getSemiMajorAxis(), satelliteOrbit.getSemiMinorAxis());
        satelliteOrbitRepository.save(newSatelliteOrbit);
        return new ResponseEntity<>(newSatelliteOrbit, HttpStatus.CREATED);
    }

    @GetMapping("/satellite_orbit")
    public ResponseEntity<List<SatelliteOrbit>> readSatelliteOrbits() {
        List<SatelliteOrbit> satelliteOrbits = new ArrayList<SatelliteOrbit>();
        satelliteOrbitRepository.findAll().forEach(satelliteOrbits::add);

        return new ResponseEntity<>(satelliteOrbits, HttpStatus.OK);
    }
}