package com.virtech.spacez.logic.satellite;

public class SatelliteRequest {
	public final Satellite satellite;
	public final double timeToTakePhoto;
	public SatelliteRequest(Satellite satellite, double timeToTakePhoto)
	{
		this.satellite = satellite;
		this.timeToTakePhoto = timeToTakePhoto;
	}
}
