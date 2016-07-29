package de.brotcrunsher.math.shapes;

import de.brotcrunsher.gfx.rendering.Renderer;
import de.brotcrunsher.math.linear.Vector2;

public class Rect extends Shape{
	protected Vector2 dimensions;
	
	public Rect(Vector2 pos, Vector2 dimensions){
		this.pos = pos;
		this.dimensions = dimensions;
	}
	
	public Rect(float x, float y, float width, float height){
		this(new Vector2(x, y), new Vector2(width, height));
	}
	public Rect(float x, float y, Vector2 dimensions){
		this(new Vector2(x, y), dimensions);
	}
	public Rect(Vector2 pos, float width, float height){
		this(pos, new Vector2(width, height));
	}
	
	public void setWidth(float width){
		dimensions.setX(width);
	}
	public void setHeight(float height){
		dimensions.setY(height);
	}
	public void setDimensions(float width, float height){
		setWidth(width);
		setHeight(height);
	}
	public void setDimensions(Vector2 dimensions){
		this.dimensions = dimensions;
	}
	
	@Override
	public boolean contains(float x, float y) {
		return  x >= pos.getX()                     && 
				y >= pos.getY()                     && 
				x <= pos.getX() + dimensions.getX() && 
				y <= pos.getY() + dimensions.getY();
	}

	@Override
	public boolean contains(Circle c) {
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
		r.fillRect(pos, dimensions);
		return this;
	}

	@Override
	public float getCenterX() {
		return pos.getX() + dimensions.getX() / 2;
	}

	@Override
	public float getCenterY() {
		return pos.getY() + dimensions.getY() / 2;
	}

	@Override
	public float getTop() {
		return pos.getY();
	}

	@Override
	public float getBottom() {
		return pos.getY() + dimensions.getY();
	}

	@Override
	public float getLeft() {
		return pos.getX();
	}

	@Override
	public float getRight() {
		return pos.getX() + dimensions.getX();
	}
}
