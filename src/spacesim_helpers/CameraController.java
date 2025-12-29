package spacesim_helpers;

import static constants.CameraConstants.*;

import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.transform.Rotate;

/**
 * Controls a 3D camera with pivot-based rotation, zoom, and pan in a JavaFX scene.
 * Provides methods for rotation, panning, zooming, and resetting the camera to its initial state.
 */
public class CameraController {

	private final Group pivot = new Group();
	private final PerspectiveCamera camera = new PerspectiveCamera(true);
	private final Rotate rotateX = new Rotate(0, Rotate.X_AXIS);
	private final Rotate rotateY = new Rotate(0, Rotate.Y_AXIS);

	/**
	 * Constructs a camera controller and attaches the camera to the given scene and root group.
	 *
	 * @param scene the JavaFX scene
	 * @param root  the root group to which the camera pivot is added
	 */
	public CameraController(Scene scene, Group root) {
		camera.setNearClip(NEAREST_VISIBLE_OBJECT);
		camera.setFarClip(FARTHEST_VISIBLE_OBJECT);
		camera.setTranslateZ(CAMERA_OFFSET);
		pivot.getTransforms().addAll(rotateX, rotateY);
		pivot.getChildren().add(camera);
		root.getChildren().add(pivot);
		scene.setCamera(camera);
	}

	/** Rotates the camera relative to its current orientation. */
	public void rotate(double dx, double dy) {
		rotateY.setAngle(rotateY.getAngle() + dx);
		rotateX.setAngle(rotateX.getAngle() - dy);
	}

	/** Moves the camera forward or backward along its Z-axis. */
	public void zoom(double amount) {
		camera.setTranslateZ(camera.getTranslateZ() + amount);
	}

	/** Pans the camera along the X and Y axes relative to the pivot. */
	public void pan(double dx, double dy) {
		pivot.setTranslateX(pivot.getTranslateX() + dx);
		pivot.setTranslateY(pivot.getTranslateY() + dy);
	}

	/** Resets the camera and pivot to their initial positions and orientation. */
	public void reset() {
		pivot.setTranslateX(0);
		pivot.setTranslateY(0);
		pivot.setTranslateZ(0);

		camera.setTranslateX(0);
		camera.setTranslateY(0);
		camera.setTranslateZ(CAMERA_OFFSET);

		rotateX.setAngle(0);
		rotateY.setAngle(0);
	}

	/** Sets the camera rotation directly. */
	public void rotateTo(double angleX, double angleY) {
		rotateX.setAngle(angleX);
		rotateY.setAngle(angleY);
	}

	/** Returns the current X-axis rotation of the camera. */
	public double getRotateX() {
		return rotateX.getAngle();
	}

	/** Returns the current Y-axis rotation of the camera. */
	public double getRotateY() {
		return rotateY.getAngle();
	}
}
