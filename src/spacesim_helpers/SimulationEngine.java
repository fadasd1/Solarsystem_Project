package spacesim_helpers;

import classes.Planet;
import classes.PlanetContainer;
import classes.PlanetView;
import interfaces.PlanetPhysics;
import javafx.animation.AnimationTimer;
import logic_classes.PlanetPhysicsImpl;


import static constants.Constants.*;

public class SimulationEngine {

	private PlanetContainer pc;

	public SimulationEngine(PlanetContainer pc) {
		this.pc = pc;
	}

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

	public void addPlanet(Planet p) {
		pc.getPlanets().add(p);
	}

	PlanetPhysics pp = PlanetPhysicsImpl.getInstance();

	private void physicsStep() {
		pp.updatePhysics(DEFAULT_DT, pc.getPlanets());
	}

	private void visualStep() {
		for(PlanetView pv : pc.getPlanetViews()) {
			pv.update();
		}
	}

	public PlanetContainer getPc() {
		return pc;
	}

	public void start() {
		timer.start();
	}
}



