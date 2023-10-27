package com.virtech.spacez.logic.satellite;


import com.virtech.spacez.logic.Time;
import com.virtech.spacez.logic.angle.PseudoEulerAngles;

public class Satellite {
	public final int id;
	public Orbit orbit;
	public PseudoEulerAngles startPositionAngle;
	public boolean clockwiseRotation;
	public double fovAngle;


	public Satellite(int id, Orbit orbit, PseudoEulerAngles startPositionAngle, boolean clockwiseRotation, double fovAngle) {
		this.id = id;
		this.orbit = orbit;
		this.startPositionAngle = startPositionAngle;
		this.clockwiseRotation = clockwiseRotation;
		this.fovAngle = fovAngle;
	}

	public double getAngularVelocity() {
		return getAngularVelocity(Time.current());
	}

	public double getAngularVelocity(double time) {
		// Round orbit only
		return Math.sqrt(Earth.u / this.orbit.majorAxis);
	}

	public PseudoEulerAngles getPosition() throws Exception {
		return getPosition(Time.current());
	}

	public PseudoEulerAngles getPosition(double time) throws Exception {
		PseudoEulerAngles result = new PseudoEulerAngles(orbit.directionAngle.yRotation,
														 orbit.directionAngle.zRotation);
		result.rotateAlongAxis(getAngularVelocity() * time, orbit.normalVector);
		return result;
	}
}
