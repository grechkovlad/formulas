package formulas;

import java.util.Random;

import formulas.evolutionary.FormulaMutationStrategy;

public abstract class AbstractLiteral implements MutableFormula {
	@Override
	public AbstractLiteral mutate(Random rnd, FormulaMutationStrategy strategy) {
		if (rnd.nextDouble() < strategy.getMutationProbability()) {
			return Factories.getLiteralFactory().getRandomInstance(rnd);
		}
		return this;
	}
}
