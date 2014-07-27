package formulas.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import formulas.Constant;

public class ConstantTest {
	@Test
	public void testEval() {
		assertEquals(5, new Constant(5).eval(null), 0);
	}
	@Test
	public void testSize(){
		assertEquals(1, new Constant(4).getSubtreeSize());
	}
}
