package de.brotcrunsher.unitTests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import de.brotcrunsher.math.linear.Math;
import de.brotcrunsher.math.random.RNG;

public class TestMath {

	@Test
	public void test() {
		assertEquals(Math.mod(0, 3), 0);
		assertEquals(Math.mod(1, 3), 1);
		assertEquals(Math.mod(2, 3), 2);
		assertEquals(Math.mod(3, 3), 0);
		assertEquals(Math.mod(-1, 3), 2);
		assertEquals(Math.mod(-2, 3), 1);
		assertEquals(Math.mod(-3, 3), 0);
		assertEquals(Math.mod(-4, 3), 2);
		assertEquals(Math.mod(-5, 3), 1);
		assertEquals(Math.mod(-6, 3), 0);
		assertEquals(Math.mod(-7, 3), 2);
		
		assertEquals(Math.mod(0f, 3f), 0, 0);
		assertEquals(Math.mod(1f, 3f), 1, 0);
		assertEquals(Math.mod(2f, 3f), 2, 0);
		assertEquals(Math.mod(3f, 3f), 0, 0);
		assertEquals(Math.mod(3.1f, 3f), 0.1f, 0.0001f);
		assertEquals(Math.mod(-1f, 3f), 2, 0);
		assertEquals(Math.mod(-2f, 3f), 1, 0);
		assertEquals(Math.mod(-3f, 3f), 0, 0);
		assertEquals(Math.mod(-4f, 3f), 2, 0);
		assertEquals(Math.mod(-5f, 3f), 1, 0);
		assertEquals(Math.mod(-6f, 3f), 0, 0);
		assertEquals(Math.mod(-7f, 3f), 2, 0);

		assertEquals(Math.sqrt(0)    , 0    , 0);
		assertEquals(Math.sqrt(0.5f) , 0.707, 0.001);
		assertEquals(Math.sqrt(1)    , 1    , 0.01);
		assertEquals(Math.sqrt(1.5f) , 1.225, 0.01);
		assertEquals(Math.sqrt(2)    , 1.414, 0.01);
		assertEquals(Math.sqrt(2.5f) , 1.581, 0.01);
		assertEquals(Math.sqrt(3)    , 1.732, 0.01);
		assertEquals(Math.sqrt(3.5f) , 1.871, 0.01);
		assertEquals(Math.sqrt(4)    , 2    , 0.01);
		assertEquals(Math.sqrt(4.5f) , 2.121, 0.01);
		assertEquals(Math.sqrt(5)    , 2.236, 0.01);
		assertEquals(Math.sqrt(100)  , 10   , 0.1);
		assertEquals(Math.sqrt(10000), 100, 1);
		assertEquals(Math.sqrt(1000000), 1000, 10);
		assertEquals(Math.sqrt(100000000), 10000, 100);
		
		for(int i = 0; i<64000; i++){
			float rand = RNG.randomDefault.nextFloat() * 10000;
			assertEquals(Math.sqrt(rand), java.lang.Math.sqrt(rand), rand * 0.001f + 0.001f);
		}

		assertEquals(Math.sin(-6.5f), -0.215, 0.001);
		assertEquals(Math.sin(-6f)  ,  0.279, 0.001);
		assertEquals(Math.sin(-5.5f),  0.706, 0.001);
		assertEquals(Math.sin(-5f)  ,  0.959, 0.001);
		assertEquals(Math.sin(-4.5f),  0.978, 0.001);
		assertEquals(Math.sin(-4f)  ,  0.757, 0.001);
		assertEquals(Math.sin(-3.5f),  0.351, 0.001);
		assertEquals(Math.sin(-3f)  , -0.141, 0.001);
		assertEquals(Math.sin(-2.5f), -0.598, 0.001);
		assertEquals(Math.sin(-2f)  , -0.909, 0.001);
		assertEquals(Math.sin(-1.5f), -0.997, 0.001);
		assertEquals(Math.sin(-1f)  , -0.841, 0.001);
		assertEquals(Math.sin(-0.5f), -0.479, 0.001);
		assertEquals(Math.sin(0)    ,  0    , 0    );
		assertEquals(Math.sin(0.5f) ,  0.479, 0.001);
		assertEquals(Math.sin(1)    ,  0.841, 0.001);
		assertEquals(Math.sin(1.5f) ,  0.997, 0.001);
		assertEquals(Math.sin(2)    ,  0.909, 0.001);
		assertEquals(Math.sin(2.5f) ,  0.598, 0.001);
		assertEquals(Math.sin(3)    ,  0.141, 0.001);
		assertEquals(Math.sin(3.5f) , -0.351, 0.001);
		assertEquals(Math.sin(4)    , -0.757, 0.001);
		assertEquals(Math.sin(4.5f) , -0.977, 0.001);
		assertEquals(Math.sin(5)    , -0.959, 0.001);
		assertEquals(Math.sin(5.5f) , -0.706, 0.001);
		assertEquals(Math.sin(6)    , -0.279, 0.001);
		assertEquals(Math.sin(6.5f) ,  0.215, 0.001);
		assertEquals(Math.sin(100)  , -0.506, 0.001);
		assertEquals(Math.sin(1000) ,  0.827, 0.001);
		assertEquals(Math.sin(10000), -0.306, 0.001);
		assertEquals(Math.sin(Math.PI * 0.5f),  1, 0);
		assertEquals(Math.sin(Math.PI)       ,  0, 0);
		assertEquals(Math.sin(Math.PI * 1.5f), -1, 0);
		assertEquals(Math.sin(Math.PI * 2f)  ,  0, 0);
		
		for(int i = 0; i<64000; i++){
			float randVal = RNG.randomDefault.nextFloat() * 2000 - 1000;
			assertEquals(Math.sin(randVal), java.lang.Math.sin(randVal), 0.001);
		}
		
		assertEquals(Math.cos(-6.5f),  0.977, 0.001);
		assertEquals(Math.cos(-6f)  ,  0.960, 0.001);
		assertEquals(Math.cos(-5.5f),  0.709, 0.001);
		assertEquals(Math.cos(-5f)  ,  0.284, 0.001);
		assertEquals(Math.cos(-4.5f), -0.211, 0.001);
		assertEquals(Math.cos(-4f)  , -0.654, 0.001);
		assertEquals(Math.cos(-3.5f), -0.936, 0.001);
		assertEquals(Math.cos(-3f)  , -0.990, 0.001);
		assertEquals(Math.cos(-2.5f), -0.801, 0.001);
		assertEquals(Math.cos(-2f)  , -0.416, 0.001);
		assertEquals(Math.cos(-1.5f),  0.071, 0.001);
		assertEquals(Math.cos(-1f)  ,  0.540, 0.001);
		assertEquals(Math.cos(-0.5f),  0.878, 0.001);
		assertEquals(Math.cos(0)    ,  1    , 0    );
		assertEquals(Math.cos(0.5f) ,  0.878, 0.001);
		assertEquals(Math.cos(1)    ,  0.540, 0.001);
		assertEquals(Math.cos(1.5f) ,  0.070, 0.001);
		assertEquals(Math.cos(2)    , -0.416, 0.001);
		assertEquals(Math.cos(2.5f) , -0.801, 0.001);
		assertEquals(Math.cos(3)    , -0.990, 0.001);
		assertEquals(Math.cos(3.5f) , -0.936, 0.001);
		assertEquals(Math.cos(4)    , -0.654, 0.001);
		assertEquals(Math.cos(4.5f) , -0.211, 0.001);
		assertEquals(Math.cos(5)    ,  0.283, 0.001);
		assertEquals(Math.cos(5.5f) ,  0.709, 0.001);
		assertEquals(Math.cos(6)    ,  0.960, 0.001);
		assertEquals(Math.cos(6.5f) ,  0.977, 0.001);
		assertEquals(Math.cos(100)  ,  0.862, 0.001);
		assertEquals(Math.cos(1000) ,  0.562, 0.001);
		assertEquals(Math.cos(10000), -0.952, 0.001);
		assertEquals(Math.cos(Math.PI * 0.5f),  0, 0);
		assertEquals(Math.cos(Math.PI)       , -1, 0);
		assertEquals(Math.cos(Math.PI * 1.5f),  0, 0);
		assertEquals(Math.cos(Math.PI * 2f)  ,  1, 0);
		
		for(int i = 0; i<64000; i++){
			float randVal = RNG.randomDefault.nextFloat() * 2000 - 1000;
			assertEquals(Math.cos(randVal), java.lang.Math.cos(randVal), 0.001);
		}
		
		for(int i = 0; i<64000; i++){
			float rand = RNG.randomDefault.nextFloat() * 4000 - 2000;
			assertEquals(Math.acos(rand), java.lang.Math.acos(rand), 0.001f);
			assertEquals(Math.asin(rand), java.lang.Math.asin(rand), 0.001f);
		}
		
		assertEquals(Math.abs(0), 0, 0);
		assertEquals(Math.abs(1), 1, 0);
		assertEquals(Math.abs(-1), 1, 0);
		assertEquals(Math.abs(10000), 10000, 0);
		assertEquals(Math.abs(-10000), 10000, 0);
		assertEquals(Math.abs(Float.POSITIVE_INFINITY), Float.POSITIVE_INFINITY, 0);
		assertEquals(Math.abs(Float.NEGATIVE_INFINITY), Float.POSITIVE_INFINITY, 0);
		
		for(float i = -1000; i<= 1000; i+=0.001){
			assertEquals(Math.max(i), i, 0);
			assertEquals(Math.min(i), i, 0);
		}
		
		assertEquals(Math.max(3, 3) , 3, 0);
		assertEquals(Math.max(-3, 3), 3, 0);
		assertEquals(Math.max(3, -3), 3, 0);
		
		assertEquals(Math.min(3, 3) ,  3, 0);
		assertEquals(Math.min(-3, 3), -3, 0);
		assertEquals(Math.min(3, -3), -3, 0);
		
		List<Float> vals = new ArrayList<>();
		for(float i = -1001; i<= 1000; i++){
			vals.add(i);
		}
		
		for(int i = 0; i<1000; i++){
			Collections.shuffle(vals);
			float[] arr = new float[vals.size()];
			for(int k = 0; k<vals.size(); k++){
				arr[k] = vals.get(k);
			}
			assertEquals(Math.max(arr),     1000, 0);
			assertEquals(Math.min(arr),    -1001, 0);
			assertEquals(Math.maxAbs(arr),  1001, 0);
			assertEquals(Math.minAbs(arr),     0, 0);
		}
		
		for(float i = -1000; i<= 1000; i+=0.001){
			assertEquals(Math.maxAbs(i), Math.abs(i), 0);
			assertEquals(Math.minAbs(i), Math.abs(i), 0);
		}
		
		assertEquals(Math.maxAbs(4, 3) , 4, 0);
		assertEquals(Math.maxAbs(-4, 3), 4, 0);
		assertEquals(Math.maxAbs(4, -3), 4, 0);
		
		assertEquals(Math.minAbs(4, 3) , 3, 0);
		assertEquals(Math.minAbs(-4, 3), 3, 0);
		assertEquals(Math.minAbs(4, -3), 3, 0);

		assertEquals(Math.clamp(0, -19, 19), 0, 0);
		assertEquals(Math.clamp(10, -19, 19), 10, 0);
		assertEquals(Math.clamp(100, -19, 19), 19, 0);
		assertEquals(Math.clamp(-10, -19, 19), -10, 0);
		assertEquals(Math.clamp(-100, -19, 19), -19, 0);
		assertEquals(Math.clamp(Float.POSITIVE_INFINITY, -19, 19), 19, 0);
		assertEquals(Math.clamp(Float.NEGATIVE_INFINITY, -19, 19), -19, 0);

		assertEquals(Math.clamp01(-0.1f), 0, 0);
		assertEquals(Math.clamp01(-0.0f), 0, 0);
		assertEquals(Math.clamp01(0.1f), 0.1f, 0);
		assertEquals(Math.clamp01(0.2f), 0.2f, 0);
		assertEquals(Math.clamp01(0.3f), 0.3f, 0);
		assertEquals(Math.clamp01(0.4f), 0.4f, 0);
		assertEquals(Math.clamp01(0.5f), 0.5f, 0);
		assertEquals(Math.clamp01(0.6f), 0.6f, 0);
		assertEquals(Math.clamp01(0.7f), 0.7f, 0);
		assertEquals(Math.clamp01(0.8f), 0.8f, 0);
		assertEquals(Math.clamp01(0.9f), 0.9f, 0);
		assertEquals(Math.clamp01(1.0f), 1, 0);
		assertEquals(Math.clamp01(1.1f), 1, 0);
		assertEquals(Math.clamp01(1.2f), 1, 0);
		assertEquals(Math.clamp01(Float.POSITIVE_INFINITY), 1, 0);
		assertEquals(Math.clamp01(Float.NEGATIVE_INFINITY), 0, 0);
	}

}
