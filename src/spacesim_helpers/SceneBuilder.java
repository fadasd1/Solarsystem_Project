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



public class SceneBuilder {

	public static void buildEnvironment(Group root, SimulationEngine simulation) {

		setupStars(root);
		setupLights(root);
		setupPlanetViews(root, simulation);
	}

	private static void setupStars(Group root) {
		Sphere stars = new Sphere(1e5); //Simulation has to fit easily inside this sphere for the map to be displayed properly
		stars.setCullFace(CullFace.FRONT);
		PhongMaterial mat = new PhongMaterial();
		mat.setDiffuseMap(new Image("textures/starMap.png"));
		stars.setMaterial(mat);
		root.getChildren().add(stars);
	}

	private static void setupLights(Group root) {
		root.getChildren().add(new AmbientLight(Color.color(0.2,0.2,0.2)));
		PointLight light = new PointLight(Color.WHITE);
		light.setTranslateZ(Constants.LIGHT_OFFSET);
		root.getChildren().add(light);
	}

	private static void setupPlanetViews(Group root, SimulationEngine simulation) {

		for(PlanetView pv : simulation.getPc().getPlanetViews()) {
			root.getChildren().add(pv.getNode());
		}

	}




}
