package de.brotcrunsher.math.linear;

import java.util.Arrays;

public class Math {
	public static float PI = (float)java.lang.Math.PI;
	public static float E = (float)java.lang.Math.E;
	
	public static float sqrt(float val){
		return (float)java.lang.Math.sqrt(val);
	}
	
	public static float sin(float val){
		return (float)java.lang.Math.sin(val);
	}
	
	public static float cos(float val){
		return (float)java.lang.Math.cos(val);
	}
	
	public static float abs(float val){
		if(val < 0) return -val;
		else return val;
	}
	
	public static float max(float x){
		return x;
	}
	public static float max(float x, float y){
		return x > y ? x : y;
	}
	public static float max(float... val){
		val = Arrays.copyOf(val, val.length); //TOCTOU Protection
		if(val.length == 0){
			throw new IllegalArgumentException();
		}
		float max = val[0];
		for(int i = 1; i<val.length; i++){
			if(val[i] > max) max = val[i];
		}
		return max;
	}
	
	public static float maxAbs(float x){
		return abs(x);
	}
	public static float maxAbs(float x, float y){
		x = abs(x);
		y = abs(y);
		return max(x, y);
	}
	
	public static float maxAbs(float...val){
		val = Arrays.copyOf(val, val.length); //TOCTOU Protection
		for(int i = 0; i<val.length; i++){
			val[i] = abs(val[i]);
		}
		return max(val);
	}
	
	public static float min(float x){
		return x;
	}
	public static float min(float x, float y){
		return x < y ? x : y;
	}
	public static float min(float... val){
		val = Arrays.copyOf(val, val.length); //TOCTOU Protection
		if(val.length == 0){
			throw new IllegalArgumentException();
		}
		float min = val[0];
		for(int i = 1; i<val.length; i++){
			if(val[i] < min) min = val[i];
		}
		return min;
	}
	
	public static float minAbs(float x){
		return abs(x);
	}
	public static float minAbs(float x, float y){
		x = abs(x);
		y = abs(y);
		return min(x, y);
	}
	public static float minAbs(float... val){
		val = Arrays.copyOf(val, val.length); //TOCTOU Protection
		for(int i = 0; i<val.length; i++){
			val[i] = abs(val[i]);
		}
		return min(val);
	}
	
	public static float clamp(float x, float min, float max){
		if(x < min) return min;
		if(x > max) return max;
		return x;
	}
	
	public static float clamp01(float x){
		return clamp(x, 0, 1);
	}
}
