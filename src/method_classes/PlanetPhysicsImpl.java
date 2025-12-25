package method_classes;

import classes.Planet;
import classes.Vec;
import interfaces.PlanetPhysics;
import interfaces.Vector;
import interfaces.VectorMath;

import static classes.Constants.GRAVITY;

public class PlanetPhysicsImpl implements PlanetPhysics {
	//Singleton
	static PlanetPhysics instance = null;
	private PlanetPhysicsImpl(){}
	public static PlanetPhysics getInstance() {
		if(instance == null) instance = new PlanetPhysicsImpl();
		return instance;
	}

	private final VectorMath vecMath = VectorMath.getInstance();

	public Vector gravitationalForceVector(Planet p1, Planet p2) throws ArithmeticException {
		Vector r = vecMath.vectorAlphaToBeta(p1.getPosVector(), p2.getPosVector());
		Vector unitVectorR = vecMath.unitVector(r);
		double distanceAlphaToBeta = vecMath.magnitude(r);
		if(distanceAlphaToBeta == 0) throw new ArithmeticException("Same position");

		double scalar = (GRAVITY * p1.getMass() * p2.getMass()) / (distanceAlphaToBeta * distanceAlphaToBeta);
		return vecMath.scale(unitVectorR, scalar);
	}

	public Vector accelerationVector(Vector force, Planet p) {
		return vecMath.scale(force, 1/p.getMass());
	}

	public void velocityUpdate(Planet p, Vector accel, double dt) {
		p.setVelVector(vecMath.addVectors(p.getVelVector(), vecMath.scale(accel, dt)));
	}

	public void positionUpdate(Planet p, double dt) {
		p.setPosVector(vecMath.addVectors(p.getPosVector(), vecMath.scale(p.getVelVector(), dt)));
	}

	public void planetUpdate(Planet p, Vector accel, double dt) {
		velocityUpdate(p, accel, dt);
		positionUpdate(p, dt);
	}


}
