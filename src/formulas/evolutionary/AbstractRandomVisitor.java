package formulas.evolutionary;

import java.util.Random;

import formulas.AbstractBinaryOperator;
import formulas.AbstractLiteral;
import formulas.AbstractMutableFormula;
import formulas.AbstractUnaryOperator;

public abstract class AbstractRandomVisitor implements FormulaVisitor {

	protected Random rnd;

	protected double getProbability(AbstractMutableFormula formula) {
		return 1.0 / (double) formula.getSubtreeSize();
	}

	public AbstractRandomVisitor(Random rnd) {
		this.rnd = rnd;
	}

	@Override
	public AbstractMutableFormula visit(AbstractLiteral literal) {
		return stay(literal);
	}

	@Override
	public AbstractMutableFormula visit(AbstractUnaryOperator unaryOperator) {
		if (rnd.nextDouble() < getProbability(unaryOperator)) {
			return stay(unaryOperator);
		}
		return goDown(unaryOperator);
	}

	@Override
	public AbstractMutableFormula visit(AbstractBinaryOperator binaryOperator) {
		if (rnd.nextDouble() < getProbability(binaryOperator)) {
			return stay(binaryOperator);
		}
		if (rnd.nextBoolean()) {
			return goLeft(binaryOperator);
		}
		return goRight(binaryOperator);
	}

	protected abstract AbstractMutableFormula goLeft(
			AbstractBinaryOperator binaryOperator);

	protected abstract AbstractMutableFormula goRight(
			AbstractBinaryOperator binaryOperator);

	protected abstract AbstractMutableFormula goDown(
			AbstractUnaryOperator unaryOperator);

	protected abstract AbstractMutableFormula stay(
			AbstractMutableFormula formula);
}
