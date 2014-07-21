package formulas;

import java.util.Random;

public class BinaryOperatorFactory implements FormulaFactory {

	private AbstractBinaryOperatorFactory factories[];

	public BinaryOperatorFactory(AbstractBinaryOperatorFactory factories[]) {
		this.factories = factories;
	}

	@Override
	public AbstractBinaryOperator getRandomInstance(Random rnd, int depth) {
		if (depth < 1)
			throw new IllegalArgumentException("depth must be >= 1");
		return factories[rnd.nextInt(factories.length)].getRandomInstance(rnd,
				depth);
	}

	public AbstractBinaryOperator getRandomInstance(Random rnd,
			MutableFormula left, MutableFormula right) {
		return factories[rnd.nextInt(factories.length)]
				.getInstance(left, right);
	}

}
