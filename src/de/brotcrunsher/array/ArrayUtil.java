package de.brotcrunsher.array;

import de.brotcrunsher.math.linear.FMath;

public class ArrayUtil {
	
	public static void standardize(float[] array){
		float max = Float.NEGATIVE_INFINITY;
		float min = Float.POSITIVE_INFINITY;
		
		for(int i = 0; i<array.length; i++){
			float val = array[i];
			if(val > max){
				max = val;
			}
			if(val < min){
				min = val;
			}
		}
		
		float maxMin = max - min;
		
		for(int i = 0; i<array.length; i++){
			array[i] = (array[i] - min) / maxMin;
		}
	}
	
	public static void standardize(float[][] array){
		float max = Float.NEGATIVE_INFINITY;
		float min = Float.POSITIVE_INFINITY;
		
		for(int i = 0; i<array.length; i++){
			for(int k = 0; k<array[i].length; k++){
				float val = array[i][k];
				if(val > max){
					max = val;
				}
				if(val < min){
					min = val;
				}
			}
		}
		
		float maxMin = max - min;
		
		for(int i = 0; i<array.length; i++){
			for(int k = 0; k<array[i].length; k++){
				array[i][k] = (array[i][k] - min) / maxMin;
			}
		}
	}
	
	public static boolean isIndexInsideArray(float[][] array, int x, int y){
		if(x >= array.length) return false;
		if(x < 0) return false;
		if(y >= array[x].length) return false;
		if(y < 0) return false;
		
		return true;
	}
	
	public static float getValueTiled(float[][] array, int x, int y){
		x = FMath.repeat(x, array.length);
		y = FMath.repeat(y, array[x].length);
		return array[x][y];
	}
	
	public static void setValueTiled(float[][] array, int x, int y, float val){
		x = FMath.repeat(x, array.length);
		y = FMath.repeat(y, array[x].length);
		array[x][y] = val;
	}
	
	public static void smooth(float[][] result, float[][] array, boolean tiled, NeighborMode mode){
		if(result == null){
			result = new float[array.length][array[0].length];
		}
		
		if(result.length != array.length || result[0].length != array[0].length) throw new IllegalArgumentException("result and array must have same lengths");
		
		for(int i = 0; i<array.length; i++){
			for(int k = 0; k<array[i].length; k++){
				float sum = array[i][k] + calculateSumOfNeighbors(array, i, k, tiled, mode);
				int amount = getAmountOfNeighbors(array, i, k, tiled, mode) + 1;
				result[i][k] = sum / amount;
			}
		}
	}
	
	public static int getAmountOfNeighbors(float[][] array, int x, int y, boolean tiled, NeighborMode mode){
		if(tiled){
			switch(mode){
			case diagonal:
				return 4;
			case eight:
				return 8;
			case four:
				return 4;
			case horizontal:
				return 2;
			case vertical:
				return 2;
			default:
				throw new IllegalArgumentException("NeighborMode not supported: " + mode);
			}
		}else{
			int amount = 0;
			switch(mode){
			case diagonal:
				if(isIndexInsideArray(array, x-1, y-1)){
					amount++;
				}
				if(isIndexInsideArray(array, x-1, y+1)){
					amount++;
				}
				if(isIndexInsideArray(array, x+1, y-1)){
					amount++;
				}
				if(isIndexInsideArray(array, x+1, y+1)){
					amount++;
				}
				break;
			case eight:
				amount += getAmountOfNeighbors(array, x, y, tiled, NeighborMode.four);
				amount += getAmountOfNeighbors(array, x, y, tiled, NeighborMode.diagonal);
				break;
			case four:
				amount += getAmountOfNeighbors(array, x, y, tiled, NeighborMode.horizontal);
				amount += getAmountOfNeighbors(array, x, y, tiled, NeighborMode.vertical);
				break;
			case horizontal:
				if(x > 0){
					amount++;
				}
				if(x < array.length-1){
					amount++;
				}
				break;
			case vertical:
				if(y > 0){
					amount++;
				}
				if(y < array[0].length-1){
					amount++;
				}
				break;
			default:
				throw new IllegalArgumentException("Unsupported NeighborMode " + mode);
			}
			
			return amount;
		}
	}
	
	public static float calculateSumOfNeighbors(float[][] array, int x, int y, boolean tiled, NeighborMode mode){
		float sum = 0;
		if(tiled){
			switch(mode){
			case diagonal:
				sum += getValueTiled(array, x-1, y-1);
				sum += getValueTiled(array, x-1, y+1);
				sum += getValueTiled(array, x+1, y-1);
				sum += getValueTiled(array, x+1, y+1);
				break;
			case eight:
				sum += calculateSumOfNeighbors(array, x, y, tiled, NeighborMode.diagonal);
				sum += calculateSumOfNeighbors(array, x, y, tiled, NeighborMode.four);
				break;
			case four:
				sum += calculateSumOfNeighbors(array, x, y, tiled, NeighborMode.horizontal);
				sum += calculateSumOfNeighbors(array, x, y, tiled, NeighborMode.vertical);
				break;
			case horizontal:
				sum += getValueTiled(array, x, y-1);
				sum += getValueTiled(array, x, y+1);
				break;
			case vertical:
				sum += getValueTiled(array, x-1, y);
				sum += getValueTiled(array, x+1, y);
				break;
			default:
				throw new IllegalArgumentException("");
			}
		}else{
			switch(mode){
			case diagonal:
				if(isIndexInsideArray(array, x-1, y-1)){
					sum += array[x-1][y-1];
				}
				if(isIndexInsideArray(array, x-1, y+1)){
					sum += array[x-1][y+1];
				}
				if(isIndexInsideArray(array, x+1, y-1)){
					sum += array[x+1][y-1];
				}
				if(isIndexInsideArray(array, x+1, y+1)){
					sum += array[x+1][y+1];
				}
				break;
			case eight:
				sum += calculateSumOfNeighbors(array, x, y, tiled, NeighborMode.four);
				sum += calculateSumOfNeighbors(array, x, y, tiled, NeighborMode.diagonal);
				break;
			case four:
				sum += calculateSumOfNeighbors(array, x, y, tiled, NeighborMode.horizontal);
				sum += calculateSumOfNeighbors(array, x, y, tiled, NeighborMode.vertical);
				break;
			case horizontal:
				if(x > 0){
					sum += array[x-1][y];
				}
				if(x < array.length-1){
					sum += array[x+1][y];
				}
				break;
			case vertical:
				if(y > 0){
					sum += array[x][y-1];
				}
				if(y < array[0].length-1){
					sum += array[x][y+1];
				}
				break;
			default:
				throw new IllegalArgumentException("Unsupported NeighborMode " + mode);
			}
		}
		
		return sum;
	}
}
