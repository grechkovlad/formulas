package formulas;

import java.util.Random;

public class UnaryOperatorFactory implements FormulaFactory {

	AbstractUnaryOperatorFactory factories[];

	public UnaryOperatorFactory(AbstractUnaryOperatorFactory factories[]) {
		this.factories = factories;
	}

	@Override
	public AbstractUnaryOperator getRandomInstance(Random rnd, int depth) {
		if (depth < 1)
			throw new IllegalArgumentException("depth must be >= 1");
		return factories[rnd.nextInt(factories.length)].getRandomInstance(rnd,
				depth);
	}

	public AbstractUnaryOperator getRandomInstance(Random rnd,
			MutableFormula formula) {
		return factories[rnd.nextInt(factories.length)].getInstance(formula);
	}

}
