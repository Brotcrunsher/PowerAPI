package de.brotcrunsher.math.shapes;

import de.brotcrunsher.gfx.rendering.Renderer;
import de.brotcrunsher.math.linear.Vector2;

public class Polygon extends Shape{

	@Override
	public boolean contains(float x, float y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(Circle c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(Rect r) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected Vector2 getClosestPointTo_(Vector2 result, float x, float y) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean intersects(Circle c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean intersects(Rect r) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Shape draw(Renderer r) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public float getCenterX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getCenterY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getTop() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getBottom() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getLeft() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getRight() {
		// TODO Auto-generated method stub
		return 0;
	}

}
