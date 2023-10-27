package com.virtech.spacez.logic.satellite;

import com.virtech.spacez.logic.angle.PseudoEulerAngles;
import com.virtech.spacez.logic.angle.Vector3;

public class Orbit {
    public PseudoEulerAngles directionAngle;
    public double majorAxis;
    public double minorAxis;

    public Vector3 normalVector = new Vector3(0, 0, 0);

    public Orbit(double majorAxis, double minorAxis) throws Exception {
        this.normalVector = directionAngle.toVector3(0, 0, 1);
        this.majorAxis = majorAxis;
        this.minorAxis = minorAxis;

    }


}
