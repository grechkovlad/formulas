package formulas.evolutionary.examples;

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
import org.uncommons.watchmaker.framework.termination.TargetFitness;

import formulas.AbstractMutableFormula;
import formulas.Formula;
import formulas.evolutionary.FormulaCandidateFactory;
import formulas.evolutionary.FormulaCrossoverOperator;
import formulas.evolutionary.SimpleMutationOperator;

public class Main {

	public static void main(String[] args) {

		CandidateFactory<AbstractMutableFormula> candidateFactory = FormulaCandidateFactory
				.getInstance();
		EvolutionaryOperator<AbstractMutableFormula> mutation = new SimpleMutationOperator(
				0.02);
		FormulaCrossoverOperator crossover = new FormulaCrossoverOperator(2);
		List<EvolutionaryOperator<AbstractMutableFormula>> operators = new ArrayList<EvolutionaryOperator<AbstractMutableFormula>>();
		operators.add(crossover);
		operators.add(mutation);
		EvolutionaryOperator<AbstractMutableFormula> evolutionScheme = new EvolutionPipeline<AbstractMutableFormula>(
				operators);
		FitnessEvaluator<? super AbstractMutableFormula> fitnessEvaluator = new RootFitness();
		SelectionStrategy<? super AbstractMutableFormula> selectionStrategy = new RouletteWheelSelection();
		Random rnd = new MersenneTwisterRNG();
		EvolutionEngine<AbstractMutableFormula> engine = new GenerationalEvolutionEngine<AbstractMutableFormula>(
				candidateFactory, evolutionScheme, fitnessEvaluator,
				selectionStrategy, rnd);
		engine.addEvolutionObserver(new EvolutionObserver<Formula>() {

			@Override
			public void populationUpdate(PopulationData<? extends Formula> data) {
				System.out.println(data.getGenerationNumber());
				System.out.println(data.getBestCandidate());
				System.out.println(data.getBestCandidateFitness());
				System.out.println(data.getMeanFitness() + "\n");
			}
		});
		Formula res = engine.evolve(1000, 2, new TargetFitness(0.1, false));
		System.out.println(res);
	}
}
