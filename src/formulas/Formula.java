package formulas;

import java.util.Map;

public interface Formula {
	public double eval(Map<String, Double> vars);
}
