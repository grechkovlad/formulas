package formulas;

import java.util.Map;

public class PowOperator extends AbstractBinaryOperator {

	public PowOperator(AbstractMutableFormula left, AbstractMutableFormula right) {
		super(left, right);
	}

	@Override
	public double eval(Map<String, Double> vars) {
		return Math.pow(left.eval(vars), right.eval(vars));
	}

	@Override
	public String toString() {
		return "(" + left.toString() + ") ^ (" + right.toString() + ")";
	}

	@Override
	public AbstractBinaryOperator getInstance(AbstractMutableFormula left,
			AbstractMutableFormula right) {
		return new PowOperator(left, right);
	}
}
