package de.brotcrunsher.datastructures;

import java.util.Arrays;

import de.brotcrunsher.math.linear.FMath;

public class RingArray<T> {
	private T[] data;
	
	
	
	@SuppressWarnings("unchecked")
	public RingArray(int length){
		//TODO TEST
		data = (T[])new Object[length];
	}
	
	public RingArray(T... data){
		//TODO TEST
		this.data = Arrays.copyOf(data, data.length);
	}
	
	public T get(int index){
		//TODO TEST
		index = FMath.mod(index, data.length);
		return data[index];
	}
	
	public void set(int index, T data){
		//TODO TEST
		index = FMath.mod(index, this.data.length);
		this.data[index] = data;
	}
	
	public int getLength(){
		//TODO TEST
		return data.length;
	}
	
	@Override
	public RingArray<T> clone(){
		//TODO TEST
		return new RingArray<T>(data);
	}
	
	@Override
	public boolean equals(Object obj) {
		//TODO TEST
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
		//TODO TEST
		int hash = 0;
		for(int i = 0; i<data.length; i++){
			hash += data[i].hashCode();
		}
		return hash;
	}
	
	@Override
	public String toString() {
		//TODO TEST
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
