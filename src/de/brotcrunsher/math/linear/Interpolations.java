package de.brotcrunsher.math.linear;

public class Interpolations {
	public static float linear(float a, float b, float t){
		return a * (1-t) + b * t;
	}
	
	public static Vector2 linear(Vector2 a, Vector2 b, float t){
		//TODO
		throw new UnsupportedOperationException();
	}
	
	public static float cosine(float a, float b, float t){
		//TODO
		throw new UnsupportedOperationException();
	}
	
	public static Vector2 cosine(Vector2 a, Vector2 b, float t){
		//TODO
		throw new UnsupportedOperationException();
	}
	
	public static float cubic(float preA, float a, float b, float postB, float t){
		//TODO
		throw new UnsupportedOperationException();
	}
	
	public static Vector2 cubic(Vector2 preA, Vector2 a, Vector2 b, Vector2 postB, float t){
		//TODO
		throw new UnsupportedOperationException();
	}
	
	public static float bezier(float a, float b, float t, float control){
		//TODO
		throw new UnsupportedOperationException();
	}
	
	public static Vector2 bezier(Vector2 a, Vector2 b, float t, Vector2 control){
		//TODO
		throw new UnsupportedOperationException();
	}
	
	public static float bezier(float a, float b, float t, float control1, float control2){
		//TODO
		throw new UnsupportedOperationException();
	}
	
	public static Vector2 bezier(Vector2 a, Vector2 b, float t, Vector2 control1, Vector2 control2){
		//TODO
		throw new UnsupportedOperationException();
	}
	
	public static float bezier(float a, float b, float t, float... controls){
		//TODO
		throw new UnsupportedOperationException();
	}
	
	public static float bezier(Vector2 a, Vector2 b, float t, Vector2... controls){
		//TODO
		throw new UnsupportedOperationException();
	}
}
