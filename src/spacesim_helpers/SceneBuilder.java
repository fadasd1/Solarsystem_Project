package spacesim_helpers;

import constants.Constants;
import classes.PlanetView;
import javafx.scene.AmbientLight;
import javafx.scene.Group;
import javafx.scene.PointLight;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.CullFace;
import javafx.scene.shape.Sphere;

/**
 * Utility class to construct the 3D environment for the space simulation.
 * Includes background stars, lighting, and planet views.
 */
public class SceneBuilder {

	/**
	 * Builds the scene environment including stars, lights, and planet views.
	 *
	 * @param root       the root group to attach all nodes to
	 * @param simulation the simulation engine containing planets and their views
	 */
	public static void buildEnvironment(Group root, SimulationEngine simulation) {
		setupStars(root);
		setupLights(root);
		setupPlanetViews(root, simulation);
	}

	/**
	 * Adds a large background sphere textured with a star map.
	 * The simulation should fit inside this sphere for proper display.
	 *
	 * @param root the root group to attach the star sphere to
	 */
	private static void setupStars(Group root) {
		Sphere stars = new Sphere(1e5);
		stars.setCullFace(CullFace.FRONT);
		PhongMaterial mat = new PhongMaterial();
		mat.setDiffuseMap(new Image("textures/starMap.png"));
		stars.setMaterial(mat);
		root.getChildren().add(stars);
	}

	/**
	 * Adds ambient and point lighting to the scene.
	 *
	 * @param root the root group to attach light nodes to
	 */
	private static void setupLights(Group root) {
		root.getChildren().add(new AmbientLight(Color.color(0.2, 0.2, 0.2)));
		PointLight light = new PointLight(Color.WHITE);
		light.setTranslateZ(Constants.LIGHT_OFFSET);
		root.getChildren().add(light);
	}

	/**
	 * Adds visual representations of planets to the scene.
	 *
	 * @param root       the root group to attach planet nodes to
	 * @param simulation the simulation engine containing planet views
	 */
	private static void setupPlanetViews(Group root, SimulationEngine simulation) {
		for (PlanetView pv : simulation.getPc().getPlanetViews()) {
			root.getChildren().add(pv.getNode());
		}
	}
}
