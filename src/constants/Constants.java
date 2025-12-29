package constants;

/**
 * Global constants for the space simulation.
 * <p>
 * Includes screen resolution, physics parameters, scaling factors,
 * time conversion constants, and rendering offsets. This class cannot be instantiated.
 */
public final class Constants {

	private Constants() {
		// Prevent instantiation
	}

	/** Horizontal resolution of the application window. */
	public static final int HORIZONTAL_RESOLUTION = 1920;

	/** Vertical resolution of the application window. */
	public static final int VERTICAL_RESOLUTION = 720;

	/** Gravitational constant used in physics calculations (m³·kg⁻¹·s⁻²). */
	public static final double GRAVITY = 6.67430e-11;

	/** Default physics timestep for simulation updates. */
	public static final double DEFAULT_DT = 10;

	/** Scalar to convert planet radius from meters to scene units. */
	public static final double PLANET_RADIUS_SCALAR = 1.5e-4;

	/** Scalar to convert planet positions from meters to scene units. */
	public static final double PLANET_POSITION_SCALAR = 5e-9;

	/** Seconds to 10 simulation days (for time acceleration). */
	public static final double S_TO_10D = 864_000;

	/** Seconds to 30 simulation days (for time acceleration). */
	public static final double S_TO_30D = 2_592_000;

	/** Nanoseconds to seconds conversion factor. */
	public static final double NS_TO_S = 1e-9;

	/** Approximation threshold for comparing doubles to zero. */
	public static final double DOUBLE_0_APPROXIMATION = 1e-10;

	/** Offset along the Z-axis for lights in the scene. */
	public static final int LIGHT_OFFSET = -400;
}
