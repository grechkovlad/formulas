package formulas.evolutionary;

import formulas.AbstractBinaryOperator;
import formulas.AbstractLiteral;
import formulas.AbstractMutableFormula;
import formulas.AbstractUnaryOperator;

public interface FormulaVisitor {

	public AbstractMutableFormula visit(AbstractLiteral literal);

	public AbstractMutableFormula visit(AbstractUnaryOperator unaryOperator);

	public AbstractMutableFormula visit(AbstractBinaryOperator binaryOperator);
}
