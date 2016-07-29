package de.brotcrunsher.math.shapes;

import de.brotcrunsher.gfx.rendering.Renderer;
import de.brotcrunsher.math.linear.Vector2;

public abstract class Shape {
	protected Vector2 pos;
	
	public boolean contains(Vector2 point){
		//TESTED
		return contains(point.getX(), point.getY());
	}
	public abstract boolean contains(float x, float y);
	public abstract boolean contains(Circle c);
	public abstract boolean contains(Rect r);
	public boolean contains(Shape s){
		if(s instanceof Circle){
			return contains((Circle)s);
		}else if(s instanceof Rect){
			return contains((Rect)s);
		}else{
			throw new IllegalArgumentException("Shape not supported");
		}
	}
	
	public boolean intersects(Vector2 point){
		//TESTED
		return contains(point);
	}
	public boolean intersects(float x, float y){
		//TESTED
		return contains(x, y);
	}
	public abstract boolean intersects(Circle c);
	public abstract boolean intersects(Rect r);
	public boolean intersects(Shape s){
		if(s instanceof Circle){
			return intersects((Circle)s);
		}else if(s instanceof Rect){
			return intersects((Rect)s);
		}else{
			throw new IllegalArgumentException("Shape not supported");
		}
	}
	
	public abstract Shape draw(Renderer r);
	
	public abstract float getCenterX();
	public abstract float getCenterY();
	public abstract float getTop();
	public abstract float getBottom();
	public abstract float getLeft();
	public abstract float getRight();
	
	public void setX(float x){
		pos.setX(x);
	}
	public void setY(float y){
		pos.setY(y);
	}
	public void setXY(float x, float y){
		setX(x);
		setY(y);
	}
	public void setXY(Vector2 pos){
		this.pos = pos;
	}
	
	public float getX(){
		//TESTED
		return pos.getX();
	}
	public float getY(){
		//TESTED
		return pos.getY();
	}
	public Vector2 getPos(){
		return pos;
	}
	
}
