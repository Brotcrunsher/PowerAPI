package de.brotcrunsher.unitTests;

import de.brotcrunsher.game.core.Game;
import de.brotcrunsher.gfx.basics.Color;
import de.brotcrunsher.gfx.rendering.Renderer;
import de.brotcrunsher.math.linear.Vector2;

public class RenderingTest implements Game{

	@Override
	public void preInitialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(float timeSinceLastFrame) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(Renderer r) {
		r.setColor(Color.AWT_GREEN);
		r.clearScreen();
		r.setColor(Color.AWT_BLACK);
		r.fillRect(1, 1, getScreenWidth()-2, getScreenHeight()-2);
		r.setColor(new Color(1, 0, 0, 1));
		r.fillOval(0, 0, 100, 100);
		r.setColor(new Color(0, 1, 0, 1));
		r.fillOval(new Vector2(getScreenWidth() - 100, 0), 100, 100);
		r.setColor(new Color(0, 0, 1, 1));
		r.fillOval(0, getScreenHeight() - 100, new Vector2(100, 100));
		r.setColor(new Color(1, 1, 0, 1));
		r.fillOval(new Vector2(getScreenWidth() - 100, getScreenHeight() - 100), new Vector2(100, 100));
		r.setColor(Color.AWT_MAGENTA);
		r.fillOval(300,  300, 200, 100);
		r.setColor(Color.AWT_DARK_GRAY);
		r.fillTriangle(100, 100, 300, 50, 200, 200);
		r.drawTriangle(500, 20, 550, 50, 170, 10);
		r.setColor(Color.AWT_WHITE);
		r.drawRect(800, 20, 100, 200);
	}
	
	
	public static void main(String[] args) {
		new RenderingTest().start();
	}
}
