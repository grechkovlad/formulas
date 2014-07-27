package formulas.evolutionary;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.uncommons.watchmaker.framework.EvolutionaryOperator;

import formulas.AbstractMutableFormula;

public class SimpleMutationOperator implements
		EvolutionaryOperator<AbstractMutableFormula> {

	private double probability;

	public SimpleMutationOperator(double probability) {
		this.probability = probability;
	}

	@Override
	public List<AbstractMutableFormula> apply(
			List<AbstractMutableFormula> population, Random rnd) {
		List<AbstractMutableFormula> newPopulation = new ArrayList<AbstractMutableFormula>();
		for (AbstractMutableFormula formula : population) {
			newPopulation.add(mutate(formula, rnd));
		}
		return newPopulation;
	}

	private AbstractMutableFormula mutate(AbstractMutableFormula formula,
			Random rnd) {
		if (rnd.nextDouble() > probability) {
			return formula.clone();
		}
		return formula.accept(new SimpleMutationVisitor(rnd));
	}
}
