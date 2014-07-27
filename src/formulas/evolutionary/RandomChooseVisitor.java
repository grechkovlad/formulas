package formulas.evolutionary;

import java.util.Random;

import formulas.AbstractBinaryOperator;
import formulas.AbstractMutableFormula;
import formulas.AbstractUnaryOperator;

public class RandomChooseVisitor extends AbstractRandomVisitor {

	public RandomChooseVisitor(Random rnd) {
		super(rnd);
	}

	@Override
	protected AbstractMutableFormula goLeft(
			AbstractBinaryOperator binaryOperator) {
		return binaryOperator.getLeft().accept(this);
	}

	@Override
	protected AbstractMutableFormula goRight(
			AbstractBinaryOperator binaryOperator) {
		return binaryOperator.getRight().accept(this);
	}

	@Override
	protected AbstractMutableFormula goDown(AbstractUnaryOperator unaryOperator) {
		return unaryOperator.getFormula().accept(this);
	}

	@Override
	protected AbstractMutableFormula stay(AbstractMutableFormula formula) {
		return formula;
	}

}
