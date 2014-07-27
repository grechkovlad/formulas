package formulas;

import java.util.Map;

public class Constant extends AbstractLiteral {

	private double val;

	public Constant(double val) {
		this.val = val;
		this.subtreeSize = 1;
	}

	@Override
	public double eval(Map<String, Double> vars) {
		return val;
	}

	@Override
	public String toString() {
		return String.valueOf(val);
	}

	@Override
	public Constant clone() {
		return new Constant(val);
	}

	public double getValue() {
		return val;
	}

}
