package formulas;

import java.util.Map;

public class SquareRootOperator extends AbstractUnaryOperator {

	public SquareRootOperator(AbstractMutableFormula formula) {
		super(formula);
	}

	@Override
	public double eval(Map<String, Double> vars) {
		return Math.sqrt(formula.eval(vars));
	}

	@Override
	public String toString() {
		return "sqrt(" + formula.toString() + ")";
	}

	@Override
	public AbstractUnaryOperator getInstance(AbstractMutableFormula formula) {
		return new SquareRootOperator(formula);
	}

}
