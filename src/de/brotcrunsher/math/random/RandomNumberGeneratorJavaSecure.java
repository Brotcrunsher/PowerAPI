package de.brotcrunsher.math.random;

import java.security.Provider;
import java.security.SecureRandom;
import java.util.Random;

public class RandomNumberGeneratorJavaSecure implements RandomNumberGenerator{
	private SecureRandom rand;
	
	public RandomNumberGeneratorJavaSecure(){
		rand = new SecureRandom();
	}
	
	public RandomNumberGeneratorJavaSecure(byte[] seed){
		rand = new SecureRandom(seed);
	}
	
	public RandomNumberGeneratorJavaSecure(SecureRandom rand){
		if(rand == null) throw new NullPointerException();
		this.rand = rand;
	}
	
	public byte[] generateSeed(int numBytes){
		return rand.generateSeed(numBytes);
	}
	
	public String getAlgorithm(){
		return rand.getAlgorithm();
	}
	
	public Provider getProvider(){
		return rand.getProvider();
	}
	
	@Override
	public void nextBytes(byte[] bytes){
		rand.nextBytes(bytes);
	}
	
	public void setSeed(byte[] seed){
		rand.setSeed(seed);
	}
	
	
	@Override
	public boolean nextBoolean() {
		return rand.nextBoolean();
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
