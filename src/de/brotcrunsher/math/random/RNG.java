package de.brotcrunsher.math.random;

import de.brotcrunsher.gfx.basics.Color;
import de.brotcrunsher.math.linear.Math;
import de.brotcrunsher.math.linear.Vector2;

public class RNG {
	public static RandomNumberGenerator randomDefault = new RandomNumberGeneratorJavaDefault();
	
	public static Vector2 randomVector2InsideUnitCircle(RandomNumberGenerator r){
		while(true){
			float x = r.nextFloat() * 2 - 1;
			float y = r.nextFloat() * 2 - 1;
			if(x * x + y * y <= 1){
				return new Vector2(x, y);
			}
		}
	}
	public static Vector2 randomVector2InsideUnitCircle(){
		return randomVector2InsideUnitCircle(randomDefault);
	}
	
	public static Vector2 randomVectorOnUnitCircle(){
		return randomVectorOnUnitCircle(randomDefault);
	}
	
	public static Vector2 randomVectorOnUnitCircle(RandomNumberGenerator r){
		return Vector2.newOnCircle(r.nextFloat() * Math.PI * 2);
	}
	
	public static Vector2 randomVector2InsideUnitSquare(RandomNumberGenerator r){
		return new Vector2(r.nextFloat(), r.nextFloat());
	}
	
	public static Vector2 randomVector2InsideUnitSquare(){
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
		return randomVector2OnUnitSquare(randomDefault);
	}
	
	
	public static Color randomColor(RandomNumberGenerator r){
		return new Color(r.nextFloat(), r.nextFloat(), r.nextFloat(), r.nextFloat());
	}
	
	public static Color randomColor(){
		return randomColor(randomDefault);
	}
}
