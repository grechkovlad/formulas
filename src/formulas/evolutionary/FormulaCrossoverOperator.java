package formulas.evolutionary;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.uncommons.watchmaker.framework.operators.AbstractCrossover;

import formulas.Constant;
import formulas.MultOperator;
import formulas.MutableFormula;
import formulas.SumOperator;

public class FormulaCrossoverOperator extends AbstractCrossover<MutableFormula> {

	public FormulaCrossoverOperator(int crossoverPoints) {
		super(crossoverPoints);
	}

	@Override
	protected List<MutableFormula> mate(MutableFormula formula1,
			MutableFormula formula2, int numberOfCrossoverPoints, Random rnd) {
		List<MutableFormula> chilrens = new ArrayList<MutableFormula>();
		for (int i = 0; i < numberOfCrossoverPoints; i++) {
			double c = rnd.nextDouble();
			chilrens.add(new SumOperator(new MultOperator(new Constant(c),
					formula1), new MultOperator(new Constant(1 - c), formula2)));
		}
		return chilrens;
	}

}
