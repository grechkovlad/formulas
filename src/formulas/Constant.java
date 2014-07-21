package formulas;

import java.util.Map;

public class Constant extends AbstractLiteral {

	private double val;

	public Constant(double val) {
		this.val = val;
	}

	@Override
	public double eval(Map<String, Double> vars) {
		return val;
	}

	@Override
	public String toString() {
		return String.valueOf(val);
	}

}
