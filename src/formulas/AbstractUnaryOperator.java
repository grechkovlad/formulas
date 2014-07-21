package formulas;

import java.util.Random;

import formulas.evolutionary.FormulaMutationStrategy;

public abstract class AbstractUnaryOperator implements MutableFormula {

	protected MutableFormula formula;

	public AbstractUnaryOperator(MutableFormula formula) {
		this.formula = formula;
	}

	public Formula getFormula() {
		return formula;
	}

	@Override
	public AbstractUnaryOperator mutate(Random rnd,
			FormulaMutationStrategy strategy) {
		if (rnd.nextDouble() < strategy.getMutationProbability()) {
			return Factories.getUnaryOperatorFactory().getRandomInstance(rnd,
					formula.mutate(rnd, strategy));
		}
		return getInstance(formula.mutate(rnd, strategy));
	}

	public abstract AbstractUnaryOperator getInstance(MutableFormula formula);
}
