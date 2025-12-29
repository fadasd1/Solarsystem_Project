package interfaces;

import classes.Planet;
import java.util.List;

/**
 * Defines the physics operations for planetary simulations.
 * <p>
 * Implementations calculate gravitational forces, accelerations, and update
 * positions and velocities of planets over time.
 */
public interface PlanetPhysics {

	/**
	 * Computes the gravitational force vector exerted on {@code p1} by {@code p2}.
	 *
	 * @param p1 the planet experiencing the force
	 * @param p2 the planet exerting the force
	 * @return the gravitational force vector
	 * @throws ArithmeticException if a division by zero occurs (e.g., planets at same position)
	 */
	Vector gravitationalForceVector(Planet p1, Planet p2) throws ArithmeticException;

	/**
	 * Computes the acceleration vector of a planet given a force applied to it.
	 *
	 * @param force the force vector applied to the planet
	 * @param p     the planet experiencing the force
	 * @return the resulting acceleration vector
	 */
	Vector accelerationVector(Vector force, Planet p);

	/**
	 * Updates the velocity of a planet based on its acceleration and timestep.
	 *
	 * @param p     the planet to update
	 * @param accel the acceleration vector
	 * @param dt    the time step
	 */
	void velocityUpdate(Planet p, Vector accel, double dt);

	/**
	 * Updates the position of a planet based on its current velocity and timestep.
	 *
	 * @param p  the planet to update
	 * @param dt the time step
	 */
	void positionUpdate(Planet p, double dt);

	/**
	 * Updates the physics of all planets in the given list for a single timestep.
	 *
	 * @param dt      the time step
	 * @param planets the list of planets to update
	 */
	void updatePhysics(double dt, List<Planet> planets);
}
