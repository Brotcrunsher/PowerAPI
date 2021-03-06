package de.brotcrunsher.math.graphs;

import de.brotcrunsher.gfx.rendering.Renderer;

public class Grid {
	public final int WIDTH;
	public final int HEIGHT;
	private final boolean[][] isBlocked;
	
	public Grid(int width, int height){
		//TODO TEST
		WIDTH = width;
		HEIGHT = height;
		isBlocked = new boolean[width][height];
	}
	
	public boolean isInRange(int x, int y){
		//TODO TEST
		if(x < 0) return false;
		if(y < 0) return false;
		if(x >= WIDTH) return false;
		if(y >= HEIGHT) return false;
		
		return true;
	}
	
	public boolean isBlocked(int x, int y){
		//TODO TEST
		if(!isInRange(x, y)){
			return true;
		}
		return isBlocked[x][y];
	}
	
	public void setBlocked(int x, int y){
		//TODO TEST
		setBlocked(x, y, true);
	}
	
	public void setBlocked(int x, int y, boolean value){
		//TODO TEST
		isBlocked[x][y] = value;
	}
	
	
	public void draw(Renderer r, float cellwidth, float cellheight){
		//TODO TEST
		for(int i = -1; i<=WIDTH; i++){
			for(int k = -1; k<=HEIGHT; k++){
				if(isBlocked(i, k)){
					r.fillRect(i * cellwidth, k * cellheight, cellwidth, cellheight);
				}
			}
		}
	}
}
