package formulas;

public class Factories {

	private static final ConstantFactory CONSTANT_FACTORY;
	private static final VariableFactory VARIABLE_FACTORY;

	private static final LiteralFactory LITERAL_FACTORY;

	private static final SumOperatorFactory SUM_OPERATOR_FACTORY;
	private static final SubOperatorFactory SUB_OPERATOR_FACTORY;
	private static final MultOperatorFactory MULT_OPERATOR_FACTORY;
	private static final DivOperatorFactory DIV_OPERATOR_FACTORY;
	private static final PowOperatorFactory POW_OPERATOR_FACTORY;

	private static final BinaryOperatorFactory BINARY_OPERATOR_FACTORY;

	private static final MinusOperatorFactory MINUS_OPERATOR_FACTORY;
	private static final SquareRootFactory SQUARE_ROOT_FACTORY;

	private static final UnaryOperatorFactory UNARY_OPERATOR_FACTORY;

	private static final FormulaFactory[] FACTORIES_COMPRESSED;
	private static final AbstractBinaryOperatorFactory[] BINARY_FACTORIES;
	private static final AbstractUnaryOperatorFactory[] UNARY_FACTORIES;

	static {
		FACTORIES_COMPRESSED = new FormulaFactory[3];
		CONSTANT_FACTORY = new ConstantFactory();
		VARIABLE_FACTORY = new VariableFactory(VariableNames.getNames());
		LITERAL_FACTORY = new LiteralFactory(CONSTANT_FACTORY, VARIABLE_FACTORY);
		SUM_OPERATOR_FACTORY = new SumOperatorFactory(FACTORIES_COMPRESSED,
				LITERAL_FACTORY);
		SUB_OPERATOR_FACTORY = new SubOperatorFactory(FACTORIES_COMPRESSED,
				LITERAL_FACTORY);
		MULT_OPERATOR_FACTORY = new MultOperatorFactory(FACTORIES_COMPRESSED,
				LITERAL_FACTORY);
		DIV_OPERATOR_FACTORY = new DivOperatorFactory(FACTORIES_COMPRESSED,
				LITERAL_FACTORY);
		POW_OPERATOR_FACTORY = new PowOperatorFactory(FACTORIES_COMPRESSED,
				LITERAL_FACTORY);
		BINARY_FACTORIES = new AbstractBinaryOperatorFactory[] {
				SUM_OPERATOR_FACTORY, SUB_OPERATOR_FACTORY,
				MULT_OPERATOR_FACTORY, DIV_OPERATOR_FACTORY,
				POW_OPERATOR_FACTORY };
		BINARY_OPERATOR_FACTORY = new BinaryOperatorFactory(BINARY_FACTORIES);
		MINUS_OPERATOR_FACTORY = new MinusOperatorFactory(FACTORIES_COMPRESSED,
				LITERAL_FACTORY);
		SQUARE_ROOT_FACTORY = new SquareRootFactory(FACTORIES_COMPRESSED,
				LITERAL_FACTORY);
		UNARY_FACTORIES = new AbstractUnaryOperatorFactory[] {
				MINUS_OPERATOR_FACTORY, SQUARE_ROOT_FACTORY };
		UNARY_OPERATOR_FACTORY = new UnaryOperatorFactory(UNARY_FACTORIES);
		FACTORIES_COMPRESSED[0] = LITERAL_FACTORY;
		FACTORIES_COMPRESSED[1] = BINARY_OPERATOR_FACTORY;
		FACTORIES_COMPRESSED[2] = UNARY_OPERATOR_FACTORY;
	}

	public static LiteralFactory getLiteralFactory() {
		return LITERAL_FACTORY;
	}

	public static FormulaFactory[] getAllFactories() {
		return FACTORIES_COMPRESSED;
	}

	public static BinaryOperatorFactory getBinaryOperatorFactory() {
		return BINARY_OPERATOR_FACTORY;
	}

	public static UnaryOperatorFactory getUnaryOperatorFactory() {
		return UNARY_OPERATOR_FACTORY;
	}
}
