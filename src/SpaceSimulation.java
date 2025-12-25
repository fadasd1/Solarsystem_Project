import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;
import javafx.stage.Stage;
import javafx.scene.PointLight;

public class SpaceSimulation extends Application {

	@Override
	public void start(Stage primaryStage) {
		Group root = new Group();
		Scene scene = new Scene(root,1280,720,true);
		scene.setFill(Color.BLACK);

		setupCamera(scene);
		setupLights(root);



		primaryStage.setScene(scene);
		primaryStage.setTitle("Simulation of the stars");
		primaryStage.show();
	}


	private void setupCamera(Scene scene) {
		Group cameraPivot = new Group();
		PerspectiveCamera camera = new PerspectiveCamera(true);
		camera.setNearClip(0.1);
		camera.setFarClip(1_000_000);
		camera.setTranslateZ(-500);
		cameraPivot.getChildren().add(camera);
		scene.setCamera(camera);
	}

	private void setupLights(Group root) {
		PointLight light = new PointLight(Color.WHITE);
		light.setTranslateZ(-300);
		root.getChildren().add(light);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
