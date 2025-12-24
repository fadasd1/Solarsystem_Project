package interfaces;

public interface Vector {

	double getX();
	double getY();
	double getZ();

	void setX();
	void setY();
	void setZ();

	boolean equals(Object o);
	int hashCode();
}
