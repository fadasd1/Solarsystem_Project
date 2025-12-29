package interfaces;

public interface VectorMath {


	Vector addVectors(Vector v1, Vector v2);

	Vector subtractVectors(Vector v1, Vector v2);

	double magnitude(Vector v);

	double dotProductCoordinates(Vector v1, Vector v2);

	double dotProductCoordinatesSafe(Vector v1, Vector v2);

	Vector scale(Vector v, double lambda);

	Vector unitVector(Vector v) throws ArithmeticException;

	double dotProductAngle(Vector v1, Vector v2, double angle);

	Vector componentAlphaToBeta(Vector alpha, Vector beta) throws ArithmeticException;

	double angleBetween(Vector v1, Vector v2);

	Vector vectorAlphaToBeta(Vector alpha, Vector beta);
}
