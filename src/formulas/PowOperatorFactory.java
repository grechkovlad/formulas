package formulas;


public class PowOperatorFactory extends AbstractBinaryOperatorFactory {

	public PowOperatorFactory(FormulaFactory[] factories,
			LiteralFactory literalFactory) {
		super(factories, literalFactory);
	}

	@Override
	public AbstractBinaryOperator getInstance(MutableFormula left, MutableFormula right) {
		return new PowOperator(left, right);
	}

}
