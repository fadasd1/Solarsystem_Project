package spacesim_helpers;

import classes.Planet;
import classes.PlanetContainer;
import classes.PlanetView;
import interfaces.PlanetPhysics;
import javafx.animation.AnimationTimer;
import logic_classes.PlanetPhysicsImpl;

import static constants.Constants.*;

/**
 * Runs the simulation for a planetary system.
 * <p>
 * Manages a {@link PlanetContainer} and updates planet physics and visual positions
 * in real-time using an {@link AnimationTimer}.
 */
public class SimulationEngine {

	/** Container holding planets and their visual representations. */
	private PlanetContainer pc;

	/** Animation loop driving physics and visual updates. */
	private final AnimationTimer timer = new AnimationTimer() {
		long last = 0;
		double accumulator = 0;

		@Override
		public void handle(long now) {
			if (last == 0) {
				last = now;
				return;
			}
			double dt = (now - last) * NS_TO_S;
			last = now;
			accumulator += dt * S_TO_30D;

			while (accumulator > DEFAULT_DT) {
				physicsStep();
				accumulator -= DEFAULT_DT;
			}
			visualStep();
		}
	};

	/** Physics engine for updating planet states. */
	private final PlanetPhysics pp = PlanetPhysicsImpl.getInstance();

	/**
	 * Creates a simulation engine for the given container.
	 *
	 * @param pc container holding planets and views
	 */
	public SimulationEngine(PlanetContainer pc) {
		this.pc = pc;
	}

	/**
	 * Adds a planet to the simulation.
	 *
	 * @param p the planet to add
	 */
	public void addPlanet(Planet p) {
		pc.getPlanets().add(p);
	}

	/** Updates planetary physics for one time step. */
	private void physicsStep() {
		pp.updatePhysics(DEFAULT_DT, pc.getPlanets());
	}

	/** Updates the positions of all planet views. */
	private void visualStep() {
		for (PlanetView pv : pc.getPlanetViews()) {
			pv.update();
		}
	}

	/** Returns the container managed by this engine. */
	public PlanetContainer getPc() {
		return pc;
	}

	/** Starts the simulation loop. */
	public void start() {
		timer.start();
	}
}
