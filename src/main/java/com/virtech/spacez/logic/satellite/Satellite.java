package com.virtech.spacez.logic.satellite;


import com.virtech.spacez.logic.angle.PseudoEulerAngles;
import com.virtech.spacez.logic.angle.Vector3;

public class Satellite {
    public final int id;
    public PseudoEulerAngles currentPositionAngle;
    public PseudoEulerAngles startPositionAngle;

    // In angles per minute
    public double currentAngularSpeed;
    public boolean clockwiseRotation;
    public double fovAngle;
    public Orbit orbit;

    public Satellite(int id, PseudoEulerAngles startPositionAngle, boolean clockwiseRotation,
                     double fovAngle, Orbit orbit) {
        this.startPositionAngle = startPositionAngle;
        this.clockwiseRotation = clockwiseRotation;
        this.fovAngle = fovAngle;
        this.id = id;
        this.orbit = orbit;
        // Пока что орбита круговая

        this.currentAngularSpeed = Math.sqrt(Earth.getEarthGravAccel() / this.orbit.majorAxis);
    }

    public void updateRotation(double dTime) throws Exception {
        this.currentPositionAngle.rotateAlongAxis(this.currentAngularSpeed * dTime, orbit.normalVector);
    }

    public void canSeeArea(Vector3 point, double radius) throws Exception {
        Vector3 distance = this.currentPositionAngle.toVector3(1, 1, 1).subtract(point);
        System.out.println(distance);
    }
}
