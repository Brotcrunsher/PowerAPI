package de.brotcrunsher.tests.unitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import de.brotcrunsher.gfx.basics.Color;
import de.brotcrunsher.math.linear.Vector2;

public class TestColor {

	@Test
	public void test() {
		Color c = null;
		Color c2 = null;
		Vector2 v1 = null;
		Vector2 v2 = null;
		
		c = new Color();
		assertEquals(c.getR(), 0, 0);
		assertEquals(c.getG(), 0, 0);
		assertEquals(c.getB(), 0, 0);
		assertEquals(c.getA(), 1, 0);
		
		c = new Color(0.1f);
		assertEquals(c.getR(), 0.1f, 0);
		assertEquals(c.getG(), 0, 0);
		assertEquals(c.getB(), 0, 0);
		assertEquals(c.getA(), 1, 0);
		
		c = new Color(0.1f, 0.2f);
		assertEquals(c.getR(), 0.1f, 0);
		assertEquals(c.getG(), 0.2f, 0);
		assertEquals(c.getB(), 0, 0);
		assertEquals(c.getA(), 1, 0);
		
		c = new Color(0.1f, 0.2f, 0.3f);
		assertEquals(c.getR(), 0.1f, 0);
		assertEquals(c.getG(), 0.2f, 0);
		assertEquals(c.getB(), 0.3f, 0);
		assertEquals(c.getA(), 1, 0);
		
		c = new Color(0.1f, 0.2f, 0.3f, 0.4f);
		assertEquals(c.getR(), 0.1f, 0);
		assertEquals(c.getG(), 0.2f, 0);
		assertEquals(c.getB(), 0.3f, 0);
		assertEquals(c.getA(), 0.4f, 0);
		
		v1 = new Vector2(0.1f, 0.2f);
		c = new Color(v1);
		assertEquals(c.getR(), 0.1f, 0);
		assertEquals(c.getG(), 0.2f, 0);
		assertEquals(c.getB(), 0, 0);
		assertEquals(c.getA(), 1, 0);
		assertEquals(v1.getX(), 0.1f, 0);
		assertEquals(v1.getY(), 0.2f, 0);
		
		v1 = new Vector2(0.1f, 0.2f);
		c = new Color(v1, 0.3f);
		assertEquals(c.getR(), 0.1f, 0);
		assertEquals(c.getG(), 0.2f, 0);
		assertEquals(c.getB(), 0.3f, 0);
		assertEquals(c.getA(), 1, 0);
		assertEquals(v1.getX(), 0.1f, 0);
		assertEquals(v1.getY(), 0.2f, 0);
		
		v1 = new Vector2(0.2f, 0.3f);
		c = new Color(0.1f, v1);
		assertEquals(c.getR(), 0.1f, 0);
		assertEquals(c.getG(), 0.2f, 0);
		assertEquals(c.getB(), 0.3f, 0);
		assertEquals(c.getA(), 1, 0);
		assertEquals(v1.getX(), 0.2f, 0);
		assertEquals(v1.getY(), 0.3f, 0);
		
		v1 = new Vector2(0.1f, 0.2f);
		c = new Color(v1, 0.3f, 0.4f);
		assertEquals(c.getR(), 0.1f, 0);
		assertEquals(c.getG(), 0.2f, 0);
		assertEquals(c.getB(), 0.3f, 0);
		assertEquals(c.getA(), 0.4f, 0);
		assertEquals(v1.getX(), 0.1f, 0);
		assertEquals(v1.getY(), 0.2f, 0);
		
		v1 = new Vector2(0.3f, 0.4f);
		c = new Color(0.1f, 0.2f, v1);
		assertEquals(c.getR(), 0.1f, 0);
		assertEquals(c.getG(), 0.2f, 0);
		assertEquals(c.getB(), 0.3f, 0);
		assertEquals(c.getA(), 0.4f, 0);
		assertEquals(v1.getX(), 0.3f, 0);
		assertEquals(v1.getY(), 0.4f, 0);
		
		v1 = new Vector2(0.1f, 0.2f);
		v2 = new Vector2(0.3f, 0.4f);
		c = new Color(v1, v2);
		assertEquals(c.getR(), 0.1f, 0);
		assertEquals(c.getG(), 0.2f, 0);
		assertEquals(c.getB(), 0.3f, 0);
		assertEquals(c.getA(), 0.4f, 0);
		assertEquals(v1.getX(), 0.1f, 0);
		assertEquals(v1.getY(), 0.2f, 0);
		assertEquals(v2.getX(), 0.3f, 0);
		assertEquals(v2.getY(), 0.4f, 0);
		
		v1 = new Vector2(0.2f, 0.3f);
		c = new Color(0.1f, v1, 0.4f);
		assertEquals(c.getR(), 0.1f, 0);
		assertEquals(c.getG(), 0.2f, 0);
		assertEquals(c.getB(), 0.3f, 0);
		assertEquals(c.getA(), 0.4f, 0);
		assertEquals(v1.getX(), 0.2f, 0);
		assertEquals(v1.getY(), 0.3f, 0);
		
		c = new Color(0.1f, 0.2f, 0.3f, 0.4f);
		c2 = new Color(c);
		assertEquals(c.getR(), 0.1f, 0);
		assertEquals(c.getG(), 0.2f, 0);
		assertEquals(c.getB(), 0.3f, 0);
		assertEquals(c.getA(), 0.4f, 0);
		assertEquals(c2.getR(), 0.1f, 0);
		assertEquals(c2.getG(), 0.2f, 0);
		assertEquals(c2.getB(), 0.3f, 0);
		assertEquals(c2.getA(), 0.4f, 0);
		
		java.awt.Color awtColor = new java.awt.Color(100, 120, 140, 150);
		c = new Color(awtColor);
		assertEquals(awtColor.getRed(), 100, 0);
		assertEquals(awtColor.getGreen(), 120, 0);
		assertEquals(awtColor.getBlue(), 140, 0);
		assertEquals(awtColor.getAlpha(), 150, 0);
		assertEquals(c.getR(), 0.392, 0.001);
		assertEquals(c.getG(), 0.471, 0.001);
		assertEquals(c.getB(), 0.549, 0.001);
		assertEquals(c.getA(), 0.588, 0.001);
		
		c = new Color(0.1f, 0.2f, 0.3f, 0.4f);
		c.setR(1);
		assertEquals(c.getR(), 1f, 0);
		assertEquals(c.getG(), 0.2f, 0);
		assertEquals(c.getB(), 0.3f, 0);
		assertEquals(c.getA(), 0.4f, 0);
		
		c = new Color(0.1f, 0.2f, 0.3f, 0.4f);
		c.setG(1);
		assertEquals(c.getR(), 0.1f, 0);
		assertEquals(c.getG(), 1, 0);
		assertEquals(c.getB(), 0.3f, 0);
		assertEquals(c.getA(), 0.4f, 0);
		
		c = new Color(0.1f, 0.2f, 0.3f, 0.4f);
		c.setB(1);
		assertEquals(c.getR(), 0.1f, 0);
		assertEquals(c.getG(), 0.2f, 0);
		assertEquals(c.getB(), 1, 0);
		assertEquals(c.getA(), 0.4f, 0);
		
		c = new Color(0.1f, 0.2f, 0.3f, 0.4f);
		c.setA(1);
		assertEquals(c.getR(), 0.1f, 0);
		assertEquals(c.getG(), 0.2f, 0);
		assertEquals(c.getB(), 0.3f, 0);
		assertEquals(c.getA(), 1, 0);
		
		c = new Color(0.1f, 0.2f, 0.3f, 0.4f);
		c2 = new Color(0.1f, 0.2f, 0.3f, 0.4f);
		assertEquals(c.equals(c2), true);
		assertEquals(c.equals(c), true);
		assertEquals(c.getR(), 0.1f, 0);
		assertEquals(c.getG(), 0.2f, 0);
		assertEquals(c.getB(), 0.3f, 0);
		assertEquals(c.getA(), 0.4f, 0);
		assertEquals(c2.getR(), 0.1f, 0);
		assertEquals(c2.getG(), 0.2f, 0);
		assertEquals(c2.getB(), 0.3f, 0);
		assertEquals(c2.getA(), 0.4f, 0);
		assertEquals(c.equals(new Object()), false);
		assertEquals(c.getR(), 0.1f, 0);
		assertEquals(c.getG(), 0.2f, 0);
		assertEquals(c.getB(), 0.3f, 0);
		assertEquals(c.getA(), 0.4f, 0);
		c2 = new Color(0.1f, 0.2f, 0.3f, 0.5f);
		assertEquals(c.equals(c2), false);
		assertEquals(c.getR(), 0.1f, 0);
		assertEquals(c.getG(), 0.2f, 0);
		assertEquals(c.getB(), 0.3f, 0);
		assertEquals(c.getA(), 0.4f, 0);
		assertEquals(c2.getR(), 0.1f, 0);
		assertEquals(c2.getG(), 0.2f, 0);
		assertEquals(c2.getB(), 0.3f, 0);
		assertEquals(c2.getA(), 0.5f, 0);
		
		c = new Color(0.1f, 0.2f, 0.3f, 0.4f);
		String string = c.toString();
		assertEquals(c.getR(), 0.1f, 0);
		assertEquals(c.getG(), 0.2f, 0);
		assertEquals(c.getB(), 0.3f, 0);
		assertEquals(c.getA(), 0.4f, 0);
		assertEquals(string.equals("(0.1, 0.2, 0.3, 0.4)"), true);
		
	}

}
