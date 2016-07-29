package de.brotcrunsher.gfx.rendering;

import de.brotcrunsher.math.linear.Vector2;

public abstract class Image {
	private Vector2 pivot = new Vector2();
	
	public abstract float getWidth();
	public abstract float getHeight();
	
	public Vector2 getPivot(){
		return pivot;
	}
	public void setPivot(Vector2 pivot){
		this.pivot = pivot;
	}
}
