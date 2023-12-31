package com.virtech.spacez.logic.satellite;

import com.virtech.spacez.logic.angle.PseudoEulerAngles;
import com.virtech.spacez.logic.angle.Vector3;

public class Orbit {
    public PseudoEulerAngles directionAngle;
    public double majorAxis;
    public double minorAxis;

    public Vector3 normalVector;

    public Orbit(double majorAxis, double minorAxis, PseudoEulerAngles directionAngle) throws Exception {

        this.majorAxis = majorAxis + Earth.R;
        this.minorAxis = minorAxis + Earth.R;

        this.directionAngle = directionAngle;

        this.normalVector = directionAngle.toVector3(0, 0, 1);
    }
}
