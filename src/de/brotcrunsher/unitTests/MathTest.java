package de.brotcrunsher.unitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import de.brotcrunsher.math.linear.Math;

public class MathTest {

	@Test
	public void test() {
		assertEquals(Math.mod(0, 3), 0);
		assertEquals(Math.mod(1, 3), 1);
		assertEquals(Math.mod(2, 3), 2);
		assertEquals(Math.mod(3, 3), 0);
		assertEquals(Math.mod(-1, 3), 2);
		assertEquals(Math.mod(-2, 3), 1);
		assertEquals(Math.mod(-3, 3), 0);
		assertEquals(Math.mod(-4, 3), 2);
		assertEquals(Math.mod(-5, 3), 1);
		assertEquals(Math.mod(-6, 3), 0);
		assertEquals(Math.mod(-7, 3), 2);
	}

}
