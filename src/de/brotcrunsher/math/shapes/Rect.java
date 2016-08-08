package de.brotcrunsher.math.shapes;

import de.brotcrunsher.gfx.rendering.Renderer;
import de.brotcrunsher.math.linear.FMath;
import de.brotcrunsher.math.linear.Vector2;

public class Rect extends Shape{
	protected Vector2 dimensions;
	
	public Rect(Vector2 pos, Vector2 dimensions){
		//TODO TEST
		this.pos = pos;
		this.dimensions = dimensions;
	}
	
	public Rect(float x, float y, float width, float height){
		//TODO TEST
		this(new Vector2(x, y), new Vector2(width, height));
	}
	public Rect(float x, float y, Vector2 dimensions){
		//TODO TEST
		this(new Vector2(x, y), dimensions);
	}
	public Rect(Vector2 pos, float width, float height){
		//TODO TEST
		this(pos, new Vector2(width, height));
	}
	
	public void setWidth(float width){
		//TODO TEST
		dimensions.setX(width);
	}
	public void setHeight(float height){
		//TODO TEST
		dimensions.setY(height);
	}
	public void setDimensions(float width, float height){
		//TODO TEST
		setWidth(width);
		setHeight(height);
	}
	public void setDimensions(Vector2 dimensions){
		//TODO TEST
		this.dimensions = dimensions;
	}
	
	@Override
	public boolean contains(float x, float y) {
		//TODO TEST
		return  x >= pos.getX()                     && 
				y >= pos.getY()                     && 
				x <= pos.getX() + dimensions.getX() && 
				y <= pos.getY() + dimensions.getY();
	}

	@Override
	public boolean contains(Circle c) {
		//TODO TEST
		//t == this      o == other
		//W == Width     H == Height     R == Radius
		float tX = this.pos.getX();
		float tY = this.pos.getY();
		float tW = this.dimensions.getX();
		float tH = this.dimensions.getY();
		float oX = c   .pos.getX();
		float oY = c   .pos.getY();
		float oR = c   .getRadius();
		
		if(oX - oR < tX) return false;
		if(oY - oR < tY) return false;
		if(oX + oR > tX + tW) return false;
		if(oY + oR > tY + tH) return false;
		
		return true;
	}

	@Override
	public boolean contains(Rect r) {
		//TODO TEST
		if(r == this) return true;
		
		//t == this      o == other
		//W == Width     H == Height
		float tX = this.pos.getX();
		float tY = this.pos.getY();
		float tW = this.dimensions.getX();
		float tH = this.dimensions.getY();
		float oX = r   .pos.getX();
		float oY = r   .pos.getY();
		float oW = r   .dimensions.getX();
		float oH = r   .dimensions.getY();
		
		if(oX < tX) return false;
		if(oY < tY) return false;
		if(oX > tX + tW - oW) return false;
		if(oY > tY + tH - oH) return false;
		
		return true;
	}

	@Override
	public boolean intersects(Circle c) {
		//TODO TEST
		//t == this      o == other
		//W == Width     H == Height     R == Radius
		float tX = this.pos.getX();
		float tY = this.pos.getY();
		float tW = this.dimensions.getX();
		float tH = this.dimensions.getY();
		float oX = c   .pos.getX();
		float oY = c   .pos.getY();
		float oR = c   .getRadius();
		
		if(oX >= tX - oR && 
				oY >= tY &&
				oX <= tX + tW + oR &&
				oY <= tY + tH
				){
			return true;
		}
		
		if(oX >= tX &&
				oY >= tY - oR &&
				oX <= tX + tW &&
				oY <= tY + tH + oR
				){
			return true;
		}
		
		float oR2 = oR * oR;

		if(Vector2.distanceBetweenSq(tX     , tY     , oX, oY) <= oR2) return true;
		if(Vector2.distanceBetweenSq(tX + tW, tY     , oX, oY) <= oR2) return true;
		if(Vector2.distanceBetweenSq(tX     , tY + tH, oX, oY) <= oR2) return true;
		if(Vector2.distanceBetweenSq(tX + tW, tY + tH, oX, oY) <= oR2) return true;
		
		
		return false;
	}

	@Override
	public boolean intersects(Rect r) {
		//TODO TEST
		if(r == this) return true;
		
		//t == this      o == other
		//W == Width     H == Height
		float tX = this.pos.getX();
		float tY = this.pos.getY();
		float tW = this.dimensions.getX();
		float tH = this.dimensions.getY();
		float oX = r   .pos.getX();
		float oY = r   .pos.getY();
		float oW = r   .dimensions.getX();
		float oH = r   .dimensions.getY();
		
		if(oX < tX - oW) return false;
		if(oY < tY - oH) return false;
		if(oX > tX + tW) return false;
		if(oY > tY + tH) return false;
		
		return true;
	}

	@Override
	public Shape draw(Renderer r) {
		//TODO TEST
		r.fillRect(pos, dimensions);
		return this;
	}

	@Override
	public float getCenterX() {
		//TODO TEST
		return pos.getX() + dimensions.getX() / 2;
	}

	@Override
	public float getCenterY() {
		//TODO TEST
		return pos.getY() + dimensions.getY() / 2;
	}

	@Override
	public float getTop() {
		//TODO TEST
		return pos.getY();
	}

	@Override
	public float getBottom() {
		//TODO TEST
		return pos.getY() + dimensions.getY();
	}

	@Override
	public float getLeft() {
		//TODO TEST
		return pos.getX();
	}

	@Override
	public float getRight() {
		//TODO TEST
		return pos.getX() + dimensions.getX();
	}

	@Override
	protected Vector2 getClosestPointTo_(Vector2 result, float x, float y) {
		x = FMath.clamp(x, this.pos.getX(), this.pos.getX() + this.dimensions.getX());
		y = FMath.clamp(y, this.pos.getY(), this.pos.getY() + this.dimensions.getY());
		result.set(x, y);
		return result;
	}
}
