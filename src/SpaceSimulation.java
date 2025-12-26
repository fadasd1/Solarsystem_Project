import classes.Planet;
import classes.PlanetFactory;
import classes.PlanetView;
import classes.SimulationContainer;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.scene.PointLight;

import java.util.ArrayList;
import java.util.List;

public class SpaceSimulation extends Application {
	private SimulationContainer simulationContainer;
	private List<PlanetView> planetViews;
	private Group root;
	private Group cameraPivot;
	private PerspectiveCamera camera;

	private Rotate rotateX = new Rotate(0, Rotate.X_AXIS);
	private Rotate rotateY = new Rotate(0, Rotate.Y_AXIS);
	private double anchorX, anchorY;
	private double anchorAngleX, anchorAngleY;

	@Override
	public void start(Stage primaryStage) {
		root = new Group();
		Scene scene = new Scene(root,1920,720,true);
		scene.setFill(Color.BLACK);

		setupCamera(scene);
		setupMouseControls(scene);
		setupKeyboardControls(scene);
		setupLights();
		setupPlanetsAccurateDistance(); //Close = closer to the sun, radii in general upscaled to make certain planets visible
		startSimulationLoop();

		primaryStage.setScene(scene);
		primaryStage.setTitle("Simulation of the stars");
		primaryStage.show();
	}


	private void setupCamera(Scene scene) {
		cameraPivot = new Group();
		camera = new PerspectiveCamera(true);
		camera.setNearClip(0.1);
		camera.setFarClip(1_000_000);
		defaultCamera(camera);
		cameraPivot.getChildren().add(camera);
		scene.setCamera(camera);
		root.getChildren().add(cameraPivot);
	}

	private void defaultCamera(PerspectiveCamera camera) {
		cameraPivot.setTranslateX(0);
		cameraPivot.setTranslateY(0);
		camera.setTranslateZ(-4000);  // reset zoom if you want
		rotateX.setAngle(0);          // reset rotations
		rotateY.setAngle(0);
	}

	private void setupLights() {
		PointLight light = new PointLight(Color.WHITE);
		light.setTranslateZ(-300);
		root.getChildren().add(light);

		AmbientLight ambient = new AmbientLight(Color.color(0.2,0.2,0.2));
		root.getChildren().add(ambient);
	}

	private void startSimulationLoop() {
		new AnimationTimer() {
			private long lastTime = 0;

			@Override
			public void handle(long now) {
				if(lastTime == 0) {
					lastTime = now;
					return;
				}
				double timeScale = 1000000;
				double dt = (now - lastTime) / 1e9 * timeScale;
				lastTime = now;
				simulationContainer.update(dt);

				for(PlanetView pv : planetViews) {
					pv.update();
				}
			}
		}.start();
	}

	private void setupPlanetsAccurateDistance() {
		setupSolarSystemAccurate();
		planetViews = new ArrayList<>(simulationContainer.getPlanets().size());

		for(Planet p : simulationContainer.getPlanets()) {
			PlanetView pv = new PlanetView(p, p.getColor());
			planetViews.add(pv);
			root.getChildren().add(pv.getNode());
		}
	}

	private void setupSolarSystemAccurate() {
		simulationContainer = new SimulationContainer();
		simulationContainer.addPlanet(PlanetFactory.createEarth());
		simulationContainer.addPlanet(PlanetFactory.createSun());
		simulationContainer.addPlanet(PlanetFactory.createJupiter());
		simulationContainer.addPlanet(PlanetFactory.createMars());
		simulationContainer.addPlanet(PlanetFactory.createMercury());
		simulationContainer.addPlanet(PlanetFactory.createNeptune());
		simulationContainer.addPlanet(PlanetFactory.createUranus());
		simulationContainer.addPlanet(PlanetFactory.createSaturn());
		simulationContainer.addPlanet(PlanetFactory.createVenus());
	}

	private void setupPlanetsClose() {
		setupSolarSystemClose();
		planetViews = new ArrayList<>(simulationContainer.getPlanets().size());

		for(Planet p : simulationContainer.getPlanets()) {
			PlanetView pv = new PlanetView(p, p.getColor());
			planetViews.add(pv);
			root.getChildren().add(pv.getNode());
		}
	}

	private void setupSolarSystemClose() {
		simulationContainer = new SimulationContainer();
		simulationContainer.addPlanet(PlanetFactory.createEarthClose());
		simulationContainer.addPlanet(PlanetFactory.createSun());
		simulationContainer.addPlanet(PlanetFactory.createJupiterClose());
		simulationContainer.addPlanet(PlanetFactory.createMarsClose());
		simulationContainer.addPlanet(PlanetFactory.createMercuryClose());
		simulationContainer.addPlanet(PlanetFactory.createNeptuneClose());
		simulationContainer.addPlanet(PlanetFactory.createUranusClose());
		simulationContainer.addPlanet(PlanetFactory.createSaturnClose());
		simulationContainer.addPlanet(PlanetFactory.createVenusClose());
	}

	private void setupMouseControls(Scene scene) {
		// Add the rotates to the camera pivot once (after creating pivot)
		cameraPivot.getTransforms().addAll(rotateX, rotateY);

		double rotationSpeed = 0.3; // adjust for slower/faster rotation
		double zoomSpeed = 6;       // adjust zoom speed

		// Mouse pressed: store initial positions
		scene.setOnMousePressed(event -> {
			anchorX = event.getSceneX();
			anchorY = event.getSceneY();
			anchorAngleX = rotateX.getAngle();
			anchorAngleY = rotateY.getAngle();
		});

		// Mouse drag: rotate pivot around both axes
		scene.setOnMouseDragged(event -> {
			double deltaX = (event.getSceneX() - anchorX) * rotationSpeed;
			double deltaY = (event.getSceneY() - anchorY) * rotationSpeed;

			rotateY.setAngle(anchorAngleY + deltaX); // horizontal rotation
			rotateX.setAngle(anchorAngleX - deltaY); // vertical rotation
		});

		// Scroll: zoom in/out
		scene.setOnScroll(event -> {
			camera.setTranslateZ(camera.getTranslateZ() + event.getDeltaY() * zoomSpeed);
		});
	}

	private void setupKeyboardControls(Scene scene) {
		double cameraSpeed = 30;
		scene.setOnKeyPressed(event -> {
			switch (event.getCode()) {
				case UP -> cameraPivot.setTranslateY(cameraPivot.getTranslateY() - cameraSpeed);
				case DOWN -> cameraPivot.setTranslateY(cameraPivot.getTranslateY() + cameraSpeed);
				case LEFT -> cameraPivot.setTranslateX(cameraPivot.getTranslateX() - cameraSpeed);
				case RIGHT -> cameraPivot.setTranslateX(cameraPivot.getTranslateX() + cameraSpeed);
				case R -> defaultCamera(camera);
			}
		});
	}



	public static void main(String[] args) {
		launch(args);
	}
}
