package com.virtech.spacez.logic.satellite;

import com.virtech.spacez.logic.Time;
import com.virtech.spacez.logic.angle.PseudoEulerAngles;
import com.virtech.spacez.logic.angle.Vector3;

public class Earth {
	public static final double G = 6.6743; // * 10 ^ -11
	public static final double M = 5.972; // * 10 ^ 24
	public static final int R = 6371; // * 1000
	public static final double u = M * G * 1e13;
	private static final double Period = 86164.090530833;
	public static double angularVelocity = 2 * Math.PI / Period;

	public static PseudoEulerAngles getRotation() throws Exception {
		return getRotation(Time.current());
	}

	public static PseudoEulerAngles getRotation(double time) throws Exception {
		return new PseudoEulerAngles(0, angularVelocity * time);
	}
}
