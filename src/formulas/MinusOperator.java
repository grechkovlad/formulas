package formulas;

import java.util.Map;

public class MinusOperator extends AbstractUnaryOperator {

	public MinusOperator(AbstractMutableFormula formula) {
		super(formula);
	}

	@Override
	public double eval(Map<String, Double> vars) {
		return -formula.eval(vars);
	}

	@Override
	public String toString() {
		return "-(" + formula.toString() + ")";
	}

	@Override
	public AbstractUnaryOperator getInstance(AbstractMutableFormula formula) {
		return new MinusOperator(formula);
	}

}
