package formulas;

import formulas.evolutionary.FormulaVisitor;

public abstract class AbstractBinaryOperator extends AbstractMutableFormula {

	protected AbstractMutableFormula left;
	protected AbstractMutableFormula right;

	public AbstractBinaryOperator(AbstractMutableFormula left,
			AbstractMutableFormula right) {
		this.left = left;
		this.right = right;
		subtreeSize = left.getSubtreeSize() + right.getSubtreeSize() + 1;
	}

	public AbstractMutableFormula getLeft() {
		return left;
	}

	public AbstractMutableFormula getRight() {
		return right;
	}

	public abstract AbstractBinaryOperator getInstance(
			AbstractMutableFormula left, AbstractMutableFormula right);

	@Override
	public AbstractMutableFormula accept(FormulaVisitor visitor) {
		return visitor.visit(this);
	}

	@Override
	public AbstractBinaryOperator clone() {
		return getInstance(left.clone(), right.clone());
	}

}
