package com.virtech.spacez.logic.satellite;


import com.virtech.spacez.logic.Time;
import com.virtech.spacez.logic.angle.Coordinates;
import com.virtech.spacez.logic.angle.PseudoEulerAngles;
import com.virtech.spacez.logic.angle.Vector3;

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
		int sign;
		if (clockwiseRotation) {
			sign = 1;
		} else {
			sign = -1;
		}
		PseudoEulerAngles result = new PseudoEulerAngles(orbit.directionAngle.yRotation,
														 orbit.directionAngle.zRotation);
		result.rotateAlongAxis(sign * getAngularVelocity() * time, orbit.normalVector);
		return result;
	}

	public Coordinates positionInEarthCoordinates() throws Exception {
		return positionInEarthCoordinates(Time.current());
	}

	public Coordinates positionInEarthCoordinates(double time) throws Exception {
		PseudoEulerAngles absolute = getPosition(time);
		absolute.rotateAlongAxis(-Earth.getRotation(time).zRotation, new Vector3(0, 0, 1));
		return absolute.coordinates();
	}
}
