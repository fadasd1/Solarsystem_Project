package interfaces;

import classes.Planet;

import java.util.List;

public interface PlanetPhysics {


	Vector gravitationalForceVector(Planet p1, Planet p2) throws ArithmeticException;

	Vector accelerationVector(Vector force, Planet p);

	void velocityUpdate(Planet p, Vector accel, double dt);

	void positionUpdate(Planet p, double dt);

	void updatePhysics(double dt, List<Planet> planets);
}
