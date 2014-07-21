package formulas;

import java.util.Map;

public class MinusOperator extends AbstractUnaryOperator {

	public MinusOperator(MutableFormula formula) {
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
	public AbstractUnaryOperator getInstance(MutableFormula formula) {
		return new MinusOperator(formula);
	}

}
