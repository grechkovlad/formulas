package formulas;


public class MinusOperatorFactory extends AbstractUnaryOperatorFactory {

	public MinusOperatorFactory(FormulaFactory[] factories,
			LiteralFactory literalFactory) {
		super(factories, literalFactory);
	}

	@Override
	public MinusOperator getInstance(AbstractMutableFormula formula) {
		return new MinusOperator(formula);
	}

}
