package com.virtech.spacez.logic.satellite;

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

//	static Satellite whatSatelliteCanTakePhoto(double latitude, double longitude) {
//		for (Satellite satellite : satellites) {
//			if (satellite.orbit.majorAxis == satellite.orbit.minorAxis) {
//
//			}
//		}
//	}

	//private static
}
