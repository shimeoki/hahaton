package com.virtech.spacez.logic;

public class Time {
	static private double millisToSeconds = 1000;

	static public double current() {
		return System.currentTimeMillis() / millisToSeconds;
	}
}
