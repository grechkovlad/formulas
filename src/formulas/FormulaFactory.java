package formulas;

import java.util.Random;

public interface FormulaFactory {
	public AbstractMutableFormula getRandomInstance(Random rnd, int depth);

}
