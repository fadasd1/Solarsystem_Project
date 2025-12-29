package classes;

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
		sphere.setTranslateX(planet.getPosVector().getX() * PLANET_POSITION_SCALAR);
		sphere.setTranslateY(planet.getPosVector().getY() * PLANET_POSITION_SCALAR);
		sphere.setTranslateZ(planet.getPosVector().getZ() * PLANET_POSITION_SCALAR);
	}
}
