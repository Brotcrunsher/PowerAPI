package de.brotcrunsher.math.linear;

public abstract class Interpolations2D {
	protected Vector2 start;
	protected Vector2 stop;
	
	private Vector2 workingVector1 = new Vector2();
	private Vector2 workingVector2 = new Vector2();
	
	public abstract void eval(Vector2 result, float t);
	
	public void direction(Vector2 result, float t){
		if(t < 1){
			eval(workingVector1, t);
			eval(workingVector2, t+0.01f);
		}
		else{
			eval(workingVector1, t-0.01f);
			eval(workingVector2, t);
		}
		
		result.set(workingVector2);
		result.subFromThis(workingVector1);
		
		result.normalizeThis();
	}
}
