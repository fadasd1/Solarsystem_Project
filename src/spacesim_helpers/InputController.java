package spacesim_helpers;

import javafx.scene.Scene;

import static constants.CameraConstants.*;

public class InputController {

	private static double anchorX;
	private static double anchorY;
	private static double anchorAngleX;
	private static double anchorAngleY;

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
