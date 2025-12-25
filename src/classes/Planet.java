package classes;


import interfaces.Vector;

public class Planet {

	private String name = "default"; // NAME is a primary key 😠
	private double mass = 0;
	private Vector posVector = new Vec();
	private Vector velVector = new Vec();

	public Planet(String name, double mass, Vector posVector, Vector velVector) {
		this.name = name;
		this.mass = mass;
		this.posVector = posVector;
		this.velVector = velVector;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getMass() {
		return mass;
	}

	public void setMass(double mass) {
		this.mass = mass;
	}

	public Vector getPosVector() {
		return posVector;
	}

	public void setPosVector(Vector posVector) {
		this.posVector = posVector;
	}

	public Vector getVelVector() {
		return velVector;
	}

	public void setVelVector(Vector velVector) {
		this.velVector = velVector;
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}

	@Override
	public boolean equals(Object o) {
		if(o == this) return true;
		if(o == null || this.getClass() != o.getClass()) return false;
		Planet other = (Planet) o;

		return other.name.equals(name);
	}

	@Override
	public String toString() {
		return "Planet{" +
				"name='" + name + '\'' +
				", mass=" + mass +
				", posVector=" + posVector +
				", velVector=" + velVector +
				'}';
	}
}
