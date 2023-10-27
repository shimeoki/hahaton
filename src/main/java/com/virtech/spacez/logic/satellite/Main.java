package com.virtech.spacez.logic.satellite;

import com.virtech.spacez.logic.angle.Coordinates;
import com.virtech.spacez.logic.angle.PseudoEulerAngles;

public class Main {
    public static void main(String[] args) throws Exception {
        Orbit testOrbit = new Orbit(1085, 1085, new PseudoEulerAngles(63.36, 3.5));
        Satellite testSatellite = new Satellite(0, testOrbit, new PseudoEulerAngles(Math.PI, 0), true, 0);
        for (int i = 0; i < 5; i++) {
            Coordinates coords = testSatellite.getPosition().coordinates();
            System.out.println(coords.latitude);
            System.out.println((coords.longitude + Earth.getRotation().coordinates().longitude) % 360 - 180);
            System.out.println();
        }
    }
}
