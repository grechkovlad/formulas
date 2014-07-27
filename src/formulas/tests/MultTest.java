package formulas.tests;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import formulas.Constant;
import formulas.MultOperator;
import formulas.Variable;

public class MultTest {
	@Test
	public void testEval() {
		Map<String, Double> vars = new HashMap<String, Double>();
		vars.put("x", 2.0);
		assertEquals(
				12.0,
				new MultOperator(new Constant(6), new Variable("x")).eval(vars),
				0);
	}

	@Test
	public void testSize() {
		assertEquals(3,
				new MultOperator(new Constant(6), new Variable("x"))
						.getSubtreeSize());
	}
}
