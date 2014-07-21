package formulas.tests;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import formulas.Constant;
import formulas.PowOperator;
import formulas.Variable;

public class PowTest {
	@Test
	public void testEval() {
		Map<String, Double> vars = new HashMap<String, Double>();
		vars.put("x", 3.0);
		assertEquals(8.0,
				new PowOperator(new Constant(2), new Variable("x")).eval(vars),
				0);
	}
}
