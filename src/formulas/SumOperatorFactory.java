package formulas;


public class SumOperatorFactory extends AbstractBinaryOperatorFactory {

	public SumOperatorFactory(FormulaFactory[] factories,
			LiteralFactory literalFactory) {
		super(factories, literalFactory);
	}

	@Override
	public SumOperator getInstance(AbstractMutableFormula left, AbstractMutableFormula right) {
		return new SumOperator(left, right);
	}

}
