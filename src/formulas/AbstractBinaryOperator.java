package formulas;

import java.util.Random;

import formulas.evolutionary.FormulaMutationStrategy;

public abstract class AbstractBinaryOperator implements MutableFormula {

	protected MutableFormula left;
	protected MutableFormula right;

	public AbstractBinaryOperator(MutableFormula left, MutableFormula right) {
		this.left = left;
		this.right = right;
	}

	public Formula getLeft() {
		return left;
	}

	public Formula getRight() {
		return right;
	}

	@Override
	public AbstractBinaryOperator mutate(Random rnd,
			FormulaMutationStrategy strategy) {
		if (rnd.nextDouble() < strategy.getMutationProbability())
			return Factories.getBinaryOperatorFactory().getRandomInstance(rnd,
					left.mutate(rnd, strategy), right.mutate(rnd, strategy));
		return getInstance(left.mutate(rnd, strategy),
				right.mutate(rnd, strategy));
	}

	public abstract AbstractBinaryOperator getInstance(MutableFormula left,
			MutableFormula right);

}
