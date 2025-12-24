package classes;


import interfaces.Vector;

import java.util.Objects;

public class Vec implements Vector {
	private double x = 0;
	private double y = 0;
	private double z = 0;

	public Vec(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public Vec(){}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getZ() {
		return z;
	}

	@Override
	public void setX() {

	}

	@Override
	public void setY() {

	}

	@Override
	public void setZ() {

	}

	public void setZ(double z) {
		this.z = z;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) return false;
		Vec posVector = (Vec) o;
		return Double.compare(x, posVector.x) == 0 && Double.compare(y, posVector.y) == 0 && Double.compare(z, posVector.z) == 0;
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y, z);
	}

	@Override
	public String toString() {
		return "PosVector{" +
				"x=" + x +
				", y=" + y +
				", z=" + z +
				'}';
	}
}
