package de.brotcrunsher.math.linear;

import de.brotcrunsher.gfx.rendering.Renderer;

public class CosineCurve2 extends Interpolation2D{

	public CosineCurve2(Vector2 start, Vector2 stop){
		//TODO TEST
		this.start = start;
		this.stop = stop;
	}
	
	@Override
	public Vector2 eval(Vector2 result, float t) {
		//TODO TEST
		if(result == null) result = new Vector2();
		
		Interpolations.cosine(result, start, stop, t);
		
		return result;
	}
	
	@Override
	public Interpolation2D draw(Renderer r) {
		//TODO TEST
		//A cosine curve only has another density than a linear curve. But they travel the exact same points, however not at the same time.
		//If you draw a cosine curve its the same picture as drawing a linear curve. So we can draw the linear curve instead and save some
		//performance.
		r.drawLine(start, stop);
		return this;
	}

}
