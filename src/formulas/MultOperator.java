package formulas;

import java.util.Map;

public class MultOperator extends AbstractBinaryOperator {

	public MultOperator(AbstractMutableFormula left, AbstractMutableFormula right) {
		super(left, right);
	}

	@Override
	public double eval(Map<String, Double> vars) {
		return left.eval(vars) * right.eval(vars);
	}

	@Override
	public String toString() {
		return "(" + left.toString() + ") * (" + right.toString() + ")";
	}

	@Override
	public AbstractBinaryOperator getInstance(AbstractMutableFormula left,
			AbstractMutableFormula right) {
		return new MultOperator(left, right);
	}

}
