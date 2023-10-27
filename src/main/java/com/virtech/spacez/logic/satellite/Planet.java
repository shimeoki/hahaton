package com.virtech.spacez.logic.satellite;

import com.virtech.spacez.logic.angle.PseudoEulerAngles;
import com.virtech.spacez.logic.angle.Vector3;

public class Planet {
	private static final double Period = 86164.090530833;
	public static double angularVelocity = 2 * Math.PI / Period;
	public static PseudoEulerAngles currentRotation;

	public static void updateRotation() throws Exception {
		currentRotation.rotateAlongAxis(angularVelocity * System.currentTimeMillis(), new Vector3(0, 0, 1));
	}
}
