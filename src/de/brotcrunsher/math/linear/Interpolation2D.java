package de.brotcrunsher.math.linear;

import de.brotcrunsher.gfx.rendering.Renderer;

public abstract class Interpolation2D {
	private static final ThreadLocal<Vector2> workingVector1 = new ThreadLocal<Vector2>(){
		protected Vector2 initialValue() {
			return new Vector2();
		};
	};
	private static final ThreadLocal<Vector2> workingVector2 = new ThreadLocal<Vector2>(){
		protected Vector2 initialValue() {
			return new Vector2();
		};
	};
	protected Vector2 start;
	protected Vector2 stop;
	
	public abstract Vector2 eval(Vector2 result, float t);
	
	public Interpolation2D draw(Renderer r){
		Vector2 workingVector1 = Interpolation2D.workingVector1.get();
		Vector2 workingVector2 = Interpolation2D.workingVector2.get();
		eval(workingVector1, 0);
		for(float i = 0.01f; i <= 1; i+=0.01f){
			eval(workingVector2, i);
			r.drawLine(workingVector1, workingVector2);
			workingVector1.set(workingVector2);
		}
		eval(workingVector2, 1);
		r.drawLine(workingVector1, workingVector2);
		return this;
	}
	
	public Vector2 direction(Vector2 result, float t){
		if(result == null){
			result = new Vector2();
		}
		Vector2 workingVector1 = Interpolation2D.workingVector1.get();
		Vector2 workingVector2 = Interpolation2D.workingVector2.get();
		if(t < 1){
			eval(workingVector1, t);
			eval(workingVector2, t+0.01f);
		}
		else{
			eval(workingVector1, t-0.01f);
			eval(workingVector2, t);
		}
		
		result.set(workingVector2);
		result.subThis(workingVector1);
		
		result.normalizeThis();
		return result;
	}
}
