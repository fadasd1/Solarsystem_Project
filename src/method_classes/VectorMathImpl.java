package method_classes;

import classes.Vec;
import interfaces.Vector;
import interfaces.VectorMath;

public class VectorMathImpl implements VectorMath {
	//Singleton
	private static VectorMath instance = null;
	private VectorMathImpl(){}
	public static VectorMath getInstance() {
		if(instance == null) instance = new VectorMathImpl();
		return instance;
	}

	private Vector addVectors(Vector v1, Vector v2) {
		return new Vec(v1.getX() + v2.getX(), v1.getY() + v2.getY(), v1.getZ() + v2.getZ());
	}

	private Vector subtractVectors(Vector v1, Vector v2) {
		return new Vec(v1.getX() - v2.getX(), v1.getY() - v2.getY(), v1.getZ() - v2.getZ());
	}

	private double magnitude(Vector v1) {
		return Math.hypot(v1.getX(), Math.hypot(v1.getY(), v1.getZ()));
	}

	private double dotProductCoordinatesSafe(Vector v1, Vector v2)  {
		double max1 = Math.max(Math.abs(v1.getX()), Math.abs(v1.getY()));
		max1 = Math.max(max1, Math.abs(v1.getZ()));

		double max2 = Math.max(Math.abs(v2.getX()), Math.abs(v2.getY()));
		max2 = Math.max(max2, Math.abs(v2.getZ()));
		if(max1 == 0 || max2 == 0) return 0;

		double x1 = v1.getX() / max1, y1 = v1.getY() / max1, z1 = v1.getZ() / max1;
		double x2 = v2.getX() / max2, y2 = v2.getY() / max2, z2 = v2.getZ() / max2;

		double product =  x1*x2 + y1*y2 + z1*z2;
		return product * max1 * max2;
	}

	private double dotProductCoordinates(Vector v1, Vector v2) {
		return v1.getX() * v2.getX() + v1.getY() * v2.getY() + v1.getZ() * v2.getZ();
	}

	private Vector scale(Vector v, double lambda) {
		return new Vec(v.getX() * lambda, v.getY() * lambda, v.getZ() * lambda);
	}

	private Vector unitVector(Vector v) throws ArithmeticException {
		double magnitude = magnitude(v); if(magnitude == 0) throw new ArithmeticException("Zero Magnitude");
		return new Vec(v.getX() / magnitude, v.getY() / magnitude, v.getZ() / magnitude);
	}

	private double dotProductAngle(Vector v1, Vector v2, double angle) {
		return magnitude(v1) * magnitude(v2) * angle;
	}

	private Vector componentAlphaToBeta(Vector alpha, Vector beta) throws ArithmeticException {
		double magnitudeSquared = magnitude(beta); if(magnitudeSquared == 0) throw new ArithmeticException("Zero Magnitude");
		magnitudeSquared *= magnitudeSquared;
		double lambda = dotProductCoordinates(alpha, beta) / magnitudeSquared;
		return scale(beta, lambda);
	}

	private double angleBetween(Vector v1, Vector v2) {
		double cos = Math.acos((dotProductCoordinates(v1, v2)) / (magnitude(v1) * magnitude(v2)));
		return Math.max(-1.0, Math.min(1.0, cos));
	}

}
