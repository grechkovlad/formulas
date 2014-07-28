package formulas.evolutionary;

import java.util.Random;

import org.uncommons.watchmaker.framework.factories.AbstractCandidateFactory;

import formulas.AbstractMutableFormula;
import formulas.Factories;
import formulas.FormulaFactory;

public class FormulaCandidateFactory extends
		AbstractCandidateFactory<AbstractMutableFormula> {

	private static FormulaCandidateFactory inst;

	private int depth;

	private FormulaCandidateFactory(int depth) {
		this.depth = depth;
	}

	@Override
	public AbstractMutableFormula generateRandomCandidate(Random rnd) {
		return generateRandomCandidate(rnd, depth);
	}

	public AbstractMutableFormula generateRandomCandidate(Random rnd,
			int specificDepth) {
		if (specificDepth == 0)
			return Factories.getLiteralFactory().getRandomInstance(rnd,
					specificDepth);
		FormulaFactory[] factories = Factories.getAllFactories();
		return factories[rnd.nextInt(factories.length)].getRandomInstance(rnd,
				specificDepth);
	}

	public static FormulaCandidateFactory getInstance() {
		if (inst == null)
			inst = new FormulaCandidateFactory(3); // TODO read from config
		return inst;
	}
}