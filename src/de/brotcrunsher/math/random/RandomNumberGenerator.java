package de.brotcrunsher.math.random;

public interface RandomNumberGenerator {
	public boolean nextBoolean();
	public void nextBytes(byte[] bytes);
	public double nextDouble();
	public float nextFloat();
	public float nextGaussian();
	public int nextInt();
	public int nextInt(int n);
	public long nextLong();
	public void setSeed(long seed);
}
