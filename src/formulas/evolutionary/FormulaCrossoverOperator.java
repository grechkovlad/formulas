package formulas.evolutionary;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.uncommons.watchmaker.framework.operators.AbstractCrossover;

import formulas.AbstractMutableFormula;

public class FormulaCrossoverOperator extends
		AbstractCrossover<AbstractMutableFormula> {

	public FormulaCrossoverOperator(int crossoverPoints) {
		super(crossoverPoints);
	}

	@Override
	public List<AbstractMutableFormula> mate(AbstractMutableFormula formula1,
			AbstractMutableFormula formula2, int numberOfCrossoverPoints,
			Random rnd) {
		AbstractMutableFormula forAppending1 = formula2
				.accept(new RandomChooseVisitor(rnd));
		List<AbstractMutableFormula> childrens = new ArrayList<AbstractMutableFormula>();
		childrens.add(formula1.accept(
				new RandomAppendVisitor(rnd, forAppending1)).accept(
				new SimplifierVisitor()));
		AbstractMutableFormula forAppending2 = formula1
				.accept(new RandomChooseVisitor(rnd));
		childrens.add(formula2.accept(
				new RandomAppendVisitor(rnd, forAppending2)).accept(
				new SimplifierVisitor()));
		return childrens;
	}

}
