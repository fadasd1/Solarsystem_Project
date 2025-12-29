package logic_classes;

import classes.Planet;
import classes.Vec;
import interfaces.PlanetPhysics;
import interfaces.Vector;
import interfaces.VectorMath;

import java.util.List;

import static constants.Constants.*;

/**
 * Singleton implementation of {@link PlanetPhysics}.
 * Handles gravitational physics calculations and updates for planets.
 */
public class PlanetPhysicsImpl implements PlanetPhysics {

	/** Singleton instance */
	private static final PlanetPhysics instance = new PlanetPhysicsImpl();

	/** Private constructor for singleton pattern */
	private PlanetPhysicsImpl(){}

	/** Returns the singleton instance */
	public static PlanetPhysics getInstance() {
		return instance;
	}

	private final VectorMath vecMath = VectorMathImpl.getInstance();

	/**
	 * Computes the gravitational force vector exerted on p1 by p2.
	 *
	 * @param p1 the planet experiencing the force
	 * @param p2 the planet exerting the force
	 * @return gravitational force vector
	 * @throws ArithmeticException if the planets occupy the same position
	 */
	public Vector gravitationalForceVector(Planet p1, Planet p2) throws ArithmeticException {
		Vector r = vecMath.vectorAlphaToBeta(p1.getPosVector(), p2.getPosVector());
		Vector unitVectorR = vecMath.unitVector(r);
		double distanceAlphaToBeta = vecMath.magnitude(r);
		if(distanceAlphaToBeta < DOUBLE_0_APPROXIMATION) throw new ArithmeticException("Same position");

		double scalar = (GRAVITY * p1.getMass() * p2.getMass()) / (distanceAlphaToBeta * distanceAlphaToBeta);
		return vecMath.scale(unitVectorR, scalar);
	}

	/**
	 * Computes the acceleration vector of a planet given a force.
	 *
	 * @param force force applied to the planet
	 * @param p the planet
	 * @return acceleration vector
	 * @throws ArithmeticException if the planet has zero mass
	 */
	public Vector accelerationVector(Vector force, Planet p) throws ArithmeticException{
		if(p.getMass() == 0) throw new ArithmeticException("Division by 0");
		return vecMath.scale(force, 1/p.getMass());
	}

	/**
	 * Updates a planet's velocity based on its acceleration.
	 *
	 * @param p the planet
	 * @param accel acceleration vector
	 * @param dt timestep
	 */
	public void velocityUpdate(Planet p, Vector accel, double dt) {
		p.setVelVector(vecMath.addVectors(p.getVelVector(), vecMath.scale(accel, dt)));
	}

	/**
	 * Updates a planet's position based on its velocity.
	 *
	 * @param p the planet
	 * @param dt timestep
	 */
	public void positionUpdate(Planet p, double dt) {
		p.setPosVector(vecMath.addVectors(p.getPosVector(), vecMath.scale(p.getVelVector(), dt)));
	}

	/**
	 * Performs a full physics update for a list of planets.
	 * Computes gravitational forces, updates velocities, and then positions.
	 *
	 * @param dt timestep
	 * @param planets list of planets
	 */
	public void updatePhysics(double dt, List<Planet> planets) {
		for(Planet alpha : planets) {
			Vector totalForce = new Vec();
			for(Planet beta : planets) {
				if(alpha != beta) {
					totalForce = vecMath.addVectors(totalForce, gravitationalForceVector(alpha, beta));
				}
			}
			Vector accelVector = accelerationVector(totalForce, alpha);
			velocityUpdate(alpha, accelVector, dt);
		}
		for(Planet p : planets) {
			positionUpdate(p, dt);
		}
	}
}
