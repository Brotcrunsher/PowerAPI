package de.brotcrunsher.math.linear;

import de.brotcrunsher.gfx.rendering.Renderer;

public class LinearCurve2 extends Interpolation2D{
	
	public LinearCurve2(Vector2 start, Vector2 stop){
		this.start = start;
		this.stop = stop;
	}
	
	@Override
	public Vector2 eval(Vector2 result, float t) {
		if(result == null) result = new Vector2();
		return Interpolations.linear(result, start, stop, t);
	}
	
	@Override
	public Interpolation2D draw(Renderer r) {
		r.drawLine(start, stop);
		return this;
	}

}
