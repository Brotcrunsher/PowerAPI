package de.brotcrunsher.math.linear;

import de.brotcrunsher.gfx.basics.Color;

public class Interpolations {
	public static float linear(float a, float b, float t){
		return a * (1-t) + b * t;
	}
	
	public static void linear(Vector2 result, Vector2 a, Vector2 b, float t){
		result.setX(linear(a.getX(), b.getX(), t));
		result.setY(linear(a.getY(), b.getY(), t));
	}
	
	public static void linear(Color result, Color a, Color b, float t){
		result.setR(linear(a.getR(), b.getR(), t));
		result.setG(linear(a.getG(), b.getG(), t));
		result.setB(linear(a.getB(), b.getB(), t));
		result.setA(linear(a.getA(), b.getA(), t));
	}
	
	public static float cosine(float a, float b, float t){
		return linear(a, b, (1-Math.cos(t * Math.PI))/2);
	}
	
	public static void cosine(Vector2 result, Vector2 a, Vector2 b, float t){
		result.setX(cosine(a.getX(), b.getX(), t));
		result.setY(cosine(a.getY(), b.getY(), t));
	}
	
	public static void cosine(Color result, Color a, Color b, float t){
		result.setR(cosine(a.getR(), b.getR(), t));
		result.setG(cosine(a.getG(), b.getG(), t));
		result.setB(cosine(a.getB(), b.getB(), t));
		result.setA(cosine(a.getA(), b.getA(), t));
	}
	
	public static float cubic(float preA, float a, float b, float postB, float t){
		float t2 = t * t;
		float w0 = postB - b - preA + a;
		float w1 = preA - a - w0;
		float w2 = b - preA;
		float w3 = a;
		
		return (w0*t*t2 + w1*t2 + w2*t + w3);
	}
	
	public static void cubic(Vector2 result, Vector2 preA, Vector2 a, Vector2 b, Vector2 postB, float t){
		result.setX(cubic(preA.getX(), a.getX(), b.getX(), postB.getX(), t));
		result.setY(cubic(preA.getY(), a.getY(), b.getY(), postB.getY(), t));
	}
	
	public static void cubic(Color result, Color preA, Color a, Color b, Color postB, float t){
		result.setR(cubic(preA.getR(), a.getR(), b.getR(), postB.getR(), t));
		result.setG(cubic(preA.getG(), a.getG(), b.getG(), postB.getG(),t));
		result.setB(cubic(preA.getB(), a.getB(), b.getB(), postB.getB(),t));
		result.setA(cubic(preA.getA(), a.getA(), b.getA(), postB.getA(),t));
	}
	
	public static float bezier(float a, float b, float t, float control){
		float w0 = linear(a, control, t);
		float w1 = linear(control, b, t);
		return linear(w0, w1, t);
	}
	
	public static void bezier(Vector2 result, Vector2 a, Vector2 b, float t, Vector2 control){
		result.setX(bezier(a.getX(), b.getX(), t, control.getX()));
		result.setY(bezier(a.getY(), b.getY(), t, control.getY()));
	}
	
	public static float bezier(float a, float b, float t, float control1, float control2){
		float w0 = linear(a, control1, t);
		float w1 = linear(control1, control2, t);
		float w2 = linear(control2, b, t);
		
		float ww0 = linear(w0, w1, t);
		float ww1 = linear(w1, w2, t);
		
		return linear(ww0, ww1, t);
	}
	
	public static void bezier(Vector2 result, Vector2 a, Vector2 b, float t, Vector2 control1, Vector2 control2){
		result.setX(bezier(a.getX(), b.getX(), t, control1.getX(), control2.getX()));
		result.setY(bezier(a.getY(), b.getY(), t, control1.getY(), control2.getY()));
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
	
	public static void bezier(Vector2 result, Vector2 a, Vector2 b, float t, Vector2... controls){
		float[] xs = new float[controls.length];
		float[] ys = new float[controls.length];
		
		for(int i = 0; i<controls.length; i++){
			xs[i] = controls[i].getX();
			ys[i] = controls[i].getY();
		}
		
		result.setX(bezier(a.getX(), b.getX(), t, xs));
		result.setY(bezier(a.getY(), b.getY(), t, ys));
	}
}
