package interfaces;
import method_classes.VectorMathImpl;

public interface VectorMath {

	static VectorMath getInstance() {
		return VectorMathImpl.getInstance();
	}

}
