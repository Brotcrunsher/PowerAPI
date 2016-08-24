package de.brotcrunsher.math.shapes;

import de.brotcrunsher.gfx.rendering.Renderer;
import de.brotcrunsher.math.linear.FMath;
import de.brotcrunsher.math.linear.ThreadLocalVector2;
import de.brotcrunsher.math.linear.Vector2;

public class Ellipse extends Shape{
	private static ThreadLocalVector2 workingVector1 = new ThreadLocalVector2();
	private static ThreadLocalVector2 workingVector2 = new ThreadLocalVector2();
	private static ThreadLocalVector2 workingVector3 = new ThreadLocalVector2();
	
	
	protected Vector2 dimensions;
	
	public Ellipse(Vector2 pos, Vector2 dimensions){
		//TODO TEST
		this.pos = pos;
		this.dimensions = dimensions;
	}
	
	public Ellipse(float x, float y, float width, float height){
		//TODO TEST
		this(new Vector2(x, y), new Vector2(width, height));
	}
	public Ellipse(float x, float y, Vector2 dimensions){
		//TODO TEST
		this(new Vector2(x, y), dimensions);
	}
	public Ellipse(Vector2 pos, float width, float height){
		//TODO TEST
		this(pos, new Vector2(width, height));
	}
	
	public boolean isCircle(){
		//TODO TEST
		return FMath.abs(dimensions.getX()) == FMath.abs(dimensions.getY());
	}
	
	public void getFociPoints(Vector2 result1, Vector2 result2){
		//TODO TEST
		if(result1 == null) throw new NullPointerException();
		if(result2 == null) throw new NullPointerException();
		
		float a = FMath.abs(dimensions.getX() / 2);
		float b = FMath.abs(dimensions.getY() / 2);
		
		if(a == b){ //"Ellipse" is a circle!
			result1.set(getCenterX(), getCenterY());
			result2.set(result1);
		}else if(a > b){ //Ellipse has greater width
			float f = FMath.sqrt(a * a - b * b);
			result1.set(getCenterX() - f, getCenterY());
			result2.set(getCenterX() + f, getCenterY());
		}else{ //Ellipse has greater height
			float f = FMath.sqrt(b * b - a * a);
			result1.set(getCenterX(), getCenterY() - f);
			result2.set(getCenterX(), getCenterY() + f);
		}
	}
	
	public float getDominantRadius(){
		//TODO TEST
		return FMath.maxAbs(dimensions.getX() / 2, dimensions.getY() / 2);
	}
	
	@Override
	public boolean contains(float x, float y) {
		//TODO TEST
		float distSumToFociPoints = getDominantRadius() * 2;
		Vector2 foci1 = workingVector1.get();
		Vector2 foci2 = workingVector2.get();
		
		getFociPoints(foci1, foci2);
		float distSum = Vector2.distanceBetween(foci1, x, y) + Vector2.distanceBetween(foci2, x, y);
		
		return distSum <= distSumToFociPoints;
	}

	@Override
	public boolean contains(Circle c) {
		//TODO
		return false;
	}

	@Override
	public boolean contains(Rect r) {
		//TODO test
		if(!contains(r.pos.getX(), r.pos.getY())){
			return false;
		}
		if(!contains(r.pos.getX() + r.dimensions.getX(), r.pos.getY())){
			return false;
		}
		if(!contains(r.pos.getX(), r.pos.getY() + r.dimensions.getY())){
			return false;
		}
		if(!contains(r.pos.getX() + r.dimensions.getX(), r.pos.getY() + r.dimensions.getY())){
			return false;
		}
		return true;
	}

	@Override
	public boolean intersects(Circle c) {
		//TODO TEST
		if(contains(c.getCenterX(), c.getCenterY())) return true;
		
		float dist = Vector2.distanceBetween(this.pos, c.pos);
		
		
		
		if(dist < c.getRadius() + getRadiusTo(c.pos)){
			return true;
		}
		
		
		float radiVal = FMath.SQRT2INV * c.getRadius();

		if(contains(c.getCenterX() + radiVal, c.getCenterY() + radiVal)) return true;
		if(contains(c.getCenterX() - radiVal, c.getCenterY() + radiVal)) return true;
		if(contains(c.getCenterX() + radiVal, c.getCenterY() - radiVal)) return true;
		if(contains(c.getCenterX() - radiVal, c.getCenterY() - radiVal)) return true;
		
		return false;
	}

	@Override
	public boolean intersects(Rect r) {
		//TODO
		return false;
	}

	@Override
	public Ellipse draw(Renderer r) {
		//TODO TEST
		r.fillOval(pos, dimensions);
		return this;
	}

	@Override
	public float getCenterX() {
		//TODO TEST
		return this.pos.getX();
	}

	@Override
	public float getCenterY() {
		//TODO TEST
		return this.pos.getY();
	}

	@Override
	public float getTop() {
		//TODO TEST
		return this.getCenterY() - dimensions.getY() / 2;
	}

	@Override
	public float getBottom() {
		//TODO TEST
		return this.getCenterY() + dimensions.getY() / 2;
	}

	@Override
	public float getLeft() {
		//TODO TEST
		return this.getCenterX() - dimensions.getX() / 2;
	}

	@Override
	public float getRight() {
		//TODO TEST
		return this.getCenterY() - dimensions.getY() / 2;
	}

	@Override
	protected Vector2 getClosestPointTo_(Vector2 result, float x, float y) {
		result.set(x, y);
		
		result.subThis(this.pos);
		
		float r = getRadiusTo(x, y);
		
		result.setLengthThis(r);
		result.addThis(this.pos);
		
		return result;
	}
	
	public float getRadiusTo(Vector2 pos){
		//TODO TEST
		return getRadiusTo(pos.getX(), pos.getY());
	}
	
	public float getRadiusTo(float x, float y){
		//TODO TEST
		Vector2 thisCenterToXY = workingVector1.get();
		thisCenterToXY.set(x, y);
		thisCenterToXY.subThis(this.pos);
		
		float angle = thisCenterToXY.headingAngle();
		
		float a = dimensions.getY() / 2;
		float b = dimensions.getX() / 2;
		float r = a * b / (FMath.sqrt(FMath.square(a * FMath.cos(angle)) + FMath.square(b * FMath.sin(angle))));
		return r;
	}

}
