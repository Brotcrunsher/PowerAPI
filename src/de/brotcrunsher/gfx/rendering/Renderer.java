package de.brotcrunsher.gfx.rendering;

import de.brotcrunsher.gfx.basics.Color;
import de.brotcrunsher.math.linear.Vector2;

public interface Renderer {

	public void setColor(float r, float g, float b, float a);
	public default void setColor(float r, float g, float b){
		setColor(r, g, b, 1);
	}
	public default void setColor(Color color){
		setColor(color.getR(), color.getG(), color.getB(), color.getA());
	}
	
	public default void drawImage(Image img, Vector2 pos, Vector2 pivot){
		drawImage(img, pos.getX(), pos.getY(), pivot.getX(), pivot.getY());
	}
	public void drawImage(Image img, float x, float y, float pivotX, float pivotY);
	public default void drawImage(Image img, Vector2 pos, float pivotX, float pivotY){
		drawImage(img, pos.getX(), pos.getY(), pivotX, pivotY);
	}
	public default void drawImage(Image img, float x, float y, Vector2 pivot){
		drawImage(img, x, y, pivot.getX(), pivot.getY());
	}
	public default void drawImage(Image img, float x, float y){
		drawImage(img, x, y, img.getPivot().getX(), img.getPivot().getY());
	}
	public default void drawImage(Image img, Vector2 pos){
		drawImage(img, pos.getX(), pos.getY());
	}

	public void setLineWidth(float width);

	public void clearScreen();

	public void drawLine(float startX, float startY, float stopX, float stopY);
	public default void drawLine(Vector2 start, float stopX, float stopY) {
		assert start != null : "start was null!";
		drawLine(start.getX(), start.getY(), stopX, stopY);
	}
	public default void drawLine(float startX, float startY, Vector2 stop) {
		assert stop != null : "stop was null!";
		drawLine(startX, startY, stop.getX(), stop.getY());
	}
	public default void drawLine(Vector2 start, Vector2 stop) {
		assert start != null : "start was null!";
		assert stop != null : "stop was null!";
		drawLine(start.getX(), start.getY(), stop.getX(), stop.getY());
	}

	public void drawRect(float x, float y, float width, float height);
	public default void drawRect(Vector2 pos, float width, float height) {
		assert pos != null : "pos was null!";
		drawRect(pos.getX(), pos.getY(), width, height);
	}
	public default void drawRect(float x, float y, Vector2 dimensions) {
		assert dimensions != null : "dimensions was null!";
		drawRect(x, y, dimensions.getX(), dimensions.getY());
	}
	public default void drawRect(Vector2 pos, Vector2 dimensions) {
		assert pos != null : "pos was null!";
		assert dimensions != null : "dimensions was null!";
		drawRect(pos.getX(), pos.getY(), dimensions.getX(), dimensions.getY());
	}

	public void fillRect(float x, float y, float width, float height);
	public default void fillRect(Vector2 pos, float width, float height) {
		assert pos != null : "pos was null!";
		fillRect(pos.getX(), pos.getY(), width, height);
	}
	public default void fillRect(float x, float y, Vector2 dimensions) {
		assert dimensions != null : "dimensions was null!";
		fillRect(x, y, dimensions.getX(), dimensions.getY());
	}
	public default void fillRect(Vector2 pos, Vector2 dimensions) {
		assert pos != null : "pos was null!";
		assert dimensions != null : "dimensions was null!";
		fillRect(pos.getX(), pos.getY(), dimensions.getX(), dimensions.getY());
	}

	public void drawOval(float x, float y, float width, float height);
	public default void drawOval(Vector2 pos, float width, float height) {
		assert pos != null : "pos was null!";
		drawOval(pos.getX(), pos.getY(), width, height);
	}
	public default void drawOval(float x, float y, Vector2 dimensions) {
		assert dimensions != null : "dimensions was null!";
		drawOval(x, y, dimensions.getX(), dimensions.getY());
	}
	public default void drawOval(Vector2 pos, Vector2 dimensions) {
		assert pos != null : "pos was null!";
		assert dimensions != null : "dimensions was null!";
		drawOval(pos.getX(), pos.getY(), dimensions.getX(), dimensions.getY());
	}

	public void fillOval(float x, float y, float width, float height);
	public default void fillOval(Vector2 pos, float width, float height) {
		assert pos != null : "pos was null!";
		fillOval(pos.getX(), pos.getY(), width, height);
	}
	public default void fillOval(float x, float y, Vector2 dimensions) {
		assert dimensions != null : "dimensions was null!";
		fillOval(x, y, dimensions.getX(), dimensions.getY());
	}
	public default void fillOval(Vector2 pos, Vector2 dimensions) {
		assert pos != null : "pos was null!";
		assert dimensions != null : "dimensions was null!";
		fillOval(pos.getX(), pos.getY(), dimensions.getX(), dimensions.getY());
	}

