package formulas.evolutionary;

import java.util.Random;

import formulas.AbstractBinaryOperator;
import formulas.AbstractMutableFormula;
import formulas.AbstractUnaryOperator;

public class SimpleMutationVisitor extends AbstractRandomVisitor {

	public SimpleMutationVisitor(Random rnd) {
		super(rnd);
	}

	@Override
	protected AbstractMutableFormula goLeft(
			AbstractBinaryOperator binaryOperator) {
		AbstractMutableFormula left = binaryOperator.getLeft().accept(this);
		return binaryOperator.getInstance(left, binaryOperator.getRight());
	}

	@Override
	protected AbstractMutableFormula goRight(
			AbstractBinaryOperator binaryOperator) {
		AbstractMutableFormula right = binaryOperator.getRight().accept(this);
		return binaryOperator.getInstance(binaryOperator.getLeft(), right);
	}

	@Override
	protected AbstractMutableFormula goDown(AbstractUnaryOperator unaryOperator) {
		return unaryOperator.getInstance(unaryOperator.getFormula()
				.accept(this));
	}

	@Override
	protected AbstractMutableFormula stay(AbstractMutableFormula formula) {
		int depth = (int) (Math.log(formula.getSubtreeSize()) / Math.log(2.0));
		return FormulaCandidateFactory.getInstance().generateRandomCandidate(
				rnd, depth + 1); // TODO investigate depth
	}

}
