package formulas;

import java.util.Random;

public abstract class AbstractBinaryOperatorFactory implements FormulaFactory {

	FormulaFactory[] factories;
	LiteralFactory literalFactory;

	public AbstractBinaryOperatorFactory(FormulaFactory[] factories,
			LiteralFactory literalFactory) {
		this.factories = factories;
		this.literalFactory = literalFactory;
	}

	@Override
	public AbstractBinaryOperator getRandomInstance(Random rnd, int depth) {
		if (depth < 1)
			throw new IllegalArgumentException("depth must be >= 1");
		AbstractMutableFormula left;
		AbstractMutableFormula right;
		if (depth == 1) {
			left = literalFactory.getRandomInstance(rnd, depth - 1);
			right = literalFactory.getRandomInstance(rnd, depth - 1);
			return getInstance(left, right);
		}
		left = factories[rnd.nextInt(factories.length)].getRandomInstance(rnd,
				depth - 1);
		right = factories[rnd.nextInt(factories.length)].getRandomInstance(rnd,
				depth - 1);
		return getInstance(left, right);
	}

	public abstract AbstractBinaryOperator getInstance(AbstractMutableFormula left,
			AbstractMutableFormula right);

}
