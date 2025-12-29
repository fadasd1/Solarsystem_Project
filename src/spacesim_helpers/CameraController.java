package spacesim_helpers;

import static constants.CameraConstants.*;


import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.transform.Rotate;

public class CameraController {

	private final Group pivot = new Group();
	private final PerspectiveCamera camera = new PerspectiveCamera(true);
	private final Rotate rotateX = new Rotate(0, Rotate.X_AXIS);
	private final Rotate rotateY = new Rotate(0, Rotate.Y_AXIS);

	public CameraController(Scene scene, Group root) {
		camera.setNearClip(NEAREST_VISIBLE_OBJECT);
		camera.setFarClip(FARTHEST_VISIBLE_OBJECT);
		camera.setTranslateZ(CAMERA_OFFSET);
		pivot.getTransforms().addAll(rotateX, rotateY);
		pivot.getChildren().add(camera);
		root.getChildren().add(pivot);
		scene.setCamera(camera);


	}

	public void rotate(double dx, double dy) {
		rotateY.setAngle(rotateY.getAngle() + dx);
		rotateX.setAngle(rotateX.getAngle() - dy);
	}

	public void zoom(double amount) {
		camera.setTranslateZ(camera.getTranslateZ() + amount);
	}

	public void pan(double dx, double dy) {
		pivot.setTranslateX(pivot.getTranslateX() + dx);
		pivot.setTranslateY(pivot.getTranslateY() + dy);
	}

	public void reset() {
		// Reset pivot position
		pivot.setTranslateX(0);
		pivot.setTranslateY(0);
		pivot.setTranslateZ(0);

		// Reset camera position relative to pivot
		camera.setTranslateX(0);
		camera.setTranslateY(0);
		camera.setTranslateZ(CAMERA_OFFSET);

		// Reset rotation
		rotateX.setAngle(0);
		rotateY.setAngle(0);
	}

	public void rotateTo(double angleX, double angleY) {
		rotateX.setAngle(angleX);
		rotateY.setAngle(angleY);
	}

	public double getRotateX() { return rotateX.getAngle(); }
	public double getRotateY() { return rotateY.getAngle(); }
}
