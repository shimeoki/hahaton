package com.virtech.spacez.utils;

import java.util.Optional;

import com.virtech.spacez.entities.Satellite;
import com.virtech.spacez.entities.SatelliteOrbit;
import com.virtech.spacez.logic.angle.PseudoEulerAngles;
import com.virtech.spacez.logic.satellite.Orbit;
import com.virtech.spacez.logic.satellite.SatelliteLogic;

public class SatelliteConverter {
    public static Optional<SatelliteLogic> getSatellite(Satellite dbSatellite) {
        try {
            SatelliteOrbit dbSatelliteOrbit = dbSatellite.getSatelliteOrbit();
            
            PseudoEulerAngles directionAngle = new PseudoEulerAngles(dbSatelliteOrbit.getVerticalAngle(), dbSatelliteOrbit.getHorizontalAngle());
                
            Orbit logicSatelliteOrbit = new Orbit(dbSatelliteOrbit.getSemiMajorAxis(), dbSatelliteOrbit.getSemiMinorAxis(), directionAngle);
                
            PseudoEulerAngles startPositionAngle = new PseudoEulerAngles(0, dbSatellite.getStartingAngle());
                
            SatelliteLogic logicSatellite 
                = new com.virtech.spacez.logic.satellite.SatelliteLogic(
                    dbSatellite.getId(),
                    logicSatelliteOrbit,
                    startPositionAngle,
                    dbSatellite.getDirectionClockwise(),
                    dbSatellite.getFov()
                );

            return Optional.of(logicSatellite);
                
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}