import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.uncommons.maths.random.MersenneTwisterRNG;
import org.uncommons.watchmaker.framework.CandidateFactory;
import org.uncommons.watchmaker.framework.EvolutionEngine;
import org.uncommons.watchmaker.framework.EvolutionObserver;
import org.uncommons.watchmaker.framework.EvolutionaryOperator;
import org.uncommons.watchmaker.framework.FitnessEvaluator;
import org.uncommons.watchmaker.framework.GenerationalEvolutionEngine;
import org.uncommons.watchmaker.framework.PopulationData;
import org.uncommons.watchmaker.framework.SelectionStrategy;
import org.uncommons.watchmaker.framework.operators.EvolutionPipeline;
import org.uncommons.watchmaker.framework.selection.RouletteWheelSelection;
import org.uncommons.watchmaker.framework.termination.GenerationCount;
import org.uncommons.watchmaker.framework.termination.Stagnation;

import formulas.MutableFormula;
import formulas.evolutionary.FormulaCandidateFactory;
import formulas.evolutionary.FormulaCrossoverOperator;
import formulas.evolutionary.FormulaMutationOperator;
import formulas.evolutionary.SimpleMutationStrategy;
import formulas.evolutionary.SquareFitness;

public class Main {

	public static void main(String[] args) {
		CandidateFactory<MutableFormula> candidateFactory = new FormulaCandidateFactory(
				1);
		EvolutionaryOperator<MutableFormula> mutation = new FormulaMutationOperator(
				new SimpleMutationStrategy(0.1));
		EvolutionaryOperator<MutableFormula> crossover = new FormulaCrossoverOperator(
				2);
		List<EvolutionaryOperator<MutableFormula>> operators = new ArrayList<EvolutionaryOperator<MutableFormula>>();
		operators.add(crossover);
		operators.add(mutation);
		EvolutionaryOperator<MutableFormula> evolutionScheme = new EvolutionPipeline<MutableFormula>(
				operators);
		FitnessEvaluator<? super MutableFormula> fitnessEvaluator = new SquareFitness();
		SelectionStrategy<? super MutableFormula> selectionStrategy = new RouletteWheelSelection();
		Random rnd = new MersenneTwisterRNG();
		EvolutionEngine<MutableFormula> engine = new GenerationalEvolutionEngine<MutableFormula>(
				candidateFactory, evolutionScheme, fitnessEvaluator,
				selectionStrategy, rnd);
		engine.addEvolutionObserver(new EvolutionObserver<MutableFormula>() {

			@Override
			public void populationUpdate(
					PopulationData<? extends MutableFormula> data) {
				System.out.println(data.getGenerationNumber());
				System.out.println(data.getBestCandidate());
				System.out.println(data.getBestCandidateFitness() + "\n");
			}
		});
		MutableFormula res = engine.evolve(20, 1, new GenerationCount(1000));
	}
}
