package spacesim_helpers;

import javafx.scene.Scene;

import static constants.CameraConstants.*;

/**
 * Handles user input for controlling the camera in a 3D JavaFX scene.
 * Supports mouse rotation, scroll zoom, and keyboard panning and reset.
 */
public class InputController {

	private static double anchorX;
	private static double anchorY;
	private static double anchorAngleX;
	private static double anchorAngleY;

	/**
	 * Binds mouse and keyboard events to the given camera.
	 *
	 * Mouse drag rotates the camera based on movement relative to press anchor.
	 * Scroll zooms in/out.
	 * Keyboard WASD pans the camera, R resets it.
	 *
	 * @param scene  the JavaFX scene to bind input events to
	 * @param camera the camera controller to manipulate
	 */
	public static void bind(Scene scene, CameraController camera) {

		scene.setOnScroll(e ->
				camera.zoom(e.getDeltaY())
		);

		scene.setOnMousePressed(e -> {
			anchorX = e.getSceneX();
			anchorY = e.getSceneY();
			anchorAngleX = camera.getRotateX();
			anchorAngleY = camera.getRotateY();
		});

		scene.setOnMouseDragged(e -> {
			double deltaX = (e.getSceneX() - anchorX) * CAMERA_ROTATION_SPEED;
			double deltaY = (e.getSceneY() - anchorY) * CAMERA_ROTATION_SPEED;

			camera.rotateTo(anchorAngleX - deltaY, anchorAngleY + deltaX);
		});

		scene.setOnKeyPressed(e -> {
			switch (e.getCode()) {
				case W -> camera.pan(0, -PAN_SPEED);
				case S -> camera.pan(0, PAN_SPEED);
				case A -> camera.pan(-PAN_SPEED, 0);
				case D -> camera.pan(PAN_SPEED, 0);
				case R -> camera.reset();
			}
		});
	}
}
