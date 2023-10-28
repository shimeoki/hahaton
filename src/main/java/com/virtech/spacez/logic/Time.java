package com.virtech.spacez.logic;

public class Time {
	static private final double millisToSeconds = 1000;

	static public double current() {
		return System.currentTimeMillis() / millisToSeconds;
	}
	static public double fromNow(double delaySeconds) {
		return current() + delaySeconds;
	}
}
