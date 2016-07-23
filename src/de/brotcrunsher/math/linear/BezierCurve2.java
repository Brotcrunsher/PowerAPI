package de.brotcrunsher.math.linear;

public class BezierCurve2 extends Interpolations2D{
	protected Vector2[] controls;
	
	public BezierCurve2(Vector2 start, Vector2 stop, Vector2 control){
		this.start = start;
		this.stop = stop;
		controls = new Vector2[1];
		controls[0] = control;
	}
	
	public BezierCurve2(Vector2 start, Vector2 stop, Vector2 control1, Vector2 control2){
		this.start = start;
		this.stop = stop;
		controls = new Vector2[2];
		controls[0] = control1;
		controls[1] = control2;
	}
	
	public BezierCurve2(Vector2 start, Vector2 stop, Vector2... controls){
		this.start = start;
		this.stop = stop;
		this.controls = controls;
	}
	
	
	
	@Override
	public void eval(Vector2 result, float t) {
		if(controls.length == 1){
			Interpolations.bezier(result, start, stop, t, controls[0]);
		}else if(controls.length == 2){
			Interpolations.bezier(result, start, stop, t, controls[0], controls[1]);
		}else{
			Interpolations.bezier(result, start, stop, t, controls);
		}
	}

}
