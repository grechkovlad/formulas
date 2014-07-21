package formulas;

import java.util.Random;

public class LiteralFactory implements FormulaFactory {

	private VariableFactory variableFactory;
	private ConstantFactory constantFactory;

	public LiteralFactory(ConstantFactory constantFactory,
			VariableFactory variableFactory) {
		this.variableFactory = variableFactory;
		this.constantFactory = constantFactory;
	}

	@Override
	public AbstractLiteral getRandomInstance(Random rnd, int depth) {
		if (depth < 0)
			throw new IllegalArgumentException("depth must be non-negative");
		if (rnd.nextBoolean())
			return constantFactory.getRandomInstance(rnd, depth);
		return variableFactory.getRandomInstance(rnd, depth);
	}

	public AbstractLiteral getRandomInstance(Random rnd) {
		return getRandomInstance(rnd, 0);
	}
}
