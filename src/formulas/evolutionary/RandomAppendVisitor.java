package formulas.evolutionary;

import java.util.Random;

import formulas.AbstractBinaryOperator;
import formulas.AbstractMutableFormula;
import formulas.AbstractUnaryOperator;

public class RandomAppendVisitor extends AbstractRandomVisitor {

	private AbstractMutableFormula subtree;

	public RandomAppendVisitor(Random rnd, AbstractMutableFormula subtree) {
		super(rnd);
		this.subtree = subtree;
	}

	@Override
	protected AbstractMutableFormula goLeft(
			AbstractBinaryOperator binaryOperator) {
		return binaryOperator.getInstance(
				binaryOperator.getLeft().accept(this),
				binaryOperator.getRight());
	}

	@Override
	protected AbstractMutableFormula goRight(
			AbstractBinaryOperator binaryOperator) {
		return binaryOperator.getInstance(binaryOperator.getLeft(),
				binaryOperator.getRight().accept(this));
	}

	@Override
	protected AbstractMutableFormula goDown(AbstractUnaryOperator unaryOperator) {
		return unaryOperator.getInstance(unaryOperator.getFormula()
				.accept(this));
	}

	@Override
	protected AbstractMutableFormula stay(AbstractMutableFormula formula) {
		return subtree;
	}

}
