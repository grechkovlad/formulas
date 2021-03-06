package formulas;


public class SubOperatorFactory extends AbstractBinaryOperatorFactory {

	public SubOperatorFactory(FormulaFactory[] factories,
			LiteralFactory literalFactory) {
		super(factories, literalFactory);
	}

	@Override
	public SubOperator getInstance(AbstractMutableFormula left, AbstractMutableFormula right) {
		return new SubOperator(left, right);
	}

}
