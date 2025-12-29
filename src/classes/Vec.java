package classes;

import interfaces.Vector;

import java.util.Objects;

/**
 * Represents a 3D vector with x, y, and z components.
 * <p>
 * Implements the {@link Vector} interface and provides standard vector operations.
 * Equality and hash code are based on exact component values.
 */
public class Vec implements Vector {

	private double x = 0;
	private double y = 0;
	private double z = 0;

	/**
	 * Constructs a vector with specified components.
	 *
	 * @param x the x-component
	 * @param y the y-component
	 * @param z the z-component
	 */
	public Vec(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	/** Constructs a vector at the origin (0,0,0). */
	public Vec() {}

	@Override
	public double getX() { return x; }

	public void setX(double x) { this.x = x; }

	@Override
	public double getY() { return y; }

	public void setY(double y) { this.y = y; }

	@Override
	public double getZ() { return z; }

	public void setZ(double z) { this.z = z; }

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) return false;
		Vec posVector = (Vec) o;
		return Double.compare(x, posVector.x) == 0
				&& Double.compare(y, posVector.y) == 0
				&& Double.compare(z, posVector.z) == 0;
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y, z);
	}

	@Override
	public String toString() {
		return "Vec{" +
				"x=" + x +
				", y=" + y +
				", z=" + z +
				'}';
	}
}
