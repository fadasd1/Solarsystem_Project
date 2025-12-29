package classes;

import interfaces.Vector;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;
import javafx.scene.paint.Color;
import static constants.Constants.PLANET_RADIUS_SCALAR;
import static constants.Constants.PLANET_POSITION_SCALAR;


public class PlanetView {
	private final Planet planet;
	private final Sphere sphere;

	public PlanetView(Planet planet, Color color) {
		this.planet = planet;
		this.sphere = new Sphere(planet.getRadius() * PLANET_RADIUS_SCALAR);
		PhongMaterial mat = new PhongMaterial(color);
		sphere.setMaterial(mat);
	}

	public Sphere getNode() {
		return sphere;
	}

	public void update() {
		Vector posVector = planet.getPosVector();
		sphere.setTranslateX(posVector.getX() * PLANET_POSITION_SCALAR);
		sphere.setTranslateY(posVector.getY() * PLANET_POSITION_SCALAR);
		sphere.setTranslateZ(posVector.getZ() * PLANET_POSITION_SCALAR);
	}
}
