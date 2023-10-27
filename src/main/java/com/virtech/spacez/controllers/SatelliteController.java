package com.virtech.spacez.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.virtech.spacez.entities.Satellite;
import com.virtech.spacez.repositories.SatelliteRepository;

@Controller
@RequestMapping("/api")
public class SatelliteController {
    @Autowired
    private SatelliteRepository satelliteRepository;
}
