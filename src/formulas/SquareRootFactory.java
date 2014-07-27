package formulas;

public class SquareRootFactory extends AbstractUnaryOperatorFactory {

	public SquareRootFactory(FormulaFactory[] factories,
			LiteralFactory literalFactory) {
		super(factories, literalFactory);
	}

	@Override
	public SquareRootOperator getInstance(AbstractMutableFormula formula) {
		return new SquareRootOperator(formula);
	}

}
