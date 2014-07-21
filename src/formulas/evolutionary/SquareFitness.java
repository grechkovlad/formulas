package formulas.evolutionary;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.uncommons.watchmaker.framework.FitnessEvaluator;

import formulas.Formula;

public class SquareFitness implements FitnessEvaluator<Formula> {

	private Random rnd = new Random();

	@Override
	public double getFitness(Formula formula, List<? extends Formula> population) {
		double fitness = 0;
		for (int i = 0; i < 50; i++) {
			double randomPoint = rnd.nextDouble() - 0.5;
			Map<String, Double> vals = new HashMap<String, Double>();
			vals.put("x", randomPoint);
			double val = formula.eval(vals);
			if (val != val) {
				return Double.MAX_VALUE;
			}
			fitness += Math.pow(
					(val - randomPoint * randomPoint) / randomPoint, 2.0);
		}
		return fitness;
	}

	@Override
	public boolean isNatural() {
		return false;
	}

}
