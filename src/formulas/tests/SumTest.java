package formulas.tests;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import formulas.Constant;
import formulas.SumOperator;
import formulas.Variable;

public class SumTest {
	@Test
	public void testEval() {
		Map<String, Double> vars = new HashMap<String, Double>();
		vars.put("x", 6.5);
		assertEquals(9.5,
				new SumOperator(new Constant(3), new Variable("x")).eval(vars),
				0);
	}
}
