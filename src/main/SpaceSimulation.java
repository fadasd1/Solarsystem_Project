package main;

import classes.Planet;
import classes.PlanetContainer;
import classes.PlanetFactory;
import classes.PlanetView;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.CullFace;
import javafx.scene.shape.Sphere;
import javafx.stage.Stage;
import javafx.scene.PointLight;
import spacesim_helpers.CameraController;
import spacesim_helpers.InputController;
import spacesim_helpers.SceneBuilder;
import spacesim_helpers.SimulationEngine;


import static constants.Constants.*;

public class SpaceSimulation extends Application {


	@Override
	public void start(Stage primaryStage) {
		Group root = new Group();
		Scene scene = new Scene(root,HORIZONTAL_RESOLUTION,VERTICAL_RESOLUTION,true); //true = 3d


		CameraController cc = new CameraController(scene, root);
		InputController.bind(scene, cc);

		PlanetContainer pc = new PlanetContainer(PlanetFactory.createSolarSystem());
		SimulationEngine se = new SimulationEngine(pc);
		se.start();
		SceneBuilder.buildEnvironment(root, se);


		primaryStage.setScene(scene);
		primaryStage.setTitle("Simulation of the stars");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
