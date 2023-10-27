package com.virtech.spacez.logic.angle;

public class PseudoEulerAngles {
	// all in radians
	public double yRotation;
	public double zRotation;

	public PseudoEulerAngles(double yRotation, double zRotation) {
		this.yRotation = yRotation;
		this.zRotation = zRotation;
	}

	public PseudoEulerAngles(Coordinates coordinates) {
		this.yRotation = coordinates.latitude / 180 * Math.PI;
		this.zRotation = coordinates.longitude / 180 * Math.PI;
	}

	public PseudoEulerAngles(Vector3 vector) {
		Vector3 norm = vector.normalized();
		yRotation = Math.asin(norm.z());
		zRotation = Math.acos(norm.y());
	}

	public void rotateAlongAxis(double angle, Vector3 axis) throws Exception {
		double sin = Math.sin(angle);
		double cos = Math.cos(angle);
		double x = axis.x();
		double y = axis.y();
		double z = axis.z();

		Matrix rotationMatrix = new Matrix(new double[][]{
				new double[]{
						cos + x * x * (1 - cos),
						x * y * (1 - cos) - z * sin,
						x * z * (1 - cos) + y * sin},
				new double[]{
						y * x * (1 - cos) + z * sin,
						cos + y * y * (1 - cos),
						y * z * (1 - cos) - x * sin
				},
				new double[]{
						z * x * (1 - cos) - y * sin,
						z * y * (1 - cos) + x * sin,
						cos + z * z * (1 - cos)
				}
		});

		Vector3 rotated = toVector3().multiply(rotationMatrix);
		PseudoEulerAngles result = new PseudoEulerAngles(rotated);
		yRotation = result.yRotation;
		zRotation = result.zRotation;
	}

	public Vector3 toVector3() throws Exception {
		return toVector3(1, 0, 0);
	}

	public Vector3 toVector3(double x, double y, double z) throws Exception {
		Matrix result = new Matrix(new double[][]{new double[]{x, y, z}});

		result = result.multiply(
				new Matrix(new double[][]{
						new double[]{Math.cos(yRotation), 0, Math.sin(yRotation)},
						new double[]{0, 1, 0},
						new double[]{-Math.sin(yRotation), 0, Math.cos(yRotation)}
				}));

		result = result.multiply(
				new Matrix(new double[][]{
						new double[]{Math.cos(zRotation), -Math.sin(zRotation), 0},
						new double[]{Math.sin(zRotation), Math.cos(zRotation), 0},
						new double[]{0, 0, 1}
				}));

		return new Vector3(result.matrix[0][0], result.matrix[0][1], result.matrix[0][2]);
	}

	public Coordinates coordinates() {
		double latitude = yRotation / Math.PI * 180;
		double longitude = zRotation / Math.PI * 180;
		return new Coordinates(latitude, longitude);
	}
}