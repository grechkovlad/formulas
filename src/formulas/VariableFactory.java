package formulas;

import java.util.Random;

public class VariableFactory implements FormulaFactory {

	private String names[];

	public VariableFactory(String names[]) {
		if (names.length == 0)
			throw new IllegalArgumentException("empty array");
		this.names = names;
	}

	@Override
	public Variable getRandomInstance(Random rnd, int depth) {
		if (depth < 0)
			throw new IllegalArgumentException("depth must be non-negative");
		return new Variable(names[rnd.nextInt(names.length)]);

	}

}
