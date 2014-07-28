package formulas.evolutionary;

import formulas.AbstractBinaryOperator;
import formulas.AbstractLiteral;
import formulas.AbstractMutableFormula;
import formulas.AbstractUnaryOperator;
import formulas.Constant;
import formulas.DivOperator;
import formulas.MinusOperator;
import formulas.MultOperator;
import formulas.SubOperator;
import formulas.SumOperator;
import formulas.Variable;

public class SimplifierVisitor implements FormulaVisitor {

	@Override
	public AbstractMutableFormula visit(AbstractLiteral literal) {
		return literal;
	}

	@Override
	public AbstractMutableFormula visit(AbstractUnaryOperator unaryOperator) {
		AbstractMutableFormula simplifiedFormula = unaryOperator.getFormula()
				.accept(this);
		AbstractMutableFormula result;
		result = evalUnary(unaryOperator, simplifiedFormula);
		if (result != null)
			return result;
		result = simplifyDoubleMinus(unaryOperator, simplifiedFormula);
		if (result != null) {
			return result;
		}
		return unaryOperator.getInstance(simplifiedFormula);
	}

	@Override
	public AbstractMutableFormula visit(AbstractBinaryOperator binaryOperator) {
		AbstractMutableFormula simplifiedLeft = binaryOperator.getLeft()
				.accept(this);
		AbstractMutableFormula simplifiedRight = binaryOperator.getRight()
				.accept(this);
		AbstractMutableFormula result;
		result = evalBinary(binaryOperator, simplifiedLeft, simplifiedRight);
		if (result != null) {
			return result;
		}
		
		result = simplifyDivision(binaryOperator, simplifiedLeft,
				simplifiedRight);
		if (result != null)
			return result;
		/*
		result = simplifySub(binaryOperator, simplifiedLeft, simplifiedRight);
		if (result != null)
			return result;
		result = simplifySum(binaryOperator, simplifiedLeft, simplifiedRight);
		if (result != null)
			return result;
		*/
		return binaryOperator.getInstance(simplifiedLeft, simplifiedRight);
	}

	private AbstractMutableFormula evalBinary(
			AbstractBinaryOperator binaryOperator, AbstractMutableFormula left,
			AbstractMutableFormula right) {
		if (left instanceof Constant && right instanceof Constant)
			return new Constant(binaryOperator.getInstance(left, right).eval(
					null));
		return null;
	}

	private Constant simplifyDivision(AbstractBinaryOperator binaryOperator,
			AbstractMutableFormula left, AbstractMutableFormula right) {
		if (binaryOperator instanceof DivOperator
				&& left instanceof Variable
				&& right instanceof Variable
				&& ((Variable) left).getName().equals(
						((Variable) right).getName())) {
			return new Constant(1);
		}
		return null;
	}

	private MultOperator simplifySum(AbstractBinaryOperator binaryOperator,
			AbstractMutableFormula left, AbstractMutableFormula right) {
		if (binaryOperator instanceof SumOperator
				&& left instanceof Variable
				&& right instanceof Variable
				&& ((Variable) left).getName().equals(
						((Variable) right).getName())) {
			return new MultOperator(left, new Constant(2));
		}
		return null;
	}

	private Constant simplifySub(AbstractBinaryOperator binaryOperator,
			AbstractMutableFormula left, AbstractMutableFormula right) {
		if (binaryOperator instanceof SubOperator
				&& left instanceof Variable
				&& right instanceof Variable
				&& ((Variable) left).getName().equals(
						((Variable) right).getName())) {
			return new Constant(0);
		}
		return null;
	}

	private Constant evalUnary(AbstractUnaryOperator unaryOperator,
			AbstractMutableFormula formula) {
		if (formula instanceof Constant)
			return new Constant(unaryOperator.getInstance(formula).eval(null));
		return null;
	}

	private AbstractMutableFormula simplifyDoubleMinus(
			AbstractUnaryOperator unaryOperator, AbstractMutableFormula formula) {
		if (unaryOperator instanceof MinusOperator
				&& formula instanceof MinusOperator)
			return ((MinusOperator) formula).getFormula();
		return null;
	}

}
