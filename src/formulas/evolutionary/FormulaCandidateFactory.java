package formulas.evolutionary;

import java.util.Random;

import org.uncommons.watchmaker.framework.factories.AbstractCandidateFactory;

import formulas.Factories;
import formulas.FormulaFactory;
import formulas.MutableFormula;

public class FormulaCandidateFactory extends
		AbstractCandidateFactory<MutableFormula> {

	private int depth;

	public FormulaCandidateFactory(int depth) {
		this.depth = depth;
	}

	@Override
	public MutableFormula generateRandomCandidate(Random rnd) {
		if (depth == 0)
			return Factories.getLiteralFactory().getRandomInstance(rnd, depth);
		FormulaFactory[] factories = Factories.getAllFactories();
		return factories[rnd.nextInt(factories.length)].getRandomInstance(rnd,
				depth);
	}
}