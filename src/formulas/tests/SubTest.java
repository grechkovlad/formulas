package formulas.tests;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import formulas.Constant;
import formulas.SubOperator;
import formulas.Variable;

public class SubTest {
	@Test
	public void testEval() {
		Map<String, Double> vars = new HashMap<String, Double>();
		vars.put("x", 4.0);
		assertEquals(
				6.0,
				new SubOperator(new Constant(10), new Variable("x")).eval(vars),
				0);
	}
}
