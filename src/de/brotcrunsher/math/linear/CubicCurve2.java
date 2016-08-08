package de.brotcrunsher.math.linear;

public class CubicCurve2 extends Interpolation2D{
	private Vector2 preStart;
	private Vector2 postStop;
	
	public CubicCurve2(Vector2 preStart, Vector2 start, Vector2 stop, Vector2 postStop){
		//TODO TEST
		this.preStart = preStart;
		this.start = start;
		this.stop = stop;
		this.postStop = postStop;
	}
	
	
	@Override
	public Vector2 eval(Vector2 result, float t) {
		//TODO TEST
		if(result == null) result = new Vector2();
		
		Interpolations.cubic(result, preStart, start, stop, postStop, t);
		
		return result;
	}

}
