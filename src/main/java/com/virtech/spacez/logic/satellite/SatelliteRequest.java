package com.virtech.spacez.logic.satellite;

public class SatelliteRequest {
	public final SatelliteLogic satellite;
	public final double timeToTakePhoto;
	public SatelliteRequest(SatelliteLogic satellite, double timeToTakePhoto)
	{
		this.satellite = satellite;
		this.timeToTakePhoto = timeToTakePhoto;
	}
}
