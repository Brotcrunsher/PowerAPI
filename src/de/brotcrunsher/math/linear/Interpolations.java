package de.brotcrunsher.math.linear;

public class Interpolations {
	public static float linear(float a, float b, float t){
		return a * (1-t) + b * t;
	}
}
