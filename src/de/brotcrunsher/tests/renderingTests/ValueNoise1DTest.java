package de.brotcrunsher.tests.renderingTests;

import de.brotcrunsher.array.ArrayUtil;
import de.brotcrunsher.game.core.Game;
import de.brotcrunsher.gfx.basics.Color;
import de.brotcrunsher.gfx.rendering.Renderer;
import de.brotcrunsher.gfx.rendering.Window;
import de.brotcrunsher.math.noise.ValueNoise1D;

public class ValueNoise1DTest implements Game{
	
	public static void main(String[] args) {
		new ValueNoise1DTest().start();
	}
	
	ValueNoise1D vn = new ValueNoise1D(getScreenWidth());
	float[] vals = new float[getScreenWidth()];
	
	@Override
	public void initialize(Window window) {
		vn.calculate();
		for(int i = 0; i<vals.length; i++){
			vals[i] = vn.getValue(i);
		}
	}

	@Override
	public void update(float timeSinceLastFrame) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(Renderer r) {
		r.setColor(Color.AWT_BLACK);
		r.clearScreen();
		r.setColor(Color.AWT_WHITE);
		for(int i = 0; i<getScreenWidth() - 1; i++){
			r.drawLine(i, vals[i] * getScreenHeight(), i+1, vals[i+1] * getScreenHeight());
		}
	}

	@Override
	public void preInitialize() {
		// TODO Auto-generated method stub
		
	}

}
