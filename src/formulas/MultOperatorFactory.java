package formulas;


public class MultOperatorFactory extends AbstractBinaryOperatorFactory {

	public MultOperatorFactory(FormulaFactory[] factories,
			LiteralFactory literalFactory) {
		super(factories, literalFactory);
	}

	@Override
	public MultOperator getInstance(MutableFormula left, MutableFormula right) {
		return new MultOperator(left, right);
	}

}
