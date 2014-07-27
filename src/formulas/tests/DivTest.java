package formulas.tests;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import formulas.Constant;
import formulas.DivOperator;
import formulas.Variable;

public class DivTest {
	@Test
	public void testEval() {
		Map<String, Double> vars = new HashMap<String, Double>();
		vars.put("x", 4.0);
		assertEquals(
				4,
				new DivOperator(new Constant(16), new Variable("x")).eval(vars),
				0);
	}

	@Test
	public void testSize() {
		assertEquals(3, new DivOperator(new Constant(16), new Variable("x")).getSubtreeSize());
	}
}
