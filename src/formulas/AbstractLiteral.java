package formulas;

import formulas.evolutionary.FormulaVisitor;

public abstract class AbstractLiteral extends AbstractMutableFormula {
	@Override
	public AbstractMutableFormula accept(FormulaVisitor visitor) {
		return visitor.visit(this);
	}
}
