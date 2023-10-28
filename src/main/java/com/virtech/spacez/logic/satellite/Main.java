package com.virtech.spacez.logic.satellite;

import com.virtech.spacez.logic.angle.Coordinates;
import com.virtech.spacez.logic.angle.PseudoEulerAngles;
import com.virtech.spacez.logic.angle.Vector3;

public class Main {
	public static void main(String[] args) throws Exception {
		double k = Math.PI / 180;
		Satellite test = new Satellite(0,
									   new Orbit(3578600, 3578600, new PseudoEulerAngles(0 * k, 0 * k)),
									   new PseudoEulerAngles(0 * k, 0 * k), true, 0);

		System.out.println(test.positionInEarthCoordinates(0).latitude);
		System.out.println(test.positionInEarthCoordinates(0).longitude);
		System.out.println();
		System.out.println(test.positionInEarthCoordinates(360).latitude);
		System.out.println(test.positionInEarthCoordinates(360).longitude);
		System.out.println();
		System.out.println(test.positionInEarthCoordinates(360*2).latitude);
		System.out.println(test.positionInEarthCoordinates(360*2).longitude);
		System.out.println();
	}
}
