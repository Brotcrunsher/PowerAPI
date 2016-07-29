package de.brotcrunsher.tests.unitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import de.brotcrunsher.math.linear.FMath;
import de.brotcrunsher.math.linear.Vector2;
import de.brotcrunsher.math.random.RNG;
import de.brotcrunsher.math.shapes.Circle;
import de.brotcrunsher.math.shapes.Shape;

public class TestShapes {

	@Test
	public void test() {
		Circle c1 = new Circle(new Vector2(), 100);
		Vector2 v1 = new Vector2();
		
		for(int i = 0; i<10000; i++){
			RNG.randomVector2InsideUnitCircle(v1);
			v1.multThis(100);
			assertEquals(true, c1.intersects(v1));
			assertEquals(true, c1.intersects(v1.getX(), v1.getY()));
			assertEquals(true, c1.contains(v1));
			assertEquals(true, c1.contains(v1.getX(), v1.getY()));
		}
		
		for(float i = 0; i<= FMath.PI * 2; i += 0.0001){
			Vector2.newOnCircle(v1, i, 99.9f);
			assertEquals(true, c1.intersects(v1));
			assertEquals(true, c1.intersects(v1.getX(), v1.getY()));
			assertEquals(true, c1.contains(v1));
			assertEquals(true, c1.contains(v1.getX(), v1.getY()));
		}
		
		for(float i = 0; i<= FMath.PI * 2; i += 0.0001){
			Vector2.newOnCircle(v1, i, 100.1f);
			assertEquals(false, c1.intersects(v1));
			assertEquals(false, c1.intersects(v1.getX(), v1.getY()));
			assertEquals(false, c1.contains(v1));
			assertEquals(false, c1.contains(v1.getX(), v1.getY()));
		}
		
		assertEquals(100, c1.getRadius(), 0);
		c1.setRadius(150);
		assertEquals(150, c1.getRadius(), 150);
		
		c1 = new Circle(new Vector2(100, 150), 170);
		assertEquals(100, c1.getX(), 0);
		assertEquals(150, c1.getY(), 0);
		assertEquals(170, c1.getRadius(), 0);
		
		c1 = new Circle(100, 150, 170);
		assertEquals(100, c1.getX(), 0);
		assertEquals(150, c1.getY(), 0);
		assertEquals(100, c1.getCenterX(), 0);
		assertEquals(150, c1.getCenterY(), 0);
		assertEquals(170, c1.getRadius(), 0);
		assertEquals(-70, c1.getLeft(), 0);
		assertEquals(270, c1.getRight(), 0);
		assertEquals(-20, c1.getTop(), 0);
		assertEquals(320, c1.getBottom(), 0);
		
	}

}
