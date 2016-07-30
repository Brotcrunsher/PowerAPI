package de.brotcrunsher.math.random;

import de.brotcrunsher.gfx.basics.Color;
import de.brotcrunsher.math.linear.FMath;
import de.brotcrunsher.math.linear.Vector2;

public class RNG {
	public static RandomNumberGenerator randomDefault = new RandomNumberGeneratorJavaDefault();
	
	public static void randomVector2InsideUnitCircle(Vector2 result, RandomNumberGenerator r){
		while(true){
			float x = r.nextFloat() * 2 - 1;
			float y = r.nextFloat() * 2 - 1;
			if(x * x + y * y <= 1){
				result.setX(x);
				result.setY(y);
				return;
			}
		}
	}
	public static void randomVector2InsideUnitCircle(Vector2 result){
		//TESTED
		randomVector2InsideUnitCircle(result, randomDefault);
	}
	
	public static void randomVector2OnUnitCircle(Vector2 result){
		//TESTED
		randomVector2OnUnitCircle(result, randomDefault);
	}
	
	public static void randomVector2OnUnitCircle(Vector2 result, RandomNumberGenerator r){
		Vector2.newOnCircle(result, r.nextFloat() * FMath.PI * 2);
	}
	
	public static Vector2 randomVector2InsideUnitSquare(RandomNumberGenerator r){
		return new Vector2(r.nextFloat(), r.nextFloat());
	}
	
	public static Vector2 randomVector2InsideUnitSquare(){
		//TESTED
		return randomVector2InsideUnitSquare(randomDefault);
	}
	
	public static Vector2 randomVector2OnUnitSquare(RandomNumberGenerator r){
		float randomVal = r.nextFloat();
		switch(r.nextInt(4)){
		case 0:
			return new Vector2(randomVal, 0);
		case 1:
			return new Vector2(0, randomVal);
		case 2:
			return new Vector2(randomVal, 1);
		case 3:
			return new Vector2(1, randomVal);
		default:
			throw new IllegalArgumentException(); //Can only happen if the given Random isn't properly implemented.
		}
	}
	
	public static Vector2 randomVector2OnUnitSquare(){
		//TESTED
		return randomVector2OnUnitSquare(randomDefault);
	}
	
	
	public static Color randomColor(RandomNumberGenerator r){
		return new Color(r.nextFloat(), r.nextFloat(), r.nextFloat(), r.nextFloat());
	}
	
	public static Color randomColor(){
		return randomColor(randomDefault);
	}
	
	//TODO Add random getters for primitives - static!
}
