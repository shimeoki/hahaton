package com.virtech.spacez.logic.satellite;


import com.virtech.spacez.logic.angle.PseudoEulerAngles;
import com.virtech.spacez.logic.angle.Vector3;

public class Satellite {
	public final int id;
	public PseudoEulerAngles currentPositionAngle;
	public PseudoEulerAngles startPositionAngle;

	// In angles per minute
	public double currentAngularSpeed;
	public double fovAngle;
	public Orbit orbit;

	public Satellite(int id, PseudoEulerAngles startPositionAngle, double currentAngularSpeed,
					 double fovAngle, Orbit orbit) {
		this.startPositionAngle = startPositionAngle;
		this.currentAngularSpeed = currentAngularSpeed;
		this.fovAngle = fovAngle;
		this.id = id;
		this.orbit = orbit;
	}

	public void updateRotation(double dTime) throws Exception {
		this.currentPositionAngle.rotateAlongAxis(this.currentAngularSpeed * dTime, orbit.normalVector);
	}

//	public void canSeeArea(Vector3 point, double radius) throws Exception {
//		Vector3 distance = this.currentPositionAngle.toVector3().subtract(point);
//		double viewRadius =
//		if (distance + radius <=) {
//			System.out.println(distance);
//		}
//
//	}
}
