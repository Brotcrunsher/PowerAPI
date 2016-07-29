package de.brotcrunsher.math.shapes;

import de.brotcrunsher.gfx.rendering.Renderer;
import de.brotcrunsher.math.linear.Vector2;

public class Circle extends Shape{
	protected float radius;
	
	public Circle(Vector2 pos, float radius){
		//TESTED
		this.pos = pos;
		this.radius = radius;
	}
	
	public Circle(float x, float y, float radius){
		//TESTED
		this(new Vector2(x, y), radius);
	}
	
	public void setRadius(float radius){
		//TESTED
		this.radius = radius;
	}
	public float getRadius(){
		//TESTED
		return radius;
	}

	@Override
	public boolean contains(float x, float y) {
		//TESTED
		float distSq = Vector2.distanceBetweenSq(pos, x, y);
		return distSq <= radius * radius;
	}

	@Override
	public boolean contains(Circle c) {
		float distSq = Vector2.distanceBetweenSq(pos, c.pos);
		float localRadius = this.radius - c.radius;
		return distSq <= localRadius * localRadius;
	}

	@Override
	public boolean contains(Rect r) {
		if(!contains(r.getLeft() , r.getTop())   ) return false;
		if(!contains(r.getLeft() , r.getBottom())) return false;
		if(!contains(r.getRight(), r.getTop())   ) return false;
		if(!contains(r.getRight(), r.getBottom())) return false;
		
		return true;
	}

	@Override
	public boolean intersects(Circle c) {
		return pos.isCloseTo(c.pos, this.radius + c.radius);
	}

	@Override
	public boolean intersects(Rect r) {
		return r.intersects(this);
	}

	@Override
	public Shape draw(Renderer r) {
		r.fillOval(pos, radius * 2, radius * 2);
		return this;
	}

	@Override
	public float getCenterX() {
		//TESTED
		return pos.getX();
	}

	@Override
	public float getCenterY() {
		//TESTED
		return pos.getY();
	}

	@Override
	public float getTop() {
		//TESTED
		return pos.getY() - radius;
	}

	@Override
	public float getBottom() {
		//TESTED
		return pos.getY() + radius;
	}

	@Override
	public float getLeft() {
		//TESTED
		return pos.getX() - radius;
	}

	@Override
	public float getRight() {
		//TESTED
		return pos.getX() + radius;
	}
}
