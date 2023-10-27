package com.virtech.spacez.logic;

public class Main {
	public static void main(String[] args) {
		try {
			PseudoEulerAngles angle1 = new PseudoEulerAngles(Math.PI/4, Math.PI/4);
			System.out.printf("%f %f", angle1.coordinates().latitude, angle1.coordinates().latitude);
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
	}
}