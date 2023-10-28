package com.virtech.spacez.logic.satellite;

import com.virtech.spacez.logic.angle.Coordinates;
import com.virtech.spacez.logic.angle.PseudoEulerAngles;
import com.virtech.spacez.logic.angle.Vector3;

public class Main {
    public static void main(String[] args) throws Exception {
        double k = Math.PI/180;
        Satellite test = new Satellite(0,
                                       new Orbit(1, 1, new PseudoEulerAngles(10.28*k, 146.86*k)),
                                       new PseudoEulerAngles(0*k, 120.7*k), true, 0);
        System.out.println(new PseudoEulerAngles(test.orbit.normalVector).coordinates().latitude);
        System.out.println(new PseudoEulerAngles(test.orbit.normalVector).coordinates().longitude);
        System.out.println(test.positionInEarthCoordinates(0).latitude);
        System.out.println(test.positionInEarthCoordinates(0).longitude);
        System.out.println(new PseudoEulerAngles(test.positionInEarthCoordinates(0)).toVector3().x());
        System.out.println(new PseudoEulerAngles(test.positionInEarthCoordinates(0)).toVector3().y());
        System.out.println(new PseudoEulerAngles(test.positionInEarthCoordinates(0)).toVector3().z());
    }
}
