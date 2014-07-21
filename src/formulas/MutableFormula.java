package formulas;

import java.util.Random;

import formulas.evolutionary.FormulaMutationStrategy;

public interface MutableFormula extends Formula {
	public MutableFormula mutate(Random rnd, FormulaMutationStrategy strategy);
}
