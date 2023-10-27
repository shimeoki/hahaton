package com.virtech.spacez.logic.satellite;


import com.virtech.spacez.logic.angle.PseudoEulerAngles;

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
    public Satellite(int id) throws Exception{
        this.id = id;
        new Satellite(0, new PseudoEulerAngles(0, 0), true, 0, new Orbit(0, 0));
    }
	// In angles per minute
}
