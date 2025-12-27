package classes;

import javafx.scene.paint.Color;

/**
 * Fgravity must equal Fcentripetal for initial velocity to put us in orbit properly
 * Fg = G*m1*m2/r^2
 * Fc = m*v^2/r
 * <p>
 * v = sqrt(G*m/r)
 * <p>
 * Pretty = closer to the sun
 */
public class PlanetFactory {
	// _ = numbers after are upscaling
	// Jupiter, Saturn, Uranus, and Neptune radii increased by factor 10 to make them more visible due to distance
	public static Planet createEarth() {
		return new Planet(
				"Earth",
				5.972e24,
				6371_0 *2,
				new Vec(1.5e11, 0, 0), //distance to sun in meters
				new Vec(0, 29749, 0),
				Color.AQUAMARINE
		);
	}


	public static Planet createSun() {
		return new Planet(
				"Sun",
				1.989e30,
				696340,
				new Vec(0, 0, 0),
				new Vec(0, 0, 0),
				Color.YELLOW
		);
	}

	public static Planet createMercury() {
		return new Planet(
				"Mercury",
				3.301e23,
				2439_0 *2,
				new Vec(5.79e10, 0, 0),
				new Vec(0, 47400, 0),
				Color.GRAY
		);
	}

	public static Planet createVenus() {
		return new Planet(
				"Venus",
				4.867e24,
				6051_0 *2,
				new Vec(1.082e11, 0, 0),
				new Vec(0, 35020, 0),
				Color.BEIGE
		);
	}


	public static Planet createMars() {
		return new Planet(
				"Mars",
				6.417e23,
				3389_0 *2,
				new Vec(2.279e11, 0, 0),
				new Vec(0, 24077, 0),
				Color.RED
		);
	}

	public static Planet createJupiter() {
		return new Planet(
				"Jupiter",
				1.898e27,
				69911_0,
				new Vec(7.785e11, 0, 0),
				new Vec(0, 13070, 0),
				Color.ORANGE
		);
	}

	public static Planet createSaturn() {
		return new Planet(
				"Saturn",
				5.683e26,
				58232_0,
				new Vec(1.433e12, 0, 0),
				new Vec(0, 9690, 0),
				Color.GOLD
		);
	}

	public static Planet createUranus() {
		return new Planet(
				"Uranus",
				8.681e25,
				25362_0,
				new Vec(2.872e12, 0, 0),
				new Vec(0, 6810, 0),
				Color.LIGHTBLUE
		);
	}


	public static Planet createNeptune() {
		return new Planet(
				"Neptune",
				1.024e26,
				24622_0,
				new Vec(4.495e12, 0, 0),
				new Vec(0, 5430, 0),
				Color.DARKBLUE
		);
	}

	public static Planet createBlackHole() {
		return new Planet(
				"Black Hole",
				1.989e33,
				696340,
				new Vec(1.5e11 * 5, 0, 0),
				new Vec(0, 0, 0),
				Color.ANTIQUEWHITE
		);
	}


}
