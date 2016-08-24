package de.brotcrunsher.math.shapes;

import de.brotcrunsher.gfx.rendering.Renderer;
import de.brotcrunsher.math.linear.Vector2;

public class LineSegment extends Shape{
	protected Vector2 stop;
	
	
	public LineSegment(Vector2 start, Vector2 stop){
		if(start == null) throw new NullPointerException("Start was null");
		if(stop == null) throw new NullPointerException("Stop was null");
		
		this.pos = start;
		this.stop = stop;
	}
	
	public float length(){
		return Vector2.distanceBetween(pos, stop);
	}
	
	public float distance(Vector2 point){
		//TODO test
		return distance(point.getX(), point.getY());
	}
	
	public float distance(float x, float y){
		//TODO
		return 0;
	}
	
	public Vector2 getDirection(Vector2 result){
		//TODO
		if(result == null){
			result = new Vector2();
		}
		
		result.set(stop);
		result.subThis(pos);
		
		return result;
	}
	
	@Override
	public boolean contains(float x, float y) {
		// TODO TEST
		return distance(x, y) < 0.1f;
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
