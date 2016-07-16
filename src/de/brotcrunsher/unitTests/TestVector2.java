package de.brotcrunsher.unitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import de.brotcrunsher.math.linear.Math;
import de.brotcrunsher.math.linear.Vector2;

public class TestVector2 {

	@Test
	public void test() {

		Vector2 v0 = null;
		Vector2 v1 = null;
		Vector2 v2 = null;
		
		float a = 0;
		
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
		
		v0 = Vector2.newOnCircle(0);
		assertEquals(v0.getX(), 1, 0);
		assertEquals(v0.getY(), 0, 0);
		v0 = Vector2.newOnCircle(Math.PI / 2);
		assertEquals(v0.getX(), 0, 0.01);
		assertEquals(v0.getY(), 1, 0.01);
		v0 = Vector2.newOnCircle(Math.PI);
		assertEquals(v0.getX(), -1, 0.01);
		assertEquals(v0.getY(),  0, 0.01);
		v0 = Vector2.newOnCircle(Math.PI * 3 / 2);
		assertEquals(v0.getX(), 0, 0.01);
		assertEquals(v0.getY(), -1, 0.01);
		v0 = Vector2.newOnCircle(Math.PI * 2);
		assertEquals(v0.getX(), 1, 0);
		assertEquals(v0.getY(), 0, 0);
		v0 = Vector2.newOnCircle(-Math.PI / 2);
		assertEquals(v0.getX(), 0, 0.01);
		assertEquals(v0.getY(), -1, 0.01);
		v0 = Vector2.newOnCircle(-Math.PI);
		assertEquals(v0.getX(), -1, 0.01);
		assertEquals(v0.getY(), 0, 0.01);
		v0 = Vector2.newOnCircle(-Math.PI * 3 / 2);
		assertEquals(v0.getX(), 0, 0.01);
		assertEquals(v0.getY(), 1, 0.01);
		v0 = Vector2.newOnCircle(-Math.PI * 2);
		assertEquals(v0.getX(), 1, 0.01);
		assertEquals(v0.getY(), 0, 0.01);
		
		v0 = Vector2.newOnCircle(0, 2);
		assertEquals(v0.getX(), 2, 0);
		assertEquals(v0.getY(), 0, 0);
		v0 = Vector2.newOnCircle(Math.PI / 2, 2);
		assertEquals(v0.getX(), 0, 0.01);
		assertEquals(v0.getY(), 2, 0.01);
		v0 = Vector2.newOnCircle(Math.PI, 2);
		assertEquals(v0.getX(), -2, 0.01);
		assertEquals(v0.getY(),  0, 0.01);
		v0 = Vector2.newOnCircle(Math.PI * 3 / 2, 2);
		assertEquals(v0.getX(), 0, 0.01);
		assertEquals(v0.getY(), -2, 0.01);
		v0 = Vector2.newOnCircle(Math.PI * 2, 2);
		assertEquals(v0.getX(), 2, 0);
		assertEquals(v0.getY(), 0, 0);
		v0 = Vector2.newOnCircle(-Math.PI / 2, 2);
		assertEquals(v0.getX(), 0, 0.01);
		assertEquals(v0.getY(), -2, 0.01);
		v0 = Vector2.newOnCircle(-Math.PI, 2);
		assertEquals(v0.getX(), -2, 0.01);
		assertEquals(v0.getY(), 0, 0.01);
		v0 = Vector2.newOnCircle(-Math.PI * 3 / 2, 2);
		assertEquals(v0.getX(), 0, 0.01);
		assertEquals(v0.getY(), 2, 0.01);
		v0 = Vector2.newOnCircle(-Math.PI * 2, 2);
		assertEquals(v0.getX(), 2, 0.01);
		assertEquals(v0.getY(), 0, 0.01);
		
		v0 = new Vector2();
		assertEquals(v0.getX(), 0, 0);
		assertEquals(v0.getY(), 0, 0);
		
		v0 = new Vector2(20);
		assertEquals(v0.getX(), 20, 0);
		assertEquals(v0.getY(), 0, 0);
		
		v0 = new Vector2(20, 40);
		assertEquals(v0.getX(), 20, 0);
		assertEquals(v0.getY(), 40, 0);
		
		v0 = new Vector2(20, 40);
		v1 = new Vector2(v0);
		assertEquals(v0.getX(), 20, 0);
		assertEquals(v0.getY(), 40, 0);
		assertEquals(v1.getX(), 20, 0);
		assertEquals(v1.getY(), 40, 0);
		
		v0 = new Vector2(2, 4);
		assertEquals(v0.lengthSq(), 20, 0);
		assertEquals(v0.getX(), 2, 0);
		assertEquals(v0.getY(), 4, 0);
		assertEquals(v0.length(), 4.472, 0.01);
		assertEquals(v0.getX(), 2, 0);
		assertEquals(v0.getY(), 4, 0);
		
		
		v0 = new Vector2(20, 40);
		v1 = new Vector2(-30, 70);
		assertEquals(v0.isShorterThan(v1), true);
		assertEquals(v0.getX(), 20, 0);
		assertEquals(v0.getY(), 40, 0);
		assertEquals(v1.getX(), -30, 0);
		assertEquals(v1.getY(), 70, 0);
		assertEquals(v0.isLongerThan(v1), false);
		assertEquals(v0.getX(), 20, 0);
		assertEquals(v0.getY(), 40, 0);
		assertEquals(v1.getX(), -30, 0);
		assertEquals(v1.getY(), 70, 0);
		
		
		v0 = new Vector2(20, 40);
		v1 = new Vector2(-20, 40);
		assertEquals(v0.isSameLength(v1), true);
		assertEquals(v0.getX(), 20, 0);
		assertEquals(v0.getY(), 40, 0);
		assertEquals(v1.getX(), -20, 0);
		assertEquals(v1.getY(), 40, 0);
		v0 = new Vector2(20, 41);
		v1 = new Vector2(-20, 40);
		assertEquals(v0.isSameLength(v1), false);
		assertEquals(v0.getX(), 20, 0);
		assertEquals(v0.getY(), 41, 0);
		assertEquals(v1.getX(), -20, 0);
		assertEquals(v1.getY(), 40, 0);
		
		v0 = new Vector2(20, 40);
		v1 = new Vector2(-20, 40);
		assertEquals(v0.isSameLength(v1, 1), true);
		assertEquals(v0.getX(), 20, 0);
		assertEquals(v0.getY(), 40, 0);
		assertEquals(v1.getX(), -20, 0);
		assertEquals(v1.getY(), 40, 0);
		v0 = new Vector2(20, 41);
		v1 = new Vector2(-20, 40);
		assertEquals(v0.isSameLength(v1, 1), true);
		assertEquals(v0.getX(), 20, 0);
		assertEquals(v0.getY(), 41, 0);
		assertEquals(v1.getX(), -20, 0);
		assertEquals(v1.getY(), 40, 0);
		v0 = new Vector2(20, 42);
		v1 = new Vector2(-20, 40);
		assertEquals(v0.isSameLength(v1, 1), false);
		assertEquals(v0.getX(), 20, 0);
		assertEquals(v0.getY(), 42, 0);
		assertEquals(v1.getX(), -20, 0);
		assertEquals(v1.getY(), 40, 0);
		
		v0 = Vector2.newOnCircle(0);
		v1 = Vector2.newOnCircle(Math.PI / 3);
		v2 = new Vector2(v1);
		assertEquals(v0.isSameDirection(v1), true);
		assertEquals(v0.getX(), 1, 0);
		assertEquals(v0.getY(), 0, 0);
		assertEquals(v1.getX(), v2.getX(), 0);
		assertEquals(v1.getY(), v2.getY(), 0);
		v1 = Vector2.newOnCircle(Math.PI * 2 / 3);
		v2 = new Vector2(v1);
		assertEquals(v0.isSameDirection(v1), false);
		assertEquals(v0.getX(), 1, 0);
		assertEquals(v0.getY(), 0, 0);
		assertEquals(v1.getX(), v2.getX(), 0);
		assertEquals(v1.getY(), v2.getY(), 0);
		
		v0 = Vector2.newOnCircle(0);
		v1 = Vector2.newOnCircle(Math.PI / 3);
		v2 = new Vector2(v1);
		assertEquals(v0.isOppositeDirection(v1), false);
		assertEquals(v0.getX(), 1, 0);
		assertEquals(v0.getY(), 0, 0);
		assertEquals(v1.getX(), v2.getX(), 0);
		assertEquals(v1.getY(), v2.getY(), 0);
		v1 = Vector2.newOnCircle(Math.PI * 2 / 3);
		v2 = new Vector2(v1);
		assertEquals(v0.isOppositeDirection(v1), true);
		assertEquals(v0.getX(), 1, 0);
		assertEquals(v0.getY(), 0, 0);
		assertEquals(v1.getX(), v2.getX(), 0);
		assertEquals(v1.getY(), v2.getY(), 0);
		
		v0 = Vector2.newOnCircle(0);
		v1 = Vector2.newOnCircle(Math.PI / 3);
		v2 = new Vector2(v1);
		assertEquals(v1.isRightOf(v0), true);
		assertEquals(v0.getX(), 1, 0);
		assertEquals(v0.getY(), 0, 0);
		assertEquals(v1.getX(), v2.getX(), 0);
		assertEquals(v1.getY(), v2.getY(), 0);
		v1 = Vector2.newOnCircle(-Math.PI / 3);
		v2 = new Vector2(v1);
		assertEquals(v1.isRightOf(v0), false);
		assertEquals(v0.getX(), 1, 0);
		assertEquals(v0.getY(), 0, 0);
		assertEquals(v1.getX(), v2.getX(), 0);
		assertEquals(v1.getY(), v2.getY(), 0);
		
		v0 = Vector2.newOnCircle(0);
		v1 = Vector2.newOnCircle(Math.PI / 3);
		v2 = new Vector2(v1);
		assertEquals(v1.isLeftOf(v0), false);
		assertEquals(v0.getX(), 1, 0);
		assertEquals(v0.getY(), 0, 0);
		assertEquals(v1.getX(), v2.getX(), 0);
		assertEquals(v1.getY(), v2.getY(), 0);
		v1 = Vector2.newOnCircle(-Math.PI / 3);
		v2 = new Vector2(v1);
		assertEquals(v1.isLeftOf(v0), true);
		assertEquals(v0.getX(), 1, 0);
		assertEquals(v0.getY(), 0, 0);
		assertEquals(v1.getX(), v2.getX(), 0);
		assertEquals(v1.getY(), v2.getY(), 0);
		
		v0 = new Vector2(10, 20);
		v1 = new Vector2(11, 19);
		assertEquals(v0.isComponentsEqual(v1, 1), true);
		assertEquals(v0.getX(), 10, 0);
		assertEquals(v0.getY(), 20, 0);
		assertEquals(v1.getX(), 11, 0);
		assertEquals(v1.getY(), 19, 0);
		assertEquals(v0.isComponentsEqual(v1, 0), false);
		assertEquals(v0.getX(), 10, 0);
		assertEquals(v0.getY(), 20, 0);
		assertEquals(v1.getX(), 11, 0);
		assertEquals(v1.getY(), 19, 0);
		
		v0 = new Vector2(10, 20);
		assertEquals(v0.isContainingAnyInfinity(), false);
		assertEquals(v0.getX(), 10, 0);
		assertEquals(v0.getY(), 20, 0);
		v0 = new Vector2(Float.POSITIVE_INFINITY, 20);
		assertEquals(v0.isContainingAnyInfinity(), true);
		assertEquals(v0.getX(), Float.POSITIVE_INFINITY, 0);
		assertEquals(v0.getY(), 20, 0);
		v0 = new Vector2(Float.NEGATIVE_INFINITY, 20);
		assertEquals(v0.isContainingAnyInfinity(), true);
		assertEquals(v0.getX(), Float.NEGATIVE_INFINITY, 0);
		assertEquals(v0.getY(), 20, 0);
		v0 = new Vector2(10, Float.POSITIVE_INFINITY);
		assertEquals(v0.isContainingAnyInfinity(), true);
		assertEquals(v0.getX(), 10, 0);
		assertEquals(v0.getY(), Float.POSITIVE_INFINITY, 0);
		v0 = new Vector2(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY);
		assertEquals(v0.isContainingAnyInfinity(), true);
		assertEquals(v0.getX(), Float.POSITIVE_INFINITY, 0);
		assertEquals(v0.getY(), Float.POSITIVE_INFINITY, 0);
		v0 = new Vector2(Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY);
		assertEquals(v0.isContainingAnyInfinity(), true);
		assertEquals(v0.getX(), Float.NEGATIVE_INFINITY, 0);
		assertEquals(v0.getY(), Float.POSITIVE_INFINITY, 0);
		v0 = new Vector2(10, Float.NEGATIVE_INFINITY);
		assertEquals(v0.isContainingAnyInfinity(), true);
		assertEquals(v0.getX(), 10, 0);
		assertEquals(v0.getY(), Float.NEGATIVE_INFINITY, 0);
		v0 = new Vector2(Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY);
		assertEquals(v0.isContainingAnyInfinity(), true);
		assertEquals(v0.getX(), Float.POSITIVE_INFINITY, 0);
		assertEquals(v0.getY(), Float.NEGATIVE_INFINITY, 0);
		v0 = new Vector2(Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY);
		assertEquals(v0.isContainingAnyInfinity(), true);
		assertEquals(v0.getX(), Float.NEGATIVE_INFINITY, 0);
		assertEquals(v0.getY(), Float.NEGATIVE_INFINITY, 0);
		
		v0 = Vector2.newOnCircle(0);
		v1 = new Vector2(v0);
		assertEquals(v0.isUnit(), true);
		assertEquals(v0.getX(), v1.getX(), 0);
		assertEquals(v0.getY(), v1.getY(), 0);
		v0 = Vector2.newOnCircle(1);
		v1 = new Vector2(v0);
		assertEquals(v0.isUnit(), true);
		assertEquals(v0.getX(), v1.getX(), 0);
		assertEquals(v0.getY(), v1.getY(), 0);
		v0 = Vector2.newOnCircle(2);
		v1 = new Vector2(v0);
		assertEquals(v0.isUnit(), true);
		assertEquals(v0.getX(), v1.getX(), 0);
		assertEquals(v0.getY(), v1.getY(), 0);
		v0 = Vector2.newOnCircle(3);
		v1 = new Vector2(v0);
		assertEquals(v0.isUnit(), true);
		assertEquals(v0.getX(), v1.getX(), 0);
		assertEquals(v0.getY(), v1.getY(), 0);
		v0 = Vector2.newOnCircle(4);
		v1 = new Vector2(v0);
		assertEquals(v0.isUnit(), true);
		assertEquals(v0.getX(), v1.getX(), 0);
		assertEquals(v0.getY(), v1.getY(), 0);
		v0 = Vector2.newOnCircle(5);
		v1 = new Vector2(v0);
		assertEquals(v0.isUnit(), true);
		assertEquals(v0.getX(), v1.getX(), 0);
		assertEquals(v0.getY(), v1.getY(), 0);
		v0 = Vector2.newOnCircle(6);
		v1 = new Vector2(v0);
		assertEquals(v0.isUnit(), true);
		assertEquals(v0.getX(), v1.getX(), 0);
		assertEquals(v0.getY(), v1.getY(), 0);
		v0 = Vector2.newOnCircle(0, 2);
		v1 = new Vector2(v0);
		assertEquals(v0.isUnit(), false);
		assertEquals(v0.getX(), v1.getX(), 0);
		assertEquals(v0.getY(), v1.getY(), 0);
		v0 = Vector2.newOnCircle(1, 2);
		v1 = new Vector2(v0);
		assertEquals(v0.isUnit(), false);
		assertEquals(v0.getX(), v1.getX(), 0);
		assertEquals(v0.getY(), v1.getY(), 0);
		v0 = Vector2.newOnCircle(2, 2);
		v1 = new Vector2(v0);
		assertEquals(v0.isUnit(), false);
		assertEquals(v0.getX(), v1.getX(), 0);
		assertEquals(v0.getY(), v1.getY(), 0);
		v0 = Vector2.newOnCircle(3, 2);
		v1 = new Vector2(v0);
		assertEquals(v0.isUnit(), false);
		assertEquals(v0.getX(), v1.getX(), 0);
		assertEquals(v0.getY(), v1.getY(), 0);
		v0 = Vector2.newOnCircle(4, 2);
		v1 = new Vector2(v0);
		assertEquals(v0.isUnit(), false);
		assertEquals(v0.getX(), v1.getX(), 0);
		assertEquals(v0.getY(), v1.getY(), 0);
		v0 = Vector2.newOnCircle(5, 2);
		v1 = new Vector2(v0);
		assertEquals(v0.isUnit(), false);
		assertEquals(v0.getX(), v1.getX(), 0);
		assertEquals(v0.getY(), v1.getY(), 0);
		v0 = Vector2.newOnCircle(6, 2);
		v1 = new Vector2(v0);
		assertEquals(v0.isUnit(), false);
		assertEquals(v0.getX(), v1.getX(), 0);
		assertEquals(v0.getY(), v1.getY(), 0);
		v0 = Vector2.newOnCircle(0, .5f);
		v1 = new Vector2(v0);
		assertEquals(v0.isUnit(), false);
		assertEquals(v0.getX(), v1.getX(), 0);
		assertEquals(v0.getY(), v1.getY(), 0);
		v0 = Vector2.newOnCircle(1, .5f);
		v1 = new Vector2(v0);
		assertEquals(v0.isUnit(), false);
		assertEquals(v0.getX(), v1.getX(), 0);
		assertEquals(v0.getY(), v1.getY(), 0);
		v0 = Vector2.newOnCircle(2, .5f);
		v1 = new Vector2(v0);
		assertEquals(v0.isUnit(), false);
		assertEquals(v0.getX(), v1.getX(), 0);
		assertEquals(v0.getY(), v1.getY(), 0);
		v0 = Vector2.newOnCircle(3, .5f);
		v1 = new Vector2(v0);
		assertEquals(v0.isUnit(), false);
		assertEquals(v0.getX(), v1.getX(), 0);
		assertEquals(v0.getY(), v1.getY(), 0);
		v0 = Vector2.newOnCircle(4, .5f);
		v1 = new Vector2(v0);
		assertEquals(v0.isUnit(), false);
		assertEquals(v0.getX(), v1.getX(), 0);
		assertEquals(v0.getY(), v1.getY(), 0);
		v0 = Vector2.newOnCircle(5, .5f);
		v1 = new Vector2(v0);
		assertEquals(v0.isUnit(), false);
		assertEquals(v0.getX(), v1.getX(), 0);
		assertEquals(v0.getY(), v1.getY(), 0);
		v0 = Vector2.newOnCircle(6, .5f);
		v1 = new Vector2(v0);
		assertEquals(v0.isUnit(), false);
		assertEquals(v0.getX(), v1.getX(), 0);
		assertEquals(v0.getY(), v1.getY(), 0);
		
		v0 = new Vector2(1, 0);
		v1 = new Vector2(30, 0);
		assertEquals(v0.distanceTo(v1), 29, 0);
		assertEquals(v0.getX(), 1, 0);
		assertEquals(v0.getY(), 0, 0);
		assertEquals(v1.getX(), 30, 0);
		assertEquals(v1.getY(), 0, 0);
		v0 = new Vector2(1, 0);
		v1 = new Vector2(0, 1);
		assertEquals(v0.distanceTo(v1), Math.sqrt(2), 0.001);
		assertEquals(v0.getX(), 1, 0);
		assertEquals(v0.getY(), 0, 0);
		assertEquals(v1.getX(), 0, 0);
		assertEquals(v1.getY(), 1, 0);
		
		v0 = new Vector2(1, 0);
		v1 = new Vector2(30, 0);
		assertEquals(Vector2.distanceBetween(v0, v1), 29, 0);
		assertEquals(v0.getX(), 1, 0);
		assertEquals(v0.getY(), 0, 0);
		assertEquals(v1.getX(), 30, 0);
		assertEquals(v1.getY(), 0, 0);
		v0 = new Vector2(1, 0);
		v1 = new Vector2(0, 1);
		assertEquals(Vector2.distanceBetween(v0, v1), Math.sqrt(2), 0.001);
		assertEquals(v0.getX(), 1, 0);
		assertEquals(v0.getY(), 0, 0);
		assertEquals(v1.getX(), 0, 0);
		assertEquals(v1.getY(), 1, 0);
		
		v0 = new Vector2(1, 0);
		v1 = new Vector2(30, 0);
		assertEquals(Vector2.distanceBetweenSq(v0, v1), 29*29, 0);
		assertEquals(v0.getX(), 1, 0);
		assertEquals(v0.getY(), 0, 0);
		assertEquals(v1.getX(), 30, 0);
		assertEquals(v1.getY(), 0, 0);
		v0 = new Vector2(1, 0);
		v1 = new Vector2(0, 1);
		assertEquals(Vector2.distanceBetweenSq(v0, v1), 2, 0);
		assertEquals(v0.getX(), 1, 0);
		assertEquals(v0.getY(), 0, 0);
		assertEquals(v1.getX(), 0, 0);
		assertEquals(v1.getY(), 1, 0);
		
		v0 = new Vector2(1, 0);
		v1 = new Vector2(30, 0);
		assertEquals(v0.isCloseTo(v1, 29), true);
		assertEquals(v0.getX(), 1, 0);
		assertEquals(v0.getY(), 0, 0);
		assertEquals(v1.getX(), 30, 0);
		assertEquals(v1.getY(), 0, 0);
		assertEquals(v0.isCloseTo(v1, 28.9f), false);
		assertEquals(v0.getX(), 1, 0);
		assertEquals(v0.getY(), 0, 0);
		assertEquals(v1.getX(), 30, 0);
		assertEquals(v1.getY(), 0, 0);
		v0 = new Vector2(1, 0);
		v1 = new Vector2(0, 1);
		assertEquals(v0.isCloseTo(v1, 2), true);
		assertEquals(v0.getX(), 1, 0);
		assertEquals(v0.getY(), 0, 0);
		assertEquals(v1.getX(), 0, 0);
		assertEquals(v1.getY(), 1, 0);
		assertEquals(v0.isCloseTo(v1, 1.4f), false);
		assertEquals(v0.getX(), 1, 0);
		assertEquals(v0.getY(), 0, 0);
		assertEquals(v1.getX(), 0, 0);
		assertEquals(v1.getY(), 1, 0);
		
		v0 = new Vector2(1, 1);
		v1 = new Vector2(1, 0);
		v2 = v0.mirrorByVector(v1);
		assertEquals(v0.getX(), 1, 0);
		assertEquals(v0.getY(), 1, 0);
		assertEquals(v1.getX(), 1, 0);
		assertEquals(v1.getY(), 0, 0);
		assertEquals(v2.getX(), 1, 0);
		assertEquals(v2.getY(), -1, 0);
		v0 = new Vector2(1, 1);
		v1 = new Vector2(20, 0);
		v2 = v0.mirrorByVector(v1);
		assertEquals(v0.getX(), 1, 0);
		assertEquals(v0.getY(), 1, 0);
		assertEquals(v1.getX(), 20, 0);
		assertEquals(v1.getY(), 0, 0);
		assertEquals(v2.getX(), 1, 0);
		assertEquals(v2.getY(), -1, 0);
		v0 = new Vector2(1, 1);
		v1 = new Vector2(20, 0);
		v2 = v1.mirrorByVector(v0);
		assertEquals(v0.getX(), 1, 0);
		assertEquals(v0.getY(), 1, 0);
		assertEquals(v1.getX(), 20, 0);
		assertEquals(v1.getY(), 0, 0);
		assertEquals(v2.getX(), 0, 0);
		assertEquals(v2.getY(), 20, 0);
		v0 = new Vector2(100, 100);
		v1 = new Vector2(20, 0);
		v2 = v1.mirrorByVector(v0);
		assertEquals(v0.getX(), 100, 0);
		assertEquals(v0.getY(), 100, 0);
		assertEquals(v1.getX(), 20, 0);
		assertEquals(v1.getY(), 0, 0);
		assertEquals(v2.getX(), 0, 0);
		assertEquals(v2.getY(), 20, 0);
		
		v0 = new Vector2(1, 1);
		v1 = new Vector2(1, 0);
		v0.mirrorByVectorThis(v1);
		assertEquals(v0.getX(), 1, 0);
		assertEquals(v0.getY(), -1, 0);
		assertEquals(v1.getX(), 1, 0);
		assertEquals(v1.getY(), 0, 0);
		v0 = new Vector2(1, 1);
		v1 = new Vector2(20, 0);
		v0.mirrorByVectorThis(v1);
		assertEquals(v0.getX(), 1, 0);
		assertEquals(v0.getY(), -1, 0);
		assertEquals(v1.getX(), 20, 0);
		assertEquals(v1.getY(), 0, 0);
		v0 = new Vector2(1, 1);
		v1 = new Vector2(20, 0);
		v1.mirrorByVectorThis(v0);
		assertEquals(v0.getX(), 1, 0);
		assertEquals(v0.getY(), 1, 0);
		assertEquals(v1.getX(), 0, 0);
		assertEquals(v1.getY(), 20, 0);
		v0 = new Vector2(100, 100);
		v1 = new Vector2(20, 0);
		v1.mirrorByVectorThis(v0);
		assertEquals(v0.getX(), 100, 0);
		assertEquals(v0.getY(), 100, 0);
		assertEquals(v1.getX(), 0, 0);
		assertEquals(v1.getY(), 20, 0);
		
		v0 = new Vector2(1, 0);
		v1 = v0.normalized();
		assertEquals(v0.getX(), 1, 0);
		assertEquals(v0.getY(), 0, 0);
		assertEquals(v1.getX(), 1, 0);
		assertEquals(v1.getY(), 0, 0);
		v0 = new Vector2(10, 0);
		v1 = v0.normalized();
		assertEquals(v0.getX(), 10, 0);
		assertEquals(v0.getY(), 0, 0);
		assertEquals(v1.getX(), 1, 0);
		assertEquals(v1.getY(), 0, 0);
		v0 = new Vector2(1, 1);
		v1 = v0.normalized();
		assertEquals(v0.getX(), 1, 0);
		assertEquals(v0.getY(), 1, 0);
		assertEquals(v1.getX(), 1/Math.sqrt(2), 0.0001);
		assertEquals(v1.getY(), 1/Math.sqrt(2), 0.0001);
		
		v0 = new Vector2(1, 0);
		v0.normalizeThis();
		assertEquals(v0.getX(), 1, 0);
		assertEquals(v0.getY(), 0, 0);
		v0 = new Vector2(10, 0);
		v0.normalizeThis();
		assertEquals(v0.getX(), 1, 0);
		assertEquals(v0.getY(), 0, 0);
		v0 = new Vector2(1, 1);
		v0.normalizeThis();
		assertEquals(v0.getX(), 1/Math.sqrt(2), 0.0001);
		assertEquals(v0.getY(), 1/Math.sqrt(2), 0.0001);
		
		v0 = new Vector2(0, 0);
		assertEquals(v0.isZero(), true);
		assertEquals(v0.getX(), 0, 0);
		assertEquals(v0.getY(), 0, 0);
		v0 = new Vector2(1, 0);
		assertEquals(v0.isZero(), false);
		assertEquals(v0.getX(), 1, 0);
		assertEquals(v0.getY(), 0, 0);
		v0 = new Vector2(0, 1);
		assertEquals(v0.isZero(), false);
		assertEquals(v0.getX(), 0, 0);
		assertEquals(v0.getY(), 1, 0);
		v0 = new Vector2(1, 1);
		assertEquals(v0.isZero(), false);
		assertEquals(v0.getX(), 1, 0);
		assertEquals(v0.getY(), 1, 0);
		
		v0 = new Vector2(10, 20);
		v0.flipThis();
		assertEquals(v0.getX(), 20, 0);
		assertEquals(v0.getY(), 10, 0);
		
		v0 = new Vector2(10, 20);
		v1 = v0.flip();
		assertEquals(v0.getX(), 10, 0);
		assertEquals(v0.getY(), 20, 0);
		assertEquals(v1.getX(), 20, 0);
		assertEquals(v1.getY(), 10, 0);
		
		v0 = new Vector2(1, 1);
		v0.rotate90ClockwiseThis();
		assertEquals(v0.getX(), -1, 0);
		assertEquals(v0.getY(), 1, 0);
		
		v0 = new Vector2(1, 1);
		v0.rotate90CounterclockwiseThis();
		assertEquals(v0.getX(), 1, 0);
		assertEquals(v0.getY(), -1, 0);
		
		v0 = new Vector2(1, 1);
		v1 = v0.rotate90Clockwise();
		assertEquals(v0.getX(), 1, 0);
		assertEquals(v0.getY(), 1, 0);
		assertEquals(v1.getX(), -1, 0);
		assertEquals(v1.getY(), 1, 0);
		
		v0 = new Vector2(1, 1);
		v1 = v0.rotate90Counterclockwise();
		assertEquals(v0.getX(), 1, 0);
		assertEquals(v0.getY(), 1, 0);
		assertEquals(v1.getX(), 1, 0);
		assertEquals(v1.getY(), -1, 0);
		
		
		v0 = new Vector2(10, 20);
		v0.setX(30);
		assertEquals(v0.getX(), 30, 0);
		assertEquals(v0.getY(), 20, 0);
		
		v0 = new Vector2(10, 20);
		v0.setY(30);
		assertEquals(v0.getX(), 10, 0);
		assertEquals(v0.getY(), 30, 0);
		
		v0 = new Vector2(10, 20);
		v0.set(30, 40);
		assertEquals(v0.getX(), 30, 0);
		assertEquals(v0.getY(), 40, 0);
		
		v0 = new Vector2(10, 20);
		v1 = new Vector2(30, 40);
		v0.set(v1);
		assertEquals(v0.getX(), 30, 0);
		assertEquals(v0.getY(), 40, 0);
		assertEquals(v1.getX(), 30, 0);
		assertEquals(v1.getY(), 40, 0);
		
		v0 = new Vector2(10, 20);
		v0.subFromThisX(2);
		assertEquals(v0.getX(), 8, 0);
		assertEquals(v0.getY(), 20, 0);
		
		v0 = new Vector2(10, 20);
		v0.subFromThisY(2);
		assertEquals(v0.getX(), 10, 0);
		assertEquals(v0.getY(), 18, 0);
		
		v0 = new Vector2(10, 20);
		v0.subFromThis(2, 3);
		assertEquals(v0.getX(), 8, 0);
		assertEquals(v0.getY(), 17, 0);
		
		v0 = new Vector2(10, 20);
		v1 = new Vector2(2, 3);
		v0.subFromThis(v1);
		assertEquals(v0.getX(), 8, 0);
		assertEquals(v0.getY(), 17, 0);
		assertEquals(v1.getX(), 2, 0);
		assertEquals(v1.getY(), 3, 0);
		
		v0 = new Vector2(10, 20);
		v1 = v0.subX(2);
		assertEquals(v0.getX(), 10, 0);
		assertEquals(v0.getY(), 20, 0);
		assertEquals(v1.getX(), 8, 0);
		assertEquals(v1.getY(), 20, 0);
		
		v0 = new Vector2(10, 20);
		v1 = v0.subY(2);
		assertEquals(v0.getX(), 10, 0);
		assertEquals(v0.getY(), 20, 0);
		assertEquals(v1.getX(), 10, 0);
		assertEquals(v1.getY(), 18, 0);
		
		v0 = new Vector2(10, 20);
		v1 = v0.sub(2, 3);
		assertEquals(v0.getX(), 10, 0);
		assertEquals(v0.getY(), 20, 0);
		assertEquals(v1.getX(), 8, 0);
		assertEquals(v1.getY(), 17, 0);
		
		v0 = new Vector2(10, 20);
		v1 = new Vector2(2, 3);
		v2 = v0.sub(v1);
		assertEquals(v0.getX(), 10, 0);
		assertEquals(v0.getY(), 20, 0);
		assertEquals(v1.getX(), 2, 0);
		assertEquals(v1.getY(), 3, 0);
		assertEquals(v2.getX(), 8, 0);
		assertEquals(v2.getY(), 17, 0);
		
		v0 = new Vector2(10, 20);
		v0.divThisX(2);
		assertEquals(v0.getX(), 5, 0);
		assertEquals(v0.getY(), 20, 0);
		
		v0 = new Vector2(10, 20);
		v0.divThisY(5);
		assertEquals(v0.getX(), 10, 0);
		assertEquals(v0.getY(), 4, 0);
		
		v0 = new Vector2(10, 20);
		v0.divThis(2);
		assertEquals(v0.getX(), 5, 0);
		assertEquals(v0.getY(), 10, 0);
		
		v0 = new Vector2(10, 20);
		v0.divComponentsThis(2, 5);
		assertEquals(v0.getX(), 5, 0);
		assertEquals(v0.getY(), 4, 0);
		
		v0 = new Vector2(10, 20);
		v1 = new Vector2(2, 5);
		v0.divComponentsThis(v1);
		assertEquals(v0.getX(), 5, 0);
		assertEquals(v0.getY(), 4, 0);
		assertEquals(v1.getX(), 2, 0);
		assertEquals(v1.getY(), 5, 0);
		
		v0 = new Vector2(10, 20);
		v1 = v0.divX(2);
		assertEquals(v0.getX(), 10, 0);
		assertEquals(v0.getY(), 20, 0);
		assertEquals(v1.getX(), 5, 0);
		assertEquals(v1.getY(), 20, 0);
		
		v0 = new Vector2(10, 20);
		v1 = v0.divY(5);
		assertEquals(v0.getX(), 10, 0);
		assertEquals(v0.getY(), 20, 0);
		assertEquals(v1.getX(), 10, 0);
		assertEquals(v1.getY(), 4, 0);
		
		v0 = new Vector2(10, 20);
		v1 = v0.div(2);
		assertEquals(v0.getX(), 10, 0);
		assertEquals(v0.getY(), 20, 0);
		assertEquals(v1.getX(), 5, 0);
		assertEquals(v1.getY(), 10, 0);
		
		v0 = new Vector2(10, 20);
		v1 = v0.divComponents(2, 5);
		assertEquals(v0.getX(), 10, 0);
		assertEquals(v0.getY(), 20, 0);
		assertEquals(v1.getX(), 5, 0);
		assertEquals(v1.getY(), 4, 0);
		
		v0 = new Vector2(10, 20);
		v1 = new Vector2(2, 5);
		v2 = v0.divComponents(v1);
		assertEquals(v0.getX(), 10, 0);
		assertEquals(v0.getY(), 20, 0);
		assertEquals(v1.getX(), 2, 0);
		assertEquals(v1.getY(), 5, 0);
		assertEquals(v2.getX(), 5, 0);
		assertEquals(v2.getY(), 4, 0);
		
		v0 = new Vector2(10, 20);
		v0.multThisX(3);
		assertEquals(v0.getX(), 30, 0);
		assertEquals(v0.getY(), 20, 0);
		
		v0 = new Vector2(10, 20);
		v0.multThisY(2);
		assertEquals(v0.getX(), 10, 0);
		assertEquals(v0.getY(), 40, 0);
		
		v0 = new Vector2(10, 20);
		v0.multThis(2);
		assertEquals(v0.getX(), 20, 0);
		assertEquals(v0.getY(), 40, 0);
		
		v0 = new Vector2(10, 20);
		v0.multComponentsThis(2, 4);
		assertEquals(v0.getX(), 20, 0);
		assertEquals(v0.getY(), 80, 0);
		
		v0 = new Vector2(10, 20);
		v1 = new Vector2(2, 4);
		v0.multComponentsThis(v1);
		assertEquals(v0.getX(), 20, 0);
		assertEquals(v0.getY(), 80, 0);
		assertEquals(v1.getX(), 2, 0);
		assertEquals(v1.getY(), 4, 0);
		
		v0 = new Vector2(10, 20);
		v1 = v0.mult(2);
		assertEquals(v0.getX(), 10, 0);
		assertEquals(v0.getY(), 20, 0);
		assertEquals(v1.getX(), 20, 0);
		assertEquals(v1.getY(), 40, 0);
		
		v0 = new Vector2(10, 20);
		v1 = v0.multX(3);
		assertEquals(v0.getX(), 10, 0);
		assertEquals(v0.getY(), 20, 0);
		assertEquals(v1.getX(), 30, 0);
		assertEquals(v1.getY(), 20, 0);
		
		v0 = new Vector2(10, 20);
		v1 = v0.multY(2);
		assertEquals(v0.getX(), 10, 0);
		assertEquals(v0.getY(), 20, 0);
		assertEquals(v1.getX(), 10, 0);
		assertEquals(v1.getY(), 40, 0);
		
		v0 = new Vector2(10, 20);
		v1 = v0.multComponents(2, 3);
		assertEquals(v0.getX(), 10, 0);
		assertEquals(v0.getY(), 20, 0);
		assertEquals(v1.getX(), 20, 0);
		assertEquals(v1.getY(), 60, 0);
		
		v0 = new Vector2(10, 20);
		v1 = new Vector2(2, 3);
		v2 = v0.multComponents(v1);
		assertEquals(v0.getX(), 10, 0);
		assertEquals(v0.getY(), 20, 0);
		assertEquals(v1.getX(), 2, 0);
		assertEquals(v1.getY(), 3, 0);
		assertEquals(v2.getX(), 20, 0);
		assertEquals(v2.getY(), 60, 0);
		
		v0 = new Vector2(2, 3);
		v1 = new Vector2(4, 5);
		a = v0.dotProduct(v1);
		assertEquals(v0.getX(), 2, 0);
		assertEquals(v0.getY(), 3, 0);
		assertEquals(v1.getX(), 4, 0);
		assertEquals(v1.getY(), 5, 0);
		assertEquals(a, 23, 0);
		
		
		v0 = new Vector2(2, 3);
		assertEquals(v0.toString().equals("(2.0, 3.0)"), true);
		
		v0 = new Vector2(2, 3);
		v1 = new Vector2(2, 3);
		v2 = new Vector2(3, 3);
		assertEquals(v0.equals(v1), true);
		assertEquals(v0.getX(), 2, 0);
		assertEquals(v0.getY(), 3, 0);
		assertEquals(v1.getX(), 2, 0);
		assertEquals(v1.getY(), 3, 0);
		assertEquals(v0.equals(v2), false);
		assertEquals(v0.getX(), 2, 0);
		assertEquals(v0.getY(), 3, 0);
		assertEquals(v2.getX(), 3, 0);
		assertEquals(v2.getY(), 3, 0);
		assertEquals(v0.equals(new Object()), false);
		assertEquals(v0.getX(), 2, 0);
		assertEquals(v0.getY(), 3, 0);
		
		
		assertEquals(new Vector2(0, 0)                .isContainingNaN(), false);
		assertEquals(new Vector2(Float.NaN, 0)        .isContainingNaN(), true);
		assertEquals(new Vector2(0, Float.NaN)        .isContainingNaN(), true);
		assertEquals(new Vector2(Float.NaN, Float.NaN).isContainingNaN(), true);
		
		
		v0 = new Vector2(20, 0);
		v1 = new Vector2(1, 1);
		v1.projectThis(v0);
		assertEquals(v0.getX(), 20, 0);
		assertEquals(v0.getY(), 0, 0);
		assertEquals(v1.getX(), 1, 0);
		assertEquals(v1.getY(), 0, 0);
		v0 = new Vector2(1, 0);
		v1 = new Vector2(20, 20);
		v0.projectThis(v1);
		assertEquals(v0.getX(), 0.5f, 0);
		assertEquals(v0.getY(), 0.5f, 0);
		assertEquals(v1.getX(), 20, 0);
		assertEquals(v1.getY(), 20, 0);
		
		v0 = new Vector2(20, 0);
		v1 = new Vector2(1, 1);
		v2 = v1.project(v0);
		assertEquals(v0.getX(), 20, 0);
		assertEquals(v0.getY(), 0, 0);
		assertEquals(v1.getX(), 1, 0);
		assertEquals(v1.getY(), 1, 0);
		assertEquals(v2.getX(), 1, 0);
		assertEquals(v2.getY(), 0, 0);
		v0 = new Vector2(1, 0);
		v1 = new Vector2(20, 20);
		v2 = v0.project(v1);
		assertEquals(v0.getX(), 1, 0);
		assertEquals(v0.getY(), 0, 0);
		assertEquals(v1.getX(), 20, 0);
		assertEquals(v1.getY(), 20, 0);
		assertEquals(v2.getX(), 0.5f, 0);
		assertEquals(v2.getY(), 0.5f, 0);
		
		v0 = new Vector2(20, 20);
		v1 = new Vector2(-4, 4);
		assertEquals(Vector2.angleRadiansBetween(v0, v1), Math.PI / 2, 0.001);
		assertEquals(v0.getX(), 20, 0);
		assertEquals(v0.getY(), 20, 0);
		assertEquals(v1.getX(), -4, 0);
		assertEquals(v1.getY(),  4, 0);
		v1 = new Vector2(0, 1000);
		assertEquals(Vector2.angleRadiansBetween(v0, v1), Math.PI / 4, 0.001);
		assertEquals(v0.getX(), 20, 0);
		assertEquals(v0.getY(), 20, 0);
		assertEquals(v1.getX(), 0, 0);
		assertEquals(v1.getY(), 1000, 0);
		
		v0 = new Vector2(20, 0);
		v1 = v0.rotate(Math.PI / 2);
		assertEquals(v0.getX(), 20, 0);
		assertEquals(v0.getY(), 0, 0);
		assertEquals(v1.getX(), 0, 0);
		assertEquals(v1.getY(), 20, 0);
		v1 = v0.rotate(Math.PI);
		assertEquals(v0.getX(), 20, 0);
		assertEquals(v0.getY(), 0, 0);
		assertEquals(v1.getX(), -20, 0);
		assertEquals(v1.getY(), 0, 0);
		v1 = v0.rotate(Math.PI / 4);
		assertEquals(v0.getX(), 20, 0);
		assertEquals(v0.getY(), 0, 0);
		assertEquals(v1.getX(), 14.142, 0.001);
		assertEquals(v1.getY(), 14.142, 0.001);
		
		v0 = new Vector2(20, 0);
		v0.rotateThis(Math.PI / 2);
		assertEquals(v0.getX(), 0, 0);
		assertEquals(v0.getY(), 20, 0);
		v0 = new Vector2(20, 0);
		v0.rotateThis(Math.PI);
		assertEquals(v0.getX(), -20, 0);
		assertEquals(v0.getY(), 0, 0);
		v0 = new Vector2(20, 0);
		v0.rotateThis(Math.PI / 4);
		assertEquals(v0.getX(), 14.142, 0.001);
		assertEquals(v0.getY(), 14.142, 0.001);
		
		v0 = new Vector2(1, 0);
		v0.setLengthThis(10);
		assertEquals(v0.getX(), 10, 0);
		assertEquals(v0.getY(), 0, 0);
		v0 = new Vector2(0, 100);
		v0.setLengthThis(10);
		assertEquals(v0.getX(), 0, 0);
		assertEquals(v0.getY(), 10, 0);
		v0 = new Vector2(1, 1);
		v0.setLengthThis(5.657f);
		assertEquals(v0.getX(), 4, 0.001);
		assertEquals(v0.getY(), 4, 0.001);
		
		v0 = new Vector2(1, 0);
		v1 = v0.setLength(10);
		assertEquals(v0.getX(), 1, 0);
		assertEquals(v0.getY(), 0, 0);
		assertEquals(v1.getX(), 10, 0);
		assertEquals(v1.getY(), 0, 0);
		v0 = new Vector2(0, 100);
		v1 = v0.setLength(10);
		assertEquals(v0.getX(), 0, 0);
		assertEquals(v0.getY(), 100, 0);
		assertEquals(v1.getX(), 0, 0);
		assertEquals(v1.getY(), 10, 0);
		v0 = new Vector2(1, 1);
		v1 = v0.setLength(5.657f);
		assertEquals(v0.getX(), 1, 1);
		assertEquals(v0.getY(), 1, 1);
		assertEquals(v1.getX(), 4, 0.001);
		assertEquals(v1.getY(), 4, 0.001);
		
		
		v0 = new Vector2(100, 0);
		assertEquals(v0.headingAngle(), 0, 0);
		assertEquals(v0.getX(), 100, 0);
		assertEquals(v0.getY(), 0, 0);
		v0 = new Vector2(100, 100);
		assertEquals(v0.headingAngle(), Math.PI / 4, 0);
		assertEquals(v0.getX(), 100, 0);
		assertEquals(v0.getY(), 100, 0);
		v0 = new Vector2(-100, 0);
		assertEquals(v0.headingAngle(), Math.PI, 0);
		assertEquals(v0.getX(), -100, 0);
		assertEquals(v0.getY(),    0, 0);
		v0 = new Vector2(-100, -100);
		assertEquals(v0.headingAngle(), Math.PI * 1.25f, 0);
		assertEquals(v0.getX(), -100, 0);
		assertEquals(v0.getY(), -100, 0);
		v0 = new Vector2(100, -100);
		assertEquals(v0.headingAngle(), Math.PI * 1.75f, 0);
		assertEquals(v0.getX(),  100, 0);
		assertEquals(v0.getY(), -100, 0);
	}

}
