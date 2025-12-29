package constants;

/**
 * Constants for configuring camera behavior and rendering in the 3D simulation.
 * <p>
 * This class provides settings for the camera's initial offset, rotation speed,
 * panning speed, and near/far clipping planes. It cannot be instantiated.
 */
public class CameraConstants {

	private CameraConstants() {}

	/** Default offset along the Z-axis for the camera. */
	public static final int CAMERA_OFFSET = -3000;

	/** Speed factor for rotating the camera with mouse input. */
	public static final float CAMERA_ROTATION_SPEED = 0.25F;

	/** Speed for panning the camera with keyboard input. */
	public static final float PAN_SPEED = 30F;

	/** Distance to the nearest object visible by the camera. */
	public static final float NEAREST_VISIBLE_OBJECT = 0.1F;

	/** Distance to the farthest object visible by the camera. */
	public static final int FARTHEST_VISIBLE_OBJECT = 1_000_000;
}
