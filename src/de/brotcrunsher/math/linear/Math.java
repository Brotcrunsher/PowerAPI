package de.brotcrunsher.math.linear;

import java.util.Arrays;

public class Math {
	public static final float PI  = (float)java.lang.Math.PI;
	public static final float TAU = (float)(java.lang.Math.PI * 2.0);
	public static final float E   = (float)java.lang.Math.E;
	
	public static float sqrt(float val){
		//TESTED
		return (float)java.lang.Math.sqrt(val);
	}
	
	public static float sin(float val){
		//TESTED
		val = mod(val, PI * 2);
		if(val == 0) return 0;
		if(val == PI * 0.5f) return 1;
		if(val == PI) return 0;
		if(val == PI * 1.5f) return -1;
		return (float)java.lang.Math.sin(val);
	}
	
	public static float cos(float val){
		//TESTED
		val = mod(val, PI * 2);
		if(val == 0) return 1;
		if(val == PI * 0.5f) return 0;
		if(val == PI) return -1;
		if(val == PI * 1.5f) return 0;
		return (float)java.lang.Math.cos(val);
	}
	
	public static float abs(float val){
		//TESTED
		if(val < 0) return -val;
		else return val;
	}
	
	public static float max(float x){
		//TESTED
		return x;
	}
	public static float max(float x, float y){
		//TESTED
		return x > y ? x : y;
	}
	public static float max(float... val){
		//TESTED
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
		//TESTED
		return abs(x);
	}
	public static float maxAbs(float x, float y){
		//TESTED
		x = abs(x);
		y = abs(y);
		return max(x, y);
	}
	
	public static float maxAbs(float...val){
		//TESTED
		val = Arrays.copyOf(val, val.length); //TOCTOU Protection
		for(int i = 0; i<val.length; i++){
			val[i] = abs(val[i]);
		}
		return max(val);
	}
	
	public static float min(float x){
		//TESTED
		return x;
	}
	public static float min(float x, float y){
		//TESTED
		return x < y ? x : y;
	}
	public static float min(float... val){
		//TESTED
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
		//TESTED
		return abs(x);
	}
	public static float minAbs(float x, float y){
		//TESTED
		x = abs(x);
		y = abs(y);
		return min(x, y);
	}
	public static float minAbs(float... val){
		//TESTED
		val = Arrays.copyOf(val, val.length); //TOCTOU Protection
		for(int i = 0; i<val.length; i++){
			val[i] = abs(val[i]);
		}
		return min(val);
	}
	
	public static float clamp(float x, float min, float max){
		//TESTED
		if(min > max) throw new IllegalArgumentException("Min was bigger than Max!");
		if(x < min) return min;
		if(x > max) return max;
		return x;
	}
	
	public static float clamp01(float x){
		//TESTED
		return clamp(x, 0, 1);
	}
	
	public static int mod(int val, int mod){
		//TESTED
		if(val >= 0) return val % mod;
		else{
			int ret = val % mod + mod;
			return ret == mod ? 0 : ret;
		}
	}
	
	public static float mod(float val, float mod){
		//TESTED
		if(val >= 0) return val % mod;
		else{
			float ret = val % mod + mod;
			return ret == mod ? 0 : ret;
		}
	}
}
