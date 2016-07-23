package de.brotcrunsher.math.linear;

import de.brotcrunsher.gfx.basics.Color;

public class Interpolations {
	public static float linear(float a, float b, float t){
		return a * (1-t) + b * t;
	}
	
	public static Vector2 linear(Vector2 result, Vector2 a, Vector2 b, float t){
		if(result == null) result = new Vector2();
		result.setX(linear(a.getX(), b.getX(), t));
		result.setY(linear(a.getY(), b.getY(), t));
		return result;
	}
	
	public static Color linear(Color result, Color a, Color b, float t){
		if(result == null) result = new Color();
		result.setR(linear(a.getR(), b.getR(), t));
		result.setG(linear(a.getG(), b.getG(), t));
		result.setB(linear(a.getB(), b.getB(), t));
		result.setA(linear(a.getA(), b.getA(), t));
		return result;
	}
	
	public static float cosine(float a, float b, float t){
		return linear(a, b, (1-FMath.cos(t * FMath.PI))/2);
	}
	
	public static Vector2 cosine(Vector2 result, Vector2 a, Vector2 b, float t){
		if(result == null) result = new Vector2();
		result.setX(cosine(a.getX(), b.getX(), t));
		result.setY(cosine(a.getY(), b.getY(), t));
		return result;
	}
	
	public static Color cosine(Color result, Color a, Color b, float t){
		if(result == null) result = new Color();
		result.setR(cosine(a.getR(), b.getR(), t));
		result.setG(cosine(a.getG(), b.getG(), t));
		result.setB(cosine(a.getB(), b.getB(), t));
		result.setA(cosine(a.getA(), b.getA(), t));
		return result;
	}
	
	public static float cubic(float preA, float a, float b, float postB, float t){
		float t2 = t * t;
		float w0 = postB - b - preA + a;
		float w1 = preA - a - w0;
		float w2 = b - preA;
		float w3 = a;
		
		return (w0*t*t2 + w1*t2 + w2*t + w3);
	}
	
	public static Vector2 cubic(Vector2 result, Vector2 preA, Vector2 a, Vector2 b, Vector2 postB, float t){
		if(result == null) result = new Vector2();
		result.setX(cubic(preA.getX(), a.getX(), b.getX(), postB.getX(), t));
		result.setY(cubic(preA.getY(), a.getY(), b.getY(), postB.getY(), t));
		return result;
	}
	
	public static Color cubic(Color result, Color preA, Color a, Color b, Color postB, float t){
		if(result == null) result = new Color();
		result.setR(cubic(preA.getR(), a.getR(), b.getR(), postB.getR(), t));
		result.setG(cubic(preA.getG(), a.getG(), b.getG(), postB.getG(),t));
		result.setB(cubic(preA.getB(), a.getB(), b.getB(), postB.getB(),t));
		result.setA(cubic(preA.getA(), a.getA(), b.getA(), postB.getA(),t));
		return result;
	}
	
	public static float bezier(float a, float b, float t, float control){
		float w0 = linear(a, control, t);
		float w1 = linear(control, b, t);
		return linear(w0, w1, t);
	}
	
	public static Vector2 bezier(Vector2 result, Vector2 a, Vector2 b, float t, Vector2 control){
		if(result == null) result = new Vector2();
		result.setX(bezier(a.getX(), b.getX(), t, control.getX()));
		result.setY(bezier(a.getY(), b.getY(), t, control.getY()));
		return result;
	}
	
	public static float bezier(float a, float b, float t, float control1, float control2){
		float w0 = linear(a, control1, t);
		float w1 = linear(control1, control2, t);
		float w2 = linear(control2, b, t);
		
		float ww0 = linear(w0, w1, t);
		float ww1 = linear(w1, w2, t);
		
		return linear(ww0, ww1, t);
	}
	
	public static Vector2 bezier(Vector2 result, Vector2 a, Vector2 b, float t, Vector2 control1, Vector2 control2){
		if(result == null) result = new Vector2();
		result.setX(bezier(a.getX(), b.getX(), t, control1.getX(), control2.getX()));
		result.setY(bezier(a.getY(), b.getY(), t, control1.getY(), control2.getY()));
		return result;
	}
	
	public static float bezier(float a, float b, float t, float... controls){
		if(controls.length == 0){
			return linear(a, b, t);
		}
		if(controls.length == 1){
			return bezier(a, b, t, controls[0]);
		}
		if(controls.length == 2){
			return bezier(a, b, t, controls[0], controls[1]);
		}
		
		return _bezier(a, b, t, controls, controls.length);
	}
	
	private static float _bezier(float a, float b, float t, float[] workingArray, int size){
		if(size == 2){
			return bezier(a, b, t, workingArray[0], workingArray[1]); 
		}
		
		for(int i = 0; i<size - 1; i++){
			workingArray[i] = linear(workingArray[i], workingArray[i+1], t);
		}
		
		
		return _bezier(a, b, t, workingArray, size-1);
	}
	
	public static Vector2 bezier(Vector2 result, Vector2 a, Vector2 b, float t, Vector2... controls){
		if(result == null) result = new Vector2();
		float[] xs = new float[controls.length];
		float[] ys = new float[controls.length];
		
		for(int i = 0; i<controls.length; i++){
			xs[i] = controls[i].getX();
			ys[i] = controls[i].getY();
		}
		
		result.setX(bezier(a.getX(), b.getX(), t, xs));
		result.setY(bezier(a.getY(), b.getY(), t, ys));
		return result;
	}
}
