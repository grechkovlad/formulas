package formulas.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import formulas.Constant;
import formulas.MinusOperator;

public class MinusTest {
	@Test
	public void testEval() {
		assertEquals(-8.0, new MinusOperator(new Constant(8.0)).eval(null), 0);
	}
}
