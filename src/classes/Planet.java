package classes;


import interfaces.Vector;


public class Planet {

	private String name; // NAME is a primary key
	private double mass;
	private double radius;
	private Vector posVector;
	private Vector velVector;


	public Planet(String name, double mass, double radius, Vector posVector, Vector velVector) {
		this.name = name;
		this.mass = mass;
		this.radius = radius;
		this.posVector = posVector;
		this.velVector = velVector;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
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
