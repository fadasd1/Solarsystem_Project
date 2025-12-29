package classes;

import interfaces.Vector;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.paint.Color;
import javafx.scene.shape.Sphere;

import static constants.Constants.PLANET_POSITION_SCALAR;
import static constants.Constants.PLANET_RADIUS_SCALAR;

/**
 * Visual representation of a {@link Planet} in 3D space using JavaFX.
 * <p>
 * Each PlanetView wraps a Sphere node and updates its position
 * according to the planet's current coordinates.
 */
public class PlanetView {

	private final Planet planet;
	private final Sphere sphere;

	/**
	 * Creates a PlanetView for the given planet and color.
	 *
	 * @param planet the planet to represent
	 * @param color  the color to use for the sphere
	 */
	public PlanetView(Planet planet, Color color) {
		this.planet = planet;
		this.sphere = new Sphere(planet.getRadius() * PLANET_RADIUS_SCALAR);
		PhongMaterial mat = new PhongMaterial(color);
		sphere.setMaterial(mat);
	}

	/**
	 * Returns the JavaFX node representing this planet.
	 *
	 * @return the Sphere node
	 */
	public Sphere getNode() {
		return sphere;
	}

	/**
	 * Updates the position of the sphere to match the planet's current coordinates.
	 * Applies scaling from constants for rendering purposes.
	 */
	public void update() {
		Vector posVector = planet.getPosVector();
		sphere.setTranslateX(posVector.getX() * PLANET_POSITION_SCALAR);
		sphere.setTranslateY(posVector.getY() * PLANET_POSITION_SCALAR);
		sphere.setTranslateZ(posVector.getZ() * PLANET_POSITION_SCALAR);
	}
}
