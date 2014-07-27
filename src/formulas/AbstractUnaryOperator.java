package formulas;

import formulas.evolutionary.FormulaVisitor;

public abstract class AbstractUnaryOperator extends AbstractMutableFormula {

	protected AbstractMutableFormula formula;

	public AbstractUnaryOperator(AbstractMutableFormula formula) {
		this.formula = formula;
		subtreeSize = formula.getSubtreeSize() + 1;
	}

	public AbstractMutableFormula getFormula() {
		return formula;
	}

	public abstract AbstractUnaryOperator getInstance(
			AbstractMutableFormula formula);

	public AbstractMutableFormula accept(FormulaVisitor visitor) {
		return visitor.visit(this);
	}

	@Override
	public AbstractUnaryOperator clone() {
		return getInstance(formula.clone());
	}
}
