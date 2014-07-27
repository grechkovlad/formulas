package formulas;

import java.util.Map;

public class DivOperator extends AbstractBinaryOperator {

	public DivOperator(AbstractMutableFormula left, AbstractMutableFormula right) {
		super(left, right);
	}

	@Override
	public double eval(Map<String, Double> vars) {
		return left.eval(vars) / right.eval(vars);
	}

	@Override
	public String toString() {
		return "(" + left.toString() + ") / (" + right.toString() + ")";
	}

	@Override
	public DivOperator getInstance(AbstractMutableFormula left,
			AbstractMutableFormula right) {
		return new DivOperator(left, right);
	}

}
