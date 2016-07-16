package de.brotcrunsher.unitTests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runners.JUnit4;

import de.brotcrunsher.math.linear.Vector2;

public class TestVector2 {

	@Test
	public void test() {

		Vector2 v0 = null;
		Vector2 v1 = null;
		Vector2 v2 = null;
		
		float a = 0;
		float b = 0;
		
		v0 = new Vector2(-100, -200);
		v1 = v0.abs();
		assertEquals(v0.getX(), -100, 0);
		assertEquals(v0.getY(), -200, 0);
		assertEquals(v1.getX(), 100, 0);
		assertEquals(v1.getY(), 200, 0);
		v0.absThis();
		assertEquals(v0.getX(), 100, 0);
		assertEquals(v0.getY(), 200, 0);
		
		v0 = new Vector2(100, 200);
		v1 = new Vector2(20, 40);
		v0.addToThis(v1);
		assertEquals(v0.getX(), 120, 0);
		assertEquals(v0.getY(), 240, 0);
		assertEquals(v1.getX(), 20, 0);
		assertEquals(v1.getY(), 40, 0);
		
		v0 = new Vector2(100, 200);
		v0.addToThis(20, 40);
		assertEquals(v0.getX(), 120, 0);
		assertEquals(v0.getY(), 240, 0);
		
		v0 = new Vector2(100, 200);
		v0.addToThisX(20);
		assertEquals(v0.getX(), 120, 0);
		assertEquals(v0.getY(), 200, 0);
		
		v0 = new Vector2(100, 200);
		v0.addToThisY(40);
		assertEquals(v0.getX(), 100, 0);
		assertEquals(v0.getY(), 240, 0);
		
		v0 = new Vector2(100, 200);
		v1 = v0.addX(20);
		assertEquals(v0.getX(), 100, 0);
		assertEquals(v0.getY(), 200, 0);
		assertEquals(v1.getX(), 120, 0);
		assertEquals(v1.getY(), 200, 0);
		
		v0 = new Vector2(100, 200);
		v1 = v0.addY(20);
		assertEquals(v0.getX(), 100, 0);
		assertEquals(v0.getY(), 200, 0);
		assertEquals(v1.getX(), 100, 0);
		assertEquals(v1.getY(), 220, 0);
		
		v0 = new Vector2(100, 200);
		v1 = v0.add(20, 40);
		assertEquals(v0.getX(), 100, 0);
		assertEquals(v0.getY(), 200, 0);
		assertEquals(v1.getX(), 120, 0);
		assertEquals(v1.getY(), 240, 0);
		
		v0 = new Vector2(100, 200);
		v1 = new Vector2(20, 40);
		v2 = v0.add(v1);
		assertEquals(v0.getX(), 100, 0);
		assertEquals(v0.getY(), 200, 0);
		assertEquals(v1.getX(), 20, 0);
		assertEquals(v1.getY(), 40, 0);
		assertEquals(v2.getX(), 120, 0);
		assertEquals(v2.getY(), 240, 0);
		
		v0 = new Vector2(100, 200);
		a = v0.getMax();
		assertEquals(a, 200, 0);
		assertEquals(v0.getX(), 100, 0);
		assertEquals(v0.getY(), 200, 0);
		
		v0 = new Vector2(100, 200);
		a = v0.getMin();
		assertEquals(a, 100, 0);
		assertEquals(v0.getX(), 100, 0);
		assertEquals(v0.getY(), 200, 0);
		
		v0 = new Vector2(100, 200);
		a = v0.getAbsMax();
		assertEquals(a, 200, 0);
		assertEquals(v0.getX(), 100, 0);
		assertEquals(v0.getY(), 200, 0);
		v0 = new Vector2(-100, -200);
		a = v0.getAbsMax();
		assertEquals(a, 200, 0);
		assertEquals(v0.getX(), -100, 0);
		assertEquals(v0.getY(), -200, 0);
		
		v0 = new Vector2(100, 200);
		a = v0.getAbsMin();
		assertEquals(a, 100, 0);
		assertEquals(v0.getX(), 100, 0);
		assertEquals(v0.getY(), 200, 0);
		v0 = new Vector2(-100, -200);
		a = v0.getAbsMin();
		assertEquals(a, 100, 0);
		assertEquals(v0.getX(), -100, 0);
		assertEquals(v0.getY(), -200, 0);
		
		v0 = new Vector2(100, 200);
		v1 = v0.clampComponents(10, 120);
		assertEquals(v0.getX(), 100, 0);
		assertEquals(v0.getY(), 200, 0);
		assertEquals(v1.getX(), 100, 0);
		assertEquals(v1.getY(), 120, 0);
		v1 = v0.clampComponents(120, 400);
		assertEquals(v0.getX(), 100, 0);
		assertEquals(v0.getY(), 200, 0);
		assertEquals(v1.getX(), 120, 0);
		assertEquals(v1.getY(), 200, 0);
		v1 = v0.clampComponents(140, 160);
		assertEquals(v0.getX(), 100, 0);
		assertEquals(v0.getY(), 200, 0);
		assertEquals(v1.getX(), 140, 0);
		assertEquals(v1.getY(), 160, 0);
		
		v0 = new Vector2(100, 200);
		v0.clampComponentsThis(10, 120);
		assertEquals(v0.getX(), 100, 0);
		assertEquals(v0.getY(), 120, 0);
		v0 = new Vector2(100, 200);
		v0.clampComponentsThis(120, 400);
		assertEquals(v0.getX(), 120, 0);
		assertEquals(v0.getY(), 200, 0);
		v0 = new Vector2(100, 200);
		v0.clampComponentsThis(140, 160);
		assertEquals(v0.getX(), 140, 0);
		assertEquals(v0.getY(), 160, 0);
		
		
		assertEquals(new Vector2(0, 0)                .isContainingNaN(), false);
		assertEquals(new Vector2(Float.NaN, 0)        .isContainingNaN(), true);
		assertEquals(new Vector2(0, Float.NaN)        .isContainingNaN(), true);
		assertEquals(new Vector2(Float.NaN, Float.NaN).isContainingNaN(), true);
	}

}
