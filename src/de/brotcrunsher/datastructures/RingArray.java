package de.brotcrunsher.datastructures;

import java.util.Arrays;

import de.brotcrunsher.math.linear.Math;

public class RingArray<T> {
	private T[] data;
	
	
	
	@SuppressWarnings("unchecked")
	public RingArray(int length){
		data = (T[])new Object[length];
	}
	
	public RingArray(T... data){
		this.data = Arrays.copyOf(data, data.length);
	}
	
	public T get(int index){
		index = Math.mod(index, data.length);
		return data[index];
	}
	
	public void set(int index, T data){
		index = Math.mod(index, this.data.length);
		this.data[index] = data;
	}
	
	public int getLength(){
		return data.length;
	}
	
	@Override
	public RingArray<T> clone(){
		return new RingArray<T>(data);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof RingArray<?>)){
			return false;
		}
		if(this == obj){
			return true;
		}
		RingArray<T> other = (RingArray<T>) obj;
		if(this.data.length != other.data.length){
			return false;
		}
		for(int i = 0; i<other.getLength(); i++){
			if(!(this.data[i].equals(other.data[i]))){
				return false;
			}
		}
		return true;
	}
	
	@Override
	protected final void finalize() throws Throwable {
		super.finalize();
	}
	
	@Override
	public int hashCode() {
		int hash = 0;
		for(int i = 0; i<data.length; i++){
			hash += data[i].hashCode();
		}
		return hash;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		for(int i = 0; i<data.length; i++){
			sb.append(data[i].toString());
			if(i != data.length - 1){
				sb.append(", ");
			}
		}
		sb.append("}");
		return sb.toString();
	}
}
