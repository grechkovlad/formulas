package formulas;


public class DivOperatorFactory extends AbstractBinaryOperatorFactory {

	public DivOperatorFactory(FormulaFactory[] factories,
			LiteralFactory literalFactory) {
		super(factories, literalFactory);
	}

	@Override
	public DivOperator getInstance(MutableFormula left, MutableFormula right) {
		return new DivOperator(left, right);
	}

}
