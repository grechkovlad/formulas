package formulas;

import java.util.Random;

public abstract class AbstractUnaryOperatorFactory implements FormulaFactory {

	private LiteralFactory literalFactory;
	private FormulaFactory factories[];

	public AbstractUnaryOperatorFactory(FormulaFactory[] factories,
			LiteralFactory literalFactory) {
		this.factories = factories;
		this.literalFactory = literalFactory;
	}

	@Override
	public AbstractUnaryOperator getRandomInstance(Random rnd, int depth) {
		if (depth < 0) {
			throw new IllegalArgumentException("depth must be non-negative");
		}
		AbstractMutableFormula formula;
		if (depth == 1) {
			formula = literalFactory.getRandomInstance(rnd, depth - 1);
			return getInstance(formula);
		}
		formula = factories[rnd.nextInt(factories.length)].getRandomInstance(
				rnd, depth - 1);
		return getInstance(formula);
	}

	public abstract AbstractUnaryOperator getInstance(AbstractMutableFormula formula);

}
