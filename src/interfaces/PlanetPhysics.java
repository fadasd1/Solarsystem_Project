package interfaces;

import logic_classes.PlanetPhysicsImpl;
import classes.Planet;

public interface PlanetPhysics {

	static PlanetPhysics getInstance() {
		return PlanetPhysicsImpl.getInstance();
	}

	Vector gravitationalForceVector(Planet p1, Planet p2) throws ArithmeticException;

	Vector accelerationVector(Vector force, Planet p);

	void velocityUpdate(Planet p, Vector accel, double dt);

	void positionUpdate(Planet p, double dt);

	void planetUpdate(Planet p, Vector accel, double dt);
}
