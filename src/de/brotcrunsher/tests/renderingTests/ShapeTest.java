package de.brotcrunsher.tests.renderingTests;

import de.brotcrunsher.game.core.Game;
import de.brotcrunsher.gfx.basics.Color;
import de.brotcrunsher.gfx.rendering.Renderer;
import de.brotcrunsher.gfx.rendering.Window;
import de.brotcrunsher.input.Mouse;
import de.brotcrunsher.math.linear.Vector2;
import de.brotcrunsher.math.shapes.Circle;
import de.brotcrunsher.math.shapes.Rect;
import de.brotcrunsher.math.shapes.Shape;

public class ShapeTest implements Game{
	public static void main(String[] args) {
		new ShapeTest().start();
	}
	
	Vector2 s1Pos = new Vector2();
	Vector2 collisionPos = new Vector2(700, 500);
	
	Shape s1 = new Rect(s1Pos, new Vector2(100, 200));
	Shape s2 = new Rect(new Vector2(300, 250), new Vector2(220, 180));
	
	boolean intersects = false;
	
	@Override
	public void preInitialize() {
		s2 = new Circle(new Vector2(400, 350), 100);
		s1 = new Circle(s1Pos, 150);
	}

	@Override
	public void initialize(Window w) {
		
	}

	@Override
	public void update(float timeSinceLastFrame) {
		Mouse.getPos(s1Pos);
		intersects = s1.intersects(s2) || s1.intersects(collisionPos);
	}

	@Override
	public void draw(Renderer r) {
		r.setColor(Color.AWT_BLACK);
		r.clearScreen();
		r.setColor(intersects ? Color.GREEN : Color.BLUE);
		s1.draw(r);
		r.setColor(Color.RED);
		s2.draw(r);
		r.drawPixel(collisionPos);
	}

}