	public void drawTriangle(float x0, float y0, float x1, float y1, float x2, float y2);
	public default void drawTriangle(Vector2 v0, float x1, float y1, float x2, float y2) {
		assert v0 != null : "v0 was null";
		drawTriangle(v0.getX(), v0.getY(), x1, y1, x2, y2);
	}
	public default void drawTriangle(float x0, float y0, Vector2 v1, float x2, float y2) {
		assert v1 != null : "v1 was null";
		drawTriangle(x0, y0, v1.getX(), v1.getY(), x2, y2);
	}
	public default void drawTriangle(Vector2 v0, Vector2 v1, float x2, float y2) {
		assert v0 != null : "v0 was null";
		assert v1 != null : "v1 was null";
		drawTriangle(v0.getX(), v0.getY(), v1.getX(), v1.getY(), x2, y2);
	}
	public default void drawTriangle(float x0, float y0, float x1, float y1, Vector2 v2) {
		assert v2 != null : "v2 was null";
		drawTriangle(x0, y0, x1, y1, v2.getX(), v2.getY());
	}
	public default void drawTriangle(Vector2 v0, float x1, float y1, Vector2 v2) {
		assert v0 != null : "v0 was null";
		assert v2 != null : "v2 was null";
		drawTriangle(v0.getX(), v0.getY(), x1, y1, v2.getX(), v2.getY());
	}
	public default void drawTriangle(float x0, float y0, Vector2 v1, Vector2 v2) {
		assert v1 != null : "v1 was null";
		assert v2 != null : "v2 was null";
		drawTriangle(x0, y0, v1.getX(), v1.getY(), v2.getX(), v2.getY());
	}
	public default void drawTriangle(Vector2 v0, Vector2 v1, Vector2 v2) {
		assert v0 != null : "v0 was null";
		assert v1 != null : "v1 was null";
		assert v2 != null : "v2 was null";
		drawTriangle(v0.getX(), v0.getY(), v1.getX(), v1.getY(), v2.getX(), v2.getY());
	}

	public void fillTriangle(float x0, float y0, float x1, float y1, float x2, float y2);
	public default void fillTriangle(Vector2 v0, float x1, float y1, float x2, float y2) {
		assert v0 != null : "v0 was null";
		fillTriangle(v0.getX(), v0.getY(), x1, y1, x2, y2);
	}
	public default void fillTriangle(float x0, float y0, Vector2 v1, float x2, float y2) {
		assert v1 != null : "v1 was null";
		fillTriangle(x0, y0, v1.getX(), v1.getY(), x2, y2);
	}
	public default void fillTriangle(Vector2 v0, Vector2 v1, float x2, float y2) {
		assert v0 != null : "v0 was null";
		assert v1 != null : "v1 was null";
		fillTriangle(v0.getX(), v0.getY(), v1.getX(), v1.getY(), x2, y2);
	}
	public default void fillTriangle(float x0, float y0, float x1, float y1, Vector2 v2) {
		assert v2 != null : "v2 was null";
		fillTriangle(x0, y0, x1, y1, v2.getX(), v2.getY());
	}
	public default void fillTriangle(Vector2 v0, float x1, float y1, Vector2 v2) {
		assert v0 != null : "v0 was null";
		assert v2 != null : "v2 was null";
		fillTriangle(v0.getX(), v0.getY(), x1, y1, v2.getX(), v2.getY());
	}
	public default void fillTriangle(float x0, float y0, Vector2 v1, Vector2 v2) {
		assert v1 != null : "v1 was null";
		assert v2 != null : "v2 was null";
		fillTriangle(x0, y0, v1.getX(), v1.getY(), v2.getX(), v2.getY());
	}
	public default void fillTriangle(Vector2 v0, Vector2 v1, Vector2 v2) {
		assert v0 != null : "v0 was null";
		assert v1 != null : "v1 was null";
		assert v2 != null : "v2 was null";
		fillTriangle(v0.getX(), v0.getY(), v1.getX(), v1.getY(), v2.getX(), v2.getY());
	}


	public default void drawPixel(float x, float y){
		fillRect(x, y, 1, 1);
	}
	public default void drawPixel(Vector2 pos){
		drawPixel(pos.getX(), pos.getY());
	}
	public default void drawPixels(Vector2[] pixels){
		for(int i = 0; i<pixels.length; i++){
			if(pixels[i] != null){
				drawPixel(pixels[i].getX(), pixels[i].getY());
			}
		}
	}
}
