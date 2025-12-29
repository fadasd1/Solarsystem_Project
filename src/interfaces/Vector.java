package interfaces;

/**
 * Represents a 3D vector with basic access and modification methods.
 * <p>
 * Used for positions, velocities, accelerations, and forces in the simulation.
 */
public interface Vector {

	/**
	 * Returns the X component of the vector.
	 *
	 * @return the X value
	 */
	double getX();

	/**
	 * Returns the Y component of the vector.
	 *
	 * @return the Y value
	 */
	double getY();

	/**
	 * Returns the Z component of the vector.
	 *
	 * @return the Z value
	 */
	double getZ();

	/**
	 * Sets the X component of the vector.
	 *
	 * @param x the new X value
	 */
	void setX(double x);

	/**
	 * Sets the Y component of the vector.
	 *
	 * @param y the new Y value
	 */
	void setY(double y);

	/**
	 * Sets the Z component of the vector.
	 *
	 * @param z the new Z value
	 */
	void setZ(double z);

	/**
	 * Compares this vector to another object for equality.
	 *
	 * @param o the object to compare with
	 * @return true if the other object is a vector with identical components
	 */
	boolean equals(Object o);

	/**
	 * Returns a hash code for this vector.
	 *
	 * @return the hash code
	 */
	int hashCode();
}
