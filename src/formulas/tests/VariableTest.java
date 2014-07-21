package formulas.tests;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import formulas.NoSuchVariableException;
import formulas.Variable;

public class VariableTest {

	Map<String, Double> vars;

	@Before
	public void setUp() {
		vars = new HashMap<String, Double>();
		vars.put("x", 3.0);
	}

	@Test
	public void testEvalCorrect() {
		assertEquals(3, new Variable("x").eval(vars), 0);
	}

	@Test(expected = NoSuchVariableException.class)
	public void testEvalException() {
		Map<String, Double> vars = new HashMap<String, Double>();
		new Variable("y").eval(vars);
	}
}
