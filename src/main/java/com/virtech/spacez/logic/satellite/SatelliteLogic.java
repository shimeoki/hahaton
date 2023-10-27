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

		for (int i = (int)Time.current(); i < 43200; i++) {
			for (Satellite satellite : satellites) {
				if (satellite.orbit.majorAxis == satellite.orbit.minorAxis) {
					Coordinates coords = satellite.positionInEarthCoordinates();
					double seeRadius = satellite.orbit.majorAxis * Math.tan(satellite.fovAngle);


					boolean correctLatitude = coords.latitude == latitude;
					boolean correctLongitude = coords.longitude + Earth.getRotation().coordinates().longitude == latitude;
				}
			}
		}
	}

	//private static
}
