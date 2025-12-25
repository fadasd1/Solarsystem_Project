package interfaces;

public interface Vector {

	double getX();
	double getY();
	double getZ();

	void setX(double x);
	void setY(double y);
	void setZ(double z);

	boolean equals(Object o);
	int hashCode();
}
