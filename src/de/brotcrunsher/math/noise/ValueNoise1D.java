package de.brotcrunsher.math.noise;

import de.brotcrunsher.array.ArrayUtil;
import de.brotcrunsher.math.linear.Interpolations;
import de.brotcrunsher.math.random.RandomNumberGenerator;
import de.brotcrunsher.math.random.RandomNumberGeneratorJavaDefault;

public class ValueNoise1D {
	private RandomNumberGenerator rng;
	private float[] values;
	private int octaves = 5;
	private InterpolationMode im = InterpolationMode.cubic;
	private final int WIDTH;
	private boolean calculated = false;
	private int frequency = 3;
	private float amplitudeDecreaseValue = 2;
	private float frequencyIncreaseValue = 2;
	private boolean tiled = true;
	
	public ValueNoise1D(int width){
		this(width, new RandomNumberGeneratorJavaDefault());
	}
	
	public ValueNoise1D(int width, RandomNumberGenerator rng){
		if(rng == null) throw new NullPointerException();
		this.WIDTH = width;
		this.rng = rng;
		values = new float[width];
	}
	
	public void calculate(){
		if(calculated) throw new IllegalStateException("Noise was already calculated");
		calculated = true;
		
		float frequency = this.frequency;
		float amplitude = 1;
		
		for(int oc = 0; oc<octaves; oc++){
			
			int currentFrequency = (int)frequency;
			float[] nodes = new float[currentFrequency + 2];
			for(int i = 0; i<nodes.length; i++){
				nodes[i] = rng.nextFloat() * amplitude;
			}
			if(tiled){
				nodes[nodes.length - 2] = nodes[1];
				nodes[nodes.length - 1] = nodes[2];
				nodes[0] = nodes[nodes.length - 3];
			}
			
			float distanceBetweenNodes = WIDTH / (currentFrequency - 1.0f);
			
			for(int i = 0; i< WIDTH; i++){
				float helpVal = i / distanceBetweenNodes;
				int aIndex = 1 + (int)helpVal;
				float t = helpVal - (int)helpVal;
				switch(im){
				case cubic:
					values[i] += Interpolations.cubic(nodes[aIndex - 1], nodes[aIndex], nodes[aIndex+1], nodes[aIndex + 2], t);
					break;
				case linear:
					values[i] += Interpolations.linear(nodes[aIndex], nodes[aIndex+1], t);
					break;
				case trigonometrie:
					values[i] += Interpolations.cosine(nodes[aIndex], nodes[aIndex+1], t);
					break;
				default:
					throw new IllegalStateException("Interpolation Mode not supported " + im);
				}
			}
			
			amplitude /= amplitudeDecreaseValue;
			frequency *= frequencyIncreaseValue;
		}
		

		ArrayUtil.standardize(values);
	}
	
	public float getValue(int index){
		if(!calculated) throw new IllegalStateException("Noise must be calculated first!");
		return values[index];
	}
}
