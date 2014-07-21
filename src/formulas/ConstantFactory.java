package formulas;

import java.util.Random;

public class ConstantFactory implements FormulaFactory {

	@Override
	public Constant getRandomInstance(Random rnd, int depth) {
		if (depth < 0)
			throw new IllegalArgumentException("depth must be non-negative");
		return new Constant(rnd.nextDouble());
	}

}
