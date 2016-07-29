package de.brotcrunsher.tests.renderingTests;

import de.brotcrunsher.game.core.Game;
import de.brotcrunsher.gfx.basics.Color;
import de.brotcrunsher.gfx.rendering.Renderer;
import de.brotcrunsher.gfx.rendering.Window;
import de.brotcrunsher.math.linear.Vector2;
import de.brotcrunsher.math.random.RNG;

public class RandomVectorOnUnitCircleTest implements Game{
	public static void main(String[] args) {
		new RandomVectorOnUnitCircleTest().start();
	}
	
	Vector2 result = new Vector2();
	
	@Override
	public void preInitialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initialize(Window w) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(float timeSinceLastFrame) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(Renderer r) {
		r.setColor(Color.AWT_ORANGE);
		r.drawOval(0, 0, 500, 500);
		r.setColor(Color.AWT_GREEN);
		RNG.randomVector2OnUnitCircle(result);
		result.addToThis(1, 1);
		result.multThis(250);
		r.fillOval(result, 2, 2);
	}
}
