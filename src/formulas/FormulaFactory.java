package formulas;

import java.util.Random;

public interface FormulaFactory {
	public MutableFormula getRandomInstance(Random rnd, int depth);

}
