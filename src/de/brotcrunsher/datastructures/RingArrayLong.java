package de.brotcrunsher.datastructures;

import java.util.Arrays;

import de.brotcrunsher.math.linear.Math;

public class RingArrayLong{
	private long[] data;
	
	public RingArrayLong(int length){
		//TESTED
		data = new long[length];
	}
	
	public RingArrayLong(long... data){
		//TESTED
		this.data = Arrays.copyOf(data, data.length);
	}
	
	public long get(int index){
		//TESTED
		index = Math.mod(index, data.length);
		return data[index];
	}
	
	public void set(int index, long data){
		//TESTED
		index = Math.mod(index, this.data.length);
		this.data[index] = data;
	}
	
	public int getLength(){
		//TESTED
		return data.length;
	}
	
	public float calculateAvg(){
		//TESTED
		return calculateSum() / (float)data.length;
	}
	
	public long calculateSum(){
		//TESTED
		long sum = 0;
		for(int i = 0; i<data.length; i++){
			sum += data[i];
		}
		return sum;
	}
}
