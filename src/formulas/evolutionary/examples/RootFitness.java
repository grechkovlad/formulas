package formulas.evolutionary.examples;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.uncommons.watchmaker.framework.FitnessEvaluator;

import formulas.Formula;

public class RootFitness implements FitnessEvaluator<Formula> {

	@Override
	public double getFitness(Formula formula, List<? extends Formula> population) {
		double fitness = 0;
		for (double x = 1; x <= 10; x += 1) {
			Map<String, Double> vals = new HashMap<String, Double>();
			vals.put("x", x);
			double val = formula.eval(vals);
			if (val != val) {
				return Double.MAX_VALUE;
			}
			fitness += Math.abs((val - func(x)) / func(x));
		}
		return fitness;
	}

	private double func(double x) {
		return Math.PI;
	}

	@Override
	public boolean isNatural() {
		return false;
	}

}
