package de.brotcrunsher.math.random;

import java.util.Random;

public class RandomNumberGeneratorJavaDefault implements RandomNumberGenerator {
	private Random rand;
	
	public RandomNumberGeneratorJavaDefault() {
		rand = new Random();
	}
	
	public RandomNumberGeneratorJavaDefault(long seed){
		rand = new Random(seed);
	}
	
	public RandomNumberGeneratorJavaDefault(Random rand){
		if(rand == null) throw new NullPointerException();
		this.rand = rand;
	}
	
	@Override
	public boolean nextBoolean() {
		return rand.nextBoolean();
	}

	@Override
	public void nextBytes(byte[] bytes) {
		rand.nextBytes(bytes);
		
	}

	@Override
	public double nextDouble() {
		return rand.nextDouble();
	}

	@Override
	public float nextFloat() {
		return rand.nextFloat();
	}

	@Override
	public float nextGaussian() {
		return (float)rand.nextGaussian();
	}

	@Override
	public int nextInt() {
		return rand.nextInt();
	}

	@Override
	public int nextInt(int n) {
		return rand.nextInt(n);
	}

	@Override
	public long nextLong() {
		return rand.nextLong();
	}

	@Override
	public void setSeed(long seed) {
		rand.setSeed(seed);
	}

}
