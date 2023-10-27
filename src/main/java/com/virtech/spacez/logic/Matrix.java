package com.virtech.spacez.logic;

public class Matrix {
	public final double[][] matrix;

	public Matrix(double[][] matrix) {
		this.matrix = matrix;
	}

	public Matrix multiply(Matrix other) throws Exception {
		if (this.matrix[0].length == other.matrix.length) {

			int n = other.matrix.length;
			int rows = this.matrix.length;
			int cols = other.matrix[0].length;
			double[][] result = new double[rows][cols];

			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					result[i][j] = 0;
					for (int k = 0; k < n; k++) {
						result[i][j] += this.matrix[i][k] * other.matrix[k][j];
					}
				}
			}

			return new Matrix(result);
		} else {
			throw new Exception("incorrect matrix multiplication");
		}
	}
}