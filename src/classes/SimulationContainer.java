package classes;

import interfaces.PlanetPhysics;
import interfaces.Vector;
import interfaces.VectorMath;

import java.util.ArrayList;
import java.util.List;

public class SimulationContainer {
	private List<Planet> planets = new ArrayList<>();

	public void addPlanet(Planet p) {
		planets.add(p);
	}

	public List<Planet> getPlanets() {
		return planets;
	}

	private final PlanetPhysics pp = PlanetPhysics.getInstance();
	private final VectorMath vecMath = VectorMath.getInstance();

	public void update(double dt) {// BIG SIMULATION UPDATER

		for(Planet alpha : planets) {
			Vector totalForce = new Vec();
			for(Planet beta : planets) {
				if(alpha != beta) {
					totalForce = vecMath.addVectors(totalForce, pp.gravitationalForceVector(alpha, beta));
				}
			}
			Vector accelVector = pp.accelerationVector(totalForce, alpha);
			pp.velocityUpdate(alpha, accelVector, dt);
		}
		for(Planet p : planets) {
			pp.positionUpdate(p, dt);
		}
	}

}
