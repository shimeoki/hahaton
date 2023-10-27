package com.virtech.spacez.logic.satellite;

import com.virtech.spacez.logic.Time;
import com.virtech.spacez.logic.angle.Coordinates;
import com.virtech.spacez.logic.angle.PseudoEulerAngles;

import java.util.Vector;

public class SatelliteLogic {
	public static Vector<Satellite> satellites = new Vector<>();

	public static void addSatellite(Satellite satellite) {
		if (!satellites.contains(satellite)) {
			satellites.add(satellite);
		}
	}

	public static void removeSatellite(Satellite satellite) {
		satellites.remove(satellite);
	}

	static Satellite whatSatelliteCanTakePhoto(double latitude, double longitude) throws Exception{
//		for (Satellite satellite : satellites) {
//			if (satellite.orbit.majorAxis == satellite.orbit.minorAxis) {
//				Coordinates coords = satellite.currentPositionAngle.coordinates();
//				boolean correctLatitude = coords.latitude == latitude;
//				boolean correctLongitude = coords.longitude + Earth.getRotation().coordinates().longitude == latitude;
//			}
//		}
		Orbit testOrbit = new Orbit(1085, 1085, new PseudoEulerAngles(63.36, 3.5));
		Satellite dummy = new Satellite(0, testOrbit,  new PseudoEulerAngles(Math.PI, 0), true, 0);//		Coordinates coords = dummy.currentPositionAngle.coordinates();
//		boolean correctLatitude = coords.latitude == latitude;
//		boolean correctLongitude = coords.longitude + Earth.getRotation().coordinates().longitude == latitude;
		return dummy;
	}

	//private static
}
