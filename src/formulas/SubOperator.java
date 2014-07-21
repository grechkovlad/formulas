package formulas;

import java.util.Map;

public class SubOperator extends AbstractBinaryOperator {

	public SubOperator(MutableFormula left, MutableFormula right) {
		super(left, right);
	}

	@Override
	public double eval(Map<String, Double> vars) {
		return left.eval(vars) - right.eval(vars);
	}

	@Override
	public String toString() {
		return "(" + left.toString() + ") - (" + right.toString() + ")";
	}

	@Override
	public AbstractBinaryOperator getInstance(MutableFormula left,
			MutableFormula right) {
		return new SubOperator(left, right);
	}

}