package com.virtech.spacez.logic.angle;

public class Main {
	public static void main(String[] args) {
		try {
			PseudoEulerAngles angle1 = new PseudoEulerAngles(Math.PI / 4, Math.PI / 4);
			//angle1.rotateAlongAxis(0, new Vector3(0, 0, 1));
			System.out.printf("%f %f%n", angle1.coordinates().latitude, angle1.coordinates().longitude);
			System.out.printf("%f %f %f%n", angle1.toVector3().x(), angle1.toVector3().y(), angle1.toVector3().z());
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
	}
}