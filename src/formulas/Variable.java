package formulas;

import java.util.Map;

public class Variable extends AbstractLiteral {

	private String name;

	public Variable(String name) { // TODO check existence in VariableNames
		this.name = name;
	}

	@Override
	public double eval(Map<String, Double> vars) {
		if (!vars.containsKey(name))
			throw new NoSuchVariableException(name);
		return vars.get(name);
	}

	@Override
	public String toString() {
		return name;
	}
}
