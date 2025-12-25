package classes;

public class CelestialBody {

	private String name = "default"; // NAME is a primary key 😠
	private double mass = 0;
	private Vec posVector = new Vec();
	private Vec velVector = new Vec();

	public CelestialBody(String name, double mass, Vec posVector, Vec velVector) {
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

	public Vec getPosVector() {
		return posVector;
	}

	public void setPosVector(Vec posVector) {
		this.posVector = posVector;
	}

	public Vec getVelVector() {
		return velVector;
	}

	public void setVelVector(Vec velVector) {
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
		CelestialBody other = (CelestialBody) o;

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
