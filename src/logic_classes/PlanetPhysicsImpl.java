package logic_classes;

import classes.Planet;
import classes.Vec;
import interfaces.PlanetPhysics;
import interfaces.Vector;
import interfaces.VectorMath;

import java.util.List;

import static constants.Constants.*;

public class PlanetPhysicsImpl implements PlanetPhysics {
	//Singleton
	private static final PlanetPhysics instance = new PlanetPhysicsImpl();
	private PlanetPhysicsImpl(){}
	public static PlanetPhysics getInstance() {
		return instance;
	}

	private final VectorMath vecMath = VectorMathImpl.getInstance();


	public Vector gravitationalForceVector(Planet p1, Planet p2) throws ArithmeticException {
		Vector r = vecMath.vectorAlphaToBeta(p1.getPosVector(), p2.getPosVector());
		Vector unitVectorR = vecMath.unitVector(r);
		double distanceAlphaToBeta = vecMath.magnitude(r);
		if(distanceAlphaToBeta < DOUBLE_0_APPROXIMATION) throw new ArithmeticException("Same position");

		double scalar = (GRAVITY * p1.getMass() * p2.getMass()) / (distanceAlphaToBeta * distanceAlphaToBeta);
		return vecMath.scale(unitVectorR, scalar);
	}

	public Vector accelerationVector(Vector force, Planet p) throws ArithmeticException{
		if(p.getMass() == 0) throw new ArithmeticException("Division by 0");
		return vecMath.scale(force, 1/p.getMass());
	}

	public void velocityUpdate(Planet p, Vector accel, double dt) {
		p.setVelVector(vecMath.addVectors(p.getVelVector(), vecMath.scale(accel, dt)));
	}

	public void positionUpdate(Planet p, double dt) {
		p.setPosVector(vecMath.addVectors(p.getPosVector(), vecMath.scale(p.getVelVector(), dt)));
	}

	public void updatePhysics(double dt, List<Planet> planets) {// BIG SIMULATION UPDATER

		for(Planet alpha : planets) {
			Vector totalForce = new Vec();
			for(Planet beta : planets) {
				if(alpha != beta) {
					totalForce = vecMath.addVectors(totalForce, gravitationalForceVector(alpha, beta));
				}
			}
			Vector accelVector = accelerationVector(totalForce, alpha);
			velocityUpdate(alpha, accelVector, dt);
		}
		for(Planet p : planets) {
			positionUpdate(p, dt);
		}
	}



}
