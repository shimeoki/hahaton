package com.virtech.spacez.logic.satellite;

import com.virtech.spacez.logic.angle.PseudoEulerAngles;
import com.virtech.spacez.logic.angle.Vector3;

public class Earth {
	private static final double Period = 86164.090530833;

	// 10 ^ 24
	private static final double M = 5.972;
	private static final int R = 6371;
	//10 ^ -11
	private static final double G = 6.6743;
	private static final double u = M * Math.pow(10, 24) * G * Math.pow(10, -11);
	public static double getEarthGravAccel(){
		return u;
	}
	public static double angularVelocity = 2 * Math.PI / Period;
	public static PseudoEulerAngles currentRotation;

	public static void updateRotation() throws Exception {
		currentRotation.rotateAlongAxis(angularVelocity * System.currentTimeMillis(), new Vector3(0, 0, 1));
	}

	public static PseudoEulerAngles calculateRotation(long time) {
		return new PseudoEulerAngles(0, angularVelocity * time % 360);
	}
}
