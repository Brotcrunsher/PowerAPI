package de.brotcrunsher.math.shapes;

import de.brotcrunsher.gfx.rendering.Renderer;
import de.brotcrunsher.math.linear.Vector2;

public class Point extends Shape{
	
	public Point(Vector2 pos){
		// TODO Test
		this.pos = pos;
	}
	public Point(float x, float y){
		// TODO Test
		this(new Vector2(x, y));
	}
	
	@Override
	public boolean contains(float x, float y) {
		// TODO Test
		return this.pos.getX() == x && this.pos.getY() == y;
	}

	@Override
	public boolean contains(Circle c) {
		// TODO Test
		if(c.getRadius() > 0) return false;
		return this.pos.getX() == c.pos.getX() && this.pos.getY() == c.pos.getY();
	}

	@Override
	public boolean contains(Rect r) {
		// TODO Test
		if(r.dimensions.getX() != 0 || r.dimensions.getY() != 0) return false;
		return this.pos.getX() == r.pos.getX() && this.pos.getY() == r.pos.getY();
	}

	@Override
	protected Vector2 getClosestPointTo_(Vector2 result, float x, float y) {
		// TODO Test
		result.setX(x);
		result.setY(y);
		return result;
	}

	@Override
	public boolean intersects(Circle c) {
		// TODO Test
		return c.contains(pos);
	}

	@Override
	public boolean intersects(Rect r) {
		// TODO Test
		return r.contains(pos);
	}

	@Override
	public Point draw(Renderer r) {
		// TODO Test
		r.drawPixel(pos);
		return this;
	}

	@Override
	public float getCenterX() {
		// TODO Test
		return pos.getX();
	}

	@Override
	public float getCenterY() {
		// TODO Test
		return pos.getY();
	}

	@Override
	public float getTop() {
		// TODO Test
		return pos.getY();
	}

	@Override
	public float getBottom() {
		// TODO Test
		return pos.getY();
	}

	@Override
	public float getLeft() {
		// TODO Test
		return pos.getX();
	}

	@Override
	public float getRight() {
		// TODO Test
		return pos.getX();
	}

}
