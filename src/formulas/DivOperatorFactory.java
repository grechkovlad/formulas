package formulas;


public class DivOperatorFactory extends AbstractBinaryOperatorFactory {

	public DivOperatorFactory(FormulaFactory[] factories,
			LiteralFactory literalFactory) {
		super(factories, literalFactory);
	}

	@Override
	public DivOperator getInstance(AbstractMutableFormula left, AbstractMutableFormula right) {
		return new DivOperator(left, right);
	}

}
