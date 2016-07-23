package de.brotcrunsher.gfx.rendering.openGL;

import de.brotcrunsher.math.linear.FMath;
import de.brotcrunsher.math.linear.Interpolations;

public class OpenGLUtils {
	
	public static int circularShape_calcVertexCount(float radius){
		final int CIRCLE_MIN_VERTICES = 6, CIRCLE_MAX_VERTICES = 180;
		float factor = 1;
		
		if(FMath.isInRange(radius, 1, 100)){
			factor = Interpolations.linear(0.5f, 0.25f, radius / 100);
		}else if(FMath.isInRangeStrict(radius, 100, 1000)){
			factor = Interpolations.linear(0.25f, 0.125f, radius / 1000);
		}else{
			factor = 0.125f;
		}
		
		
		
		int vertices = (int) (radius * factor) + CIRCLE_MIN_VERTICES;
		vertices = (int)FMath.clamp(vertices, CIRCLE_MIN_VERTICES, CIRCLE_MAX_VERTICES);
		
		if(vertices < 20 && FMath.isOdd(vertices)){
			vertices++; //odd values less than ~20 decrease visual quality
		}
		
		return vertices;
	}
}
