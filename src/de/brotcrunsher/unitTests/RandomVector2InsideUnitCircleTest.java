package de.brotcrunsher.unitTests;

import de.brotcrunsher.game.core.Game;
import de.brotcrunsher.gfx.basics.Color;
import de.brotcrunsher.gfx.rendering.Renderer;
import de.brotcrunsher.math.linear.Vector2;
import de.brotcrunsher.math.random.RNG;

public class RandomVector2InsideUnitCircleTest implements Game{
	public static void main(String[] args) {
		new RandomVector2InsideUnitCircleTest().start();
	}
	
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
		r.setColor(Color.AWT_ORANGE);
		r.drawOval(0, 0, 500, 500);
		Vector2 rand = RNG.randomVector2InsideUnitCircle();
		rand.addToThis(1, 1);
		rand.multThis(250);
		rand.sub(1, 1);
		r.fillOval(rand, 2, 2);
	}
}
