package main;

import classes.PlanetContainer;
import classes.PlanetFactory;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import spacesim_helpers.CameraController;
import spacesim_helpers.InputController;
import spacesim_helpers.SceneBuilder;
import spacesim_helpers.SimulationEngine;

import static constants.Constants.*;

/**
 * Main entry point for the 3D space simulation application.
 * Initializes planets, camera, input controls, and the scene environment.
 */
public class SpaceSimulation extends Application {

	/**
	 * Sets up the 3D scene, initializes the camera, planets, simulation engine,
	 * binds input controls, and builds the environment.
	 *
	 * @param primaryStage the primary stage for this JavaFX application
	 */
	@Override
	public void start(Stage primaryStage) {
		Group root = new Group();
		Scene scene = new Scene(root, HORIZONTAL_RESOLUTION, VERTICAL_RESOLUTION, true);

		CameraController cc = new CameraController(scene, root);
		InputController.bind(scene, cc);

		PlanetContainer pc = new PlanetContainer(PlanetFactory.createSolarSystem());
		SimulationEngine se = new SimulationEngine(pc);
		se.start();

		SceneBuilder.buildEnvironment(root, se);

		primaryStage.setScene(scene);
		primaryStage.setTitle("Simulation of the Stars");
		primaryStage.show();
	}

	/**
	 * Launches the JavaFX application.
	 *
	 * @param args command-line arguments (ignored)
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
