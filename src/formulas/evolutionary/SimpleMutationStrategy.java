package formulas.evolutionary;

public class SimpleMutationStrategy implements FormulaMutationStrategy {

	double prob;

	public SimpleMutationStrategy(double prob) {
		this.prob = prob;
	}

	@Override
	public double getMutationProbability() {
		return prob;
	}

}
