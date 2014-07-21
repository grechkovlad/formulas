package formulas.evolutionary;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.uncommons.watchmaker.framework.EvolutionaryOperator;

import formulas.MutableFormula;

public class FormulaMutationOperator implements
		EvolutionaryOperator<MutableFormula> {

	FormulaMutationStrategy strategy;

	public FormulaMutationOperator(FormulaMutationStrategy strategy) {
		this.strategy = strategy;
	}

	@Override
	public List<MutableFormula> apply(List<MutableFormula> population,
			Random rnd) {
		List<MutableFormula> mutatedPopulation = new ArrayList<MutableFormula>(
				population.size());
		for (MutableFormula formula : population) {
			mutatedPopulation.add(formula.mutate(rnd, strategy));
		}
		return mutatedPopulation;
	}
}
