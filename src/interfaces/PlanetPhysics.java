package interfaces;

import method_classes.PlanetPhysicsImpl;

public interface PlanetPhysics {

	static PlanetPhysics getInstance() {
		return PlanetPhysicsImpl.getInstance();
	}
}
