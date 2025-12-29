package classes;

import interfaces.Vector;

/**
 * Represents a celestial body with mass, radius, position, and velocity.
 * <p>
 * Planets are uniquely identified by their name. This class provides
 * getters and setters for physical properties and implements {@link #equals(Object)}
 * and {@link #hashCode()} based on the name.
 */
public class Planet {

	/** Unique name of the planet. */
	private String name;

	/** Mass in kilograms. */
	private double mass;

	/** Radius in meters. */
	private double radius;

	/** Current position vector. */
	private Vector posVector;

	/** Current velocity vector. */
	private Vector velVector;

	/**
	 * Constructs a new planet with specified properties.
	 *
	 * @param name      unique name
	 * @param mass      mass in kilograms
	 * @param radius    radius in meters
	 * @param posVector initial position
	 * @param velVector initial velocity
	 */
	public Planet(String name, double mass, double radius, Vector posVector, Vector velVector) {
		this.name = name;
		this.mass = mass;
		this.radius = radius;
		this.posVector = posVector;
		this.velVector = velVector;
	}

	/** Returns the planet's radius in meters. */
	public double getRadius() { return radius; }

	/** Sets the planet's radius. */
	public void setRadius(double radius) { this.radius = radius; }

	/** Returns the planet's unique name. */
	public String getName() { return name; }

	/** Sets the planet's unique name. */
	public void setName(String name) { this.name = name; }

	/** Returns the planet's mass in kilograms. */
	public double getMass() { return mass; }

	/** Sets the planet's mass. */
	public void setMass(double mass) { this.mass = mass; }

	/** Returns the current position vector. */
	public Vector getPosVector() { return posVector; }

	/** Sets the current position vector. */
	public void setPosVector(Vector posVector) { this.posVector = posVector; }

	/** Returns the current velocity vector. */
	public Vector getVelVector() { return velVector; }

	/** Sets the current velocity vector. */
	public void setVelVector(Vector velVector) { this.velVector = velVector; }

	@Override
	public int hashCode() {
		return name.hashCode();
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) return true;
		if (o == null || this.getClass() != o.getClass()) return false;
		Planet other = (Planet) o;
		return other.name.equals(name);
	}

	@Override
	public String toString() {
		return "Planet{" +
				"name='" + name + '\'' +
				", mass=" + mass +
				", posVector=" + posVector +
				", velVector=" + velVector +
				'}';
	}
}
