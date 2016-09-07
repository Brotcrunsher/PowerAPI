package de.brotcrunsher.tests.renderingTests;

import de.brotcrunsher.game.core.Game;
import de.brotcrunsher.gfx.basics.Color;
import de.brotcrunsher.gfx.rendering.Renderer;
import de.brotcrunsher.gfx.rendering.Window;
import de.brotcrunsher.math.linear.Vector2;
import de.brotcrunsher.math.random.RNG;

public class RandomVector2OnUnitSquareTest implements Game{
	
	public static void main(String[] args) {
		new RandomVector2OnUnitSquareTest().start();
	}
	
	@Override
	public void preInitialize() {
		
	}

	@Override
	public void initialize(Window w) {
		
	}

	@Override
	public void update(float timeSinceLastFrame) {
		
	}

	@Override
	public void draw(Renderer r) {
		r.setColor(Color.AWT_GREEN);
		//r.drawRect(100, 100, 500, 500);
		r.setColor(Color.AWT_BLACK);
		Vector2 rand = RNG.randomVector2OnUnitSquare(null);
		rand.multThis(500);
		rand.addThis(100, 100);
		r.fillRect(rand, 1, 1);
	}

}
