package com.virtech.spacez.payroll;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.virtech.spacez.entities.Satellite;
import com.virtech.spacez.logic.satellite.SatelliteLogic;
import com.virtech.spacez.logic.satellite.SatelliteProcess;
import com.virtech.spacez.repositories.SatelliteRepository;
import com.virtech.spacez.utils.SatelliteConverter;

@Configuration
class LoadSatellites {
    
    private static final Logger log = LoggerFactory.getLogger(LoadSatellites.class);

    @Bean
    CommandLineRunner loadSatellitesIntoLogic(SatelliteRepository repository) {

        for (Satellite dbSatellite : repository.findAll()) {
            Optional<SatelliteLogic> optionalLogicSatellite = SatelliteConverter.getSatellite(dbSatellite);
            
            if (optionalLogicSatellite.isEmpty()) {
                continue;
            }

            SatelliteLogic logicSatellite = optionalLogicSatellite.get();
            
            SatelliteProcess.addSatellite(logicSatellite);
        }

        return args -> {
            log.info("Successfully loaded Satellites into logic bundle.");
        };
    }
}