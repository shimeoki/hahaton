package com.virtech.spacez.logic.satellite;

import com.virtech.spacez.entities.SatelliteOrbit;
import com.virtech.spacez.logic.Time;
import com.virtech.spacez.logic.angle.Coordinates;
import com.virtech.spacez.logic.angle.PseudoEulerAngles;
import com.virtech.spacez.logic.angle.Vector3;

import java.util.Comparator;
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

	static SatelliteRequest makeRequest(Coordinates coordinates, double radius) throws Exception {
		Vector<SatelliteRequest> requests = new Vector<>();

		for (int i = (int) Time.current(); i < 43200; i++) {
			for (Satellite satellite : satellites) {
				if (satellite.orbit.majorAxis == satellite.orbit.minorAxis) {
					for (double time = Time.current(),
						 finish = Time.fromNow(30 * 24 * 60 * 60);
						 time <= finish; time += 60) {

						Vector3 satelliteVector = new PseudoEulerAngles(
								satellite.positionInEarthCoordinates()).toVector3();
						double viewRadius = getViewRadius(satellite, time);

						PseudoEulerAngles customAngle = new PseudoEulerAngles(coordinates);
						customAngle.rotateAlongAxis(Earth.getRotation(time).zRotation, new Vector3(0, 0, 1));
						Vector3 customVector = customAngle.toVector3();

						if (viewRadius >= radius + customVector.subtract(satelliteVector).length() * Earth.R) {
							requests.add(new SatelliteRequest(satellite, time));
						}
					}
				}
				// else for non-round orbit
			}
		}
		if (!requests.isEmpty()) {
			Comparator<SatelliteRequest> comparator = (SatelliteRequest r1, SatelliteRequest r2) ->
					(int) Math.round(r1.timeToTakePhoto - r2.timeToTakePhoto);
			requests.sort(comparator);
			return requests.elementAt(0);
		} else {
			return null;
		}
	}

	private static double getViewRadius(Satellite satellite, double time) {
		// Round orbit only
		double R = satellite.orbit.majorAxis;
		double r = Earth.R;
		double cos = Math.cos(satellite.fovAngle / 2);

		double D = Math.pow(2 * R * cos, 2) - 4 * (R * R - r * r);
		if (D < 0) {
			double k = Math.tan(satellite.fovAngle / 2 - Math.PI / 2);
			double d = k * k + 4 * R + 4 * r * r + 1;
			return (k - Math.sqrt(d)) / 2;

		} else {
			double l = (2 * R * cos - Math.sqrt(D)) / 2;
			return l * Math.sin(satellite.fovAngle / 2);
		}
	}
}
