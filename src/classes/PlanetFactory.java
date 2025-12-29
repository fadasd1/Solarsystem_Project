package classes;

import java.util.ArrayList;
import java.util.List;

/**
 * Factory class for creating {@link Planet} instances.
 * <p>
 * Provides methods to create individual planets and a simplified solar system.
 * Some planetary radii are scaled for better visibility in simulations.
 */
public class PlanetFactory {

	/** Creates Earth with realistic mass, scaled radius, position, and orbital velocity. */
	public static Planet createEarth() {
		return new Planet(
				"Earth",
				5.972e24,
				6371 * 20, // scaled for visibility
				new Vec(1.5e11, 0, 0),
				new Vec(0, 29749, 0)
		);
	}

	/** Creates the Sun at the origin with zero velocity. */
	public static Planet createSun() {
		return new Planet(
				"Sun",
				1.989e30,
				696340,
				new Vec(0, 0, 0),
				new Vec(0, 0, 0)
		);
	}

	/** Creates Mercury with scaled radius and initial orbital velocity. */
	public static Planet createMercury() {
		return new Planet(
				"Mercury",
				3.301e23,
				2439 * 20,
				new Vec(5.79e10, 0, 0),
				new Vec(0, 47400, 0)
		);
	}

	/** Creates Venus with scaled radius and initial orbital velocity. */
	public static Planet createVenus() {
		return new Planet(
				"Venus",
				4.867e24,
				6051 * 20,
				new Vec(1.082e11, 0, 0),
				new Vec(0, 35020, 0)
		);
	}

	/** Creates Mars with scaled radius and initial orbital velocity. */
	public static Planet createMars() {
		return new Planet(
				"Mars",
				6.417e23,
				3389 * 20,
				new Vec(2.279e11, 0, 0),
				new Vec(0, 24077, 0)
		);
	}

	/** Creates Jupiter with slightly scaled radius and initial orbital velocity. */
	public static Planet createJupiter() {
		return new Planet(
				"Jupiter",
				1.898e27,
				69911 * 10,
				new Vec(7.785e11, 0, 0),
				new Vec(0, 13070, 0)
		);
	}

	/** Creates Saturn with slightly scaled radius and initial orbital velocity. */
	public static Planet createSaturn() {
		return new Planet(
				"Saturn",
				5.683e26,
				58232 * 10,
				new Vec(1.433e12, 0, 0),
				new Vec(0, 9690, 0)
		);
	}

	/** Creates Uranus with slightly scaled radius and initial orbital velocity. */
	public static Planet createUranus() {
		return new Planet(
				"Uranus",
				8.681e25,
				25362 * 10,
				new Vec(2.872e12, 0, 0),
				new Vec(0, 6810, 0)
		);
	}

	/** Creates Neptune with slightly scaled radius and initial orbital velocity. */
	public static Planet createNeptune() {
		return new Planet(
				"Neptune",
				1.024e26,
				24622 * 10,
				new Vec(4.495e12, 0, 0),
				new Vec(0, 5430, 0)
		);
	}

	/** Creates a black hole for testing purposes. */
	public static Planet createBlackHole() {
		return new Planet(
				"Black Hole",
				1.989e33,
				696340,
				new Vec(1.5e11 * 5, 0, 0),
				new Vec(0, 0, 0)
		);
	}

	/**
	 * Creates a simplified solar system containing the Sun and major planets.
	 *
	 * @return a list of {@link Planet} objects representing the solar system
	 */
	public static List<Planet> createSolarSystem() {
		List<Planet> planets = new ArrayList<>(9);
		planets.add(createEarth());
		planets.add(createSun());
		planets.add(createMercury());
		planets.add(createMars());
		planets.add(createSaturn());
		planets.add(createJupiter());
		planets.add(createVenus());
		planets.add(createUranus());
		planets.add(createNeptune());
		return planets;
	}
}
