package de.brotcrunsher.unitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import de.brotcrunsher.datastructures.RingArrayLong;

public class TestRingArrayLong {

	@Test
	public void test() {
		RingArrayLong ral = null;
		
		
		
		ral = new RingArrayLong(20);
		assertEquals(ral.getLength(), 20);
		
		for(int i = -20; i<40; i++){
			ral.set(i, i);
			assertEquals(ral.get(i), i);
		}
		
		ral.set(0, -5);
		ral.set(1, -7);
		ral.set(-1, -9);
		assertEquals(ral.get(20), -5);
		assertEquals(ral.get(21), -7);
		assertEquals(ral.get(19), -9);
		assertEquals(ral.get(-20), -5);
		assertEquals(ral.get(-19), -7);
		
		ral = new RingArrayLong(1, 2, 3, 4, 5, 6);
		assertEquals(ral.calculateSum(), 21);
		assertEquals(ral.calculateAvg(), 3.5f, 0);
	}

}
