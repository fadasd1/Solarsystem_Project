package interfaces;

/**
 * Provides common vector operations for 3D vectors, including addition, subtraction,
 * scaling, dot products, angles, and projections.
 */
public interface VectorMath {

	/**
	 * Adds two vectors component-wise.
	 *
	 * @param v1 first vector
	 * @param v2 second vector
	 * @return the resulting vector
	 */
	Vector addVectors(Vector v1, Vector v2);

	/**
	 * Subtracts the second vector from the first component-wise.
	 *
	 * @param v1 first vector
	 * @param v2 second vector
	 * @return the resulting vector
	 */
	Vector subtractVectors(Vector v1, Vector v2);

	/**
	 * Returns the magnitude (length) of the vector.
	 *
	 * @param v the vector
	 * @return magnitude
	 */
	double magnitude(Vector v);

	/**
	 * Computes the dot product of two vectors.
	 *
	 * @param v1 first vector
	 * @param v2 second vector
	 * @return dot product
	 */
	double dotProductCoordinates(Vector v1, Vector v2);

	/**
	 * Computes the dot product of two vectors with safety checks for numerical stability.
	 *
	 * @param v1 first vector
	 * @param v2 second vector
	 * @return dot product
	 */
	double dotProductCoordinatesSafe(Vector v1, Vector v2);

	/**
	 * Scales a vector by a scalar factor.
	 *
	 * @param v vector to scale
	 * @param lambda scaling factor
	 * @return the scaled vector
	 */
	Vector scale(Vector v, double lambda);

	/**
	 * Returns the unit vector in the direction of the given vector.
	 *
	 * @param v input vector
	 * @return normalized vector
	 * @throws ArithmeticException if the vector has zero magnitude
	 */
	Vector unitVector(Vector v) throws ArithmeticException;

	/**
	 * Computes the dot product of two vectors projected along a specific angle.
	 *
	 * @param v1 first vector
	 * @param v2 second vector
	 * @param angle angle in radians
	 * @return computed dot product
	 */
	double dotProductAngle(Vector v1, Vector v2, double angle);

	/**
	 * Projects vector alpha onto vector beta.
	 *
	 * @param alpha vector to project
	 * @param beta vector to project onto
	 * @return projection vector
	 * @throws ArithmeticException if beta has zero magnitude
	 */
	Vector componentAlphaToBeta(Vector alpha, Vector beta) throws ArithmeticException;

	/**
	 * Computes the angle between two vectors in radians.
	 *
	 * @param v1 first vector
	 * @param v2 second vector
	 * @return angle in radians
	 */
	double angleBetween(Vector v1, Vector v2);

	/**
	 * Computes the vector pointing from alpha to beta.
	 *
	 * @param alpha starting vector
	 * @param beta target vector
	 * @return resulting vector
	 */
	Vector vectorAlphaToBeta(Vector alpha, Vector beta);
}
