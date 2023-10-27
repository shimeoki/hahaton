package com.virtech.spacez.logic.angle;

public class Vector3 {
	Matrix vector;

	public Vector3(double x, double y, double z) {
		vector = new Matrix(new double[][]{new double[]{x, y, z}});
	}

	public double x() {
		return vector.matrix[0][0];
	}

	public double y() {
		return vector.matrix[0][1];
	}

	public double z() {
		return vector.matrix[0][2];
	}

	public Vector3 normalized() {
		double len = length();
		return new Vector3(x() / len, y() / len, z() / len);
	}

	public Vector3 multiply(Matrix matrix) throws Exception {
		Matrix preResult = vector.multiply(matrix);
		return new Vector3(preResult.matrix[0][0], preResult.matrix[0][1], preResult.matrix[0][2]);
	}

	public Vector3 subtract(Vector3 vector3) throws Exception {
		return new Vector3(vector.matrix[0][0] - vector3.vector.matrix[0][0],
						   vector.matrix[0][1] - vector3.vector.matrix[0][1],
						   vector.matrix[0][2] - vector3.vector.matrix[0][2]);
	}

	public double length() {
		return Math.sqrt(x() * x() + y() * y() + z() * z());
	}
}