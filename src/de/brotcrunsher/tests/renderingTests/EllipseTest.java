package de.brotcrunsher.tests.renderingTests;

import de.brotcrunsher.game.core.Game;
import de.brotcrunsher.gfx.basics.Color;
import de.brotcrunsher.gfx.rendering.Renderer;
import de.brotcrunsher.gfx.rendering.Window;
import de.brotcrunsher.input.Mouse;
import de.brotcrunsher.math.linear.Vector2;
import de.brotcrunsher.math.shapes.Circle;
import de.brotcrunsher.math.shapes.Ellipse;
import de.brotcrunsher.math.shapes.Rect;

public class EllipseTest implements Game{
	public static void main(String[] args) {
		new EllipseTest().start();
	}
	
	private Rect e = new Rect(0, 0, 150, 300);
	private Circle c = new Circle(600, 300, 100);
	private Vector2 mousePos = new Vector2();
	private Vector2 pixel = new Vector2(300, 500);
	private Vector2 closestToPixel = new Vector2();
	
	private boolean intersection = false;
	
	@Override
	public void initialize(Window window) {
		
	}

	@Override
	public void update(float timeSinceLastFrame) {
		e.setXY(Mouse.getPos(mousePos));
		e.getClosestPointTo(closestToPixel, pixel);
		
		intersection = e.intersects(c);
	}

	@Override
	public void draw(Renderer r) {
		r.setColor(Color.AWT_BLACK);
		r.clearScreen();
		
		r.setColor(intersection ? Color.GREEN : Color.RED);
		e.draw(r);
		
		r.setColor(Color.LIGHTBLUE);
		r.drawPixel(pixel);
		r.fillOval(closestToPixel, 5, 5);
		c.draw(r);
		
		/*r.setColor(new Color(1f, 0, 0, 0.5f));
		for(int i = 0; i<getScreenWidth(); i++){
			for(int k = 0; k<getScreenHeight(); k++){
				e.setXY(i, k);
				if(e.intersects(c)){
					r.drawPixel(i, k);
				}
			}
		}*/
	}

	@Override
	public void preInitialize() {
		
	}
}
