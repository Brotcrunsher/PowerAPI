package de.brotcrunsher.gfx.rendering;

import de.brotcrunsher.game.core.GameStarter;
import de.brotcrunsher.gfx.basics.Color;
import de.brotcrunsher.gfx.basics.Font;
import de.brotcrunsher.gfx.basics.Image;
import de.brotcrunsher.math.linear.Vector2;

public abstract class Renderer {
	protected float cameraX = 0;
	protected float cameraY = 0;
	
	
	public abstract void setColor(float r, float g, float b, float a);
	public void setColor(float r, float g, float b){
		setColor(r, g, b, 1);
	}
	public void setColor(Color color){
		setColor(color.getR(), color.getG(), color.getB(), color.getA());
	}
	
	public abstract void setFont(Font font);
	
	public void setCamera(float cameraX, float cameraY){
		this.cameraX = cameraX;
		this.cameraY = cameraY;
	}
	
	public void setCameraCenter(float cameraX, float cameraY){
		this.cameraX = cameraX - GameStarter.getScreenWidth() / 2;
		this.cameraY = cameraY - GameStarter.getScreenHeight() / 2;
	}
	
	public void setCameraCenter(Vector2 camera){
		setCameraCenter(camera.getX(), camera.getY());
	}
	
	public abstract void drawImageScreenSpace(Image img, float x, float y, float pivotX, float pivotY);
	
	public void drawImage(Image img, float x, float y, float pivotX, float pivotY){
		drawImageScreenSpace(img, x - cameraX, y - cameraY, pivotX, pivotY);
	}
	public void drawImage(Image img, Vector2 pos, Vector2 pivot){
		drawImage(img, pos.getX(), pos.getY(), pivot.getX(), pivot.getY());
	}
	public void drawImage(Image img, Vector2 pos, float pivotX, float pivotY){
		drawImage(img, pos.getX(), pos.getY(), pivotX, pivotY);
	}
	public void drawImage(Image img, float x, float y, Vector2 pivot){
		drawImage(img, x, y, pivot.getX(), pivot.getY());
	}
	public void drawImage(Image img, float x, float y){
		drawImage(img, x, y, img.getPivot().getX(), img.getPivot().getY());
	}
	public void drawImage(Image img, Vector2 pos){
		drawImage(img, pos.getX(), pos.getY());
	}

	public void setCamera(Vector2 camera){
		setCamera(camera.getX(), camera.getY());
	}

	public float getCameraX(){
		return cameraX;
	}
	
	public float getCameraY(){
		return cameraY;
	}
	
	public Vector2 getCamera(Vector2 result){
		if(result == null){
			return new Vector2(cameraX, cameraY);
		}
		result.setX(cameraX);
		result.setY(cameraY);
		return result;
	}
	
	public abstract void setLineWidth(float width);
	
	public abstract void clearScreen();
	
	public abstract void drawLineScreenSpace(float startX, float startY, float stopX, float stopY);
	
	public void drawLine(float startX, float startY, float stopX, float stopY){
		drawLineScreenSpace(startX - cameraX, startY - cameraY, stopX - cameraX, stopY - cameraY);
	}
	public void drawLine(Vector2 start, float stopX, float stopY) {
		assert start != null : "start was null!";
		drawLine(start.getX(), start.getY(), stopX, stopY);
	}
	public void drawLine(float startX, float startY, Vector2 stop) {
		assert stop != null : "stop was null!";
		drawLine(startX, startY, stop.getX(), stop.getY());
	}
	public void drawLine(Vector2 start, Vector2 stop) {
		assert start != null : "start was null!";
		assert stop != null : "stop was null!";
		drawLine(start.getX(), start.getY(), stop.getX(), stop.getY());
	}
	
	public abstract void fillTextScreenSpace(String txt, float x, float y);
	public void fillTextScreenSpace(String txt, Vector2 pos){
		fillTextScreenSpace(txt, pos.getX(), pos.getY());
	}
	
	public void fillText(String txt, float x, float y){
		fillTextScreenSpace(txt, x - cameraX, y - cameraY);
	}
	public void fillText(String txt, Vector2 pos){
		fillTextScreenSpace(txt, pos.getX() - cameraX, pos.getY() - cameraY);
	}
	
	
	public abstract void drawRectScreenSpace(float x, float y, float width, float height);

	public void drawRect(float x, float y, float width, float height){
		drawRectScreenSpace(x - cameraX, y - cameraY, width, height);
	}
	public void drawRect(Vector2 pos, float width, float height) {
		assert pos != null : "pos was null!";
		drawRect(pos.getX(), pos.getY(), width, height);
	}
	public void drawRect(float x, float y, Vector2 dimensions) {
		assert dimensions != null : "dimensions was null!";
		drawRect(x, y, dimensions.getX(), dimensions.getY());
	}
	public void drawRect(Vector2 pos, Vector2 dimensions) {
		assert pos != null : "pos was null!";
		assert dimensions != null : "dimensions was null!";
		drawRect(pos.getX(), pos.getY(), dimensions.getX(), dimensions.getY());
	}
	
	public abstract void fillRectScreenSpace(float x, float y, float width, float height);
	
	public void fillRect(float x, float y, float width, float height){
		fillRectScreenSpace(x - cameraX, y - cameraY, width, height);
	}
	public void fillRect(Vector2 pos, float width, float height) {
		assert pos != null : "pos was null!";
		fillRect(pos.getX(), pos.getY(), width, height);
	}
	public void fillRect(float x, float y, Vector2 dimensions) {
		assert dimensions != null : "dimensions was null!";
		fillRect(x, y, dimensions.getX(), dimensions.getY());
	}
	public void fillRect(Vector2 pos, Vector2 dimensions) {
		assert pos != null : "pos was null!";
		assert dimensions != null : "dimensions was null!";
		fillRect(pos.getX(), pos.getY(), dimensions.getX(), dimensions.getY());
	}
	
	public abstract void drawOvalScreenSpace(float x, float y, float width, float height);
	
	public void drawOval(float x, float y, float width, float height){
		drawOvalScreenSpace(x - cameraX, y - cameraY, width, height);
	}
	public void drawOval(Vector2 pos, float width, float height) {
		assert pos != null : "pos was null!";
		drawOval(pos.getX(), pos.getY(), width, height);
	}
	public void drawOval(float x, float y, Vector2 dimensions) {
		assert dimensions != null : "dimensions was null!";
		drawOval(x, y, dimensions.getX(), dimensions.getY());
	}
	public void drawOval(Vector2 pos, Vector2 dimensions) {
		assert pos != null : "pos was null!";
		assert dimensions != null : "dimensions was null!";
		drawOval(pos.getX(), pos.getY(), dimensions.getX(), dimensions.getY());
	}
	
	public abstract void fillOvalScreenSpace(float x, float y, float width, float height);

	public void fillOval(float x, float y, float width, float height){
		fillOvalScreenSpace(x - cameraX, y - cameraY, width, height);
	}
	public void fillOval(Vector2 pos, float width, float height) {
		assert pos != null : "pos was null!";
		fillOval(pos.getX(), pos.getY(), width, height);
	}
	public void fillOval(float x, float y, Vector2 dimensions) {
		assert dimensions != null : "dimensions was null!";
		fillOval(x, y, dimensions.getX(), dimensions.getY());
	}
	public void fillOval(Vector2 pos, Vector2 dimensions) {
		assert pos != null : "pos was null!";
		assert dimensions != null : "dimensions was null!";
		fillOval(pos.getX(), pos.getY(), dimensions.getX(), dimensions.getY());
	}
	
	public abstract void drawTriangleScreenSpace(float x0, float y0, float x1, float y1, float x2, float y2);
	
	public void drawTriangle(float x0, float y0, float x1, float y1, float x2, float y2){
		drawTriangleScreenSpace(x0 - cameraX, y0 - cameraY, x1 - cameraX, y1 - cameraY, x2 - cameraX, y2 - cameraY);
	}
	public void drawTriangle(Vector2 v0, float x1, float y1, float x2, float y2) {
		assert v0 != null : "v0 was null";
		drawTriangle(v0.getX(), v0.getY(), x1, y1, x2, y2);
	}
	public void drawTriangle(float x0, float y0, Vector2 v1, float x2, float y2) {
		assert v1 != null : "v1 was null";
		drawTriangle(x0, y0, v1.getX(), v1.getY(), x2, y2);
	}
	public void drawTriangle(Vector2 v0, Vector2 v1, float x2, float y2) {
		assert v0 != null : "v0 was null";
		assert v1 != null : "v1 was null";
		drawTriangle(v0.getX(), v0.getY(), v1.getX(), v1.getY(), x2, y2);
	}
	public void drawTriangle(float x0, float y0, float x1, float y1, Vector2 v2) {
		assert v2 != null : "v2 was null";
		drawTriangle(x0, y0, x1, y1, v2.getX(), v2.getY());
	}
	public void drawTriangle(Vector2 v0, float x1, float y1, Vector2 v2) {
		assert v0 != null : "v0 was null";
		assert v2 != null : "v2 was null";
		drawTriangle(v0.getX(), v0.getY(), x1, y1, v2.getX(), v2.getY());
	}
	public void drawTriangle(float x0, float y0, Vector2 v1, Vector2 v2) {
		assert v1 != null : "v1 was null";
		assert v2 != null : "v2 was null";
		drawTriangle(x0, y0, v1.getX(), v1.getY(), v2.getX(), v2.getY());
	}
	public void drawTriangle(Vector2 v0, Vector2 v1, Vector2 v2) {
		assert v0 != null : "v0 was null";
		assert v1 != null : "v1 was null";
		assert v2 != null : "v2 was null";
		drawTriangle(v0.getX(), v0.getY(), v1.getX(), v1.getY(), v2.getX(), v2.getY());
	}
	
	public abstract void fillTriangleScreenSpace(float x0, float y0, float x1, float y1, float x2, float y2);
	
	public void fillTriangle(float x0, float y0, float x1, float y1, float x2, float y2){
		fillTriangleScreenSpace(x0 - cameraX, y0 - cameraY, x1 - cameraX, y1 - cameraY, x2 - cameraX, y2 - cameraY);
	}
	public void fillTriangle(Vector2 v0, float x1, float y1, float x2, float y2) {
		assert v0 != null : "v0 was null";
		fillTriangle(v0.getX(), v0.getY(), x1, y1, x2, y2);
	}
	public void fillTriangle(float x0, float y0, Vector2 v1, float x2, float y2) {
		assert v1 != null : "v1 was null";
		fillTriangle(x0, y0, v1.getX(), v1.getY(), x2, y2);
	}
	public void fillTriangle(Vector2 v0, Vector2 v1, float x2, float y2) {
		assert v0 != null : "v0 was null";
		assert v1 != null : "v1 was null";
		fillTriangle(v0.getX(), v0.getY(), v1.getX(), v1.getY(), x2, y2);
	}
	public void fillTriangle(float x0, float y0, float x1, float y1, Vector2 v2) {
		assert v2 != null : "v2 was null";
		fillTriangle(x0, y0, x1, y1, v2.getX(), v2.getY());
	}
	public void fillTriangle(Vector2 v0, float x1, float y1, Vector2 v2) {
		assert v0 != null : "v0 was null";
		assert v2 != null : "v2 was null";
		fillTriangle(v0.getX(), v0.getY(), x1, y1, v2.getX(), v2.getY());
	}
	public void fillTriangle(float x0, float y0, Vector2 v1, Vector2 v2) {
		assert v1 != null : "v1 was null";
		assert v2 != null : "v2 was null";
		fillTriangle(x0, y0, v1.getX(), v1.getY(), v2.getX(), v2.getY());
	}
	public void fillTriangle(Vector2 v0, Vector2 v1, Vector2 v2) {
		assert v0 != null : "v0 was null";
		assert v1 != null : "v1 was null";
		assert v2 != null : "v2 was null";
		fillTriangle(v0.getX(), v0.getY(), v1.getX(), v1.getY(), v2.getX(), v2.getY());
	}

	public void drawPixelScreenSpace(float x, float y){
		fillRect(x, y, 1, 1);
	}
	public void drawPixel(float x, float y){
		drawPixelScreenSpace(x - cameraX, y - cameraY);
	}
	public void drawPixel(Vector2 pos){
		drawPixel(pos.getX(), pos.getY());
	}
	public void drawPixels(Vector2[] pixels){
		for(int i = 0; i<pixels.length; i++){
			if(pixels[i] != null){
				drawPixel(pixels[i].getX(), pixels[i].getY());
			}
		}
	}
	
	public void drawGridScreenSpace(float x, float y, float cellwidth, float cellheight){
		float screenWidth = GameStarter.getScreenWidth();
		float screenHeight = GameStarter.getScreenHeight();
		
		if(cellwidth < 1){
			cellwidth = 1;
		}
		if(cellheight < 1){
			cellheight = 1;
		}
		float posX = x;
		while(posX < screenWidth){
			drawLineScreenSpace(posX, 0, posX, screenHeight);
			posX += cellwidth;
		}
		posX = x - cellwidth;
		while(posX >= 0){
			drawLineScreenSpace(posX, 0, posX, screenHeight);
			posX -= cellwidth;
		}
		
		float posY = y;
		while(posY < screenHeight){
			drawLineScreenSpace(0, posY, screenWidth, posY);
			posY += cellheight;
		}
		posY = y - cellheight;
		while(posY >= 0){
			drawLineScreenSpace(0, posY, screenWidth, posY);
			posY -= cellheight;
		}
	}
	
	public void drawGridScreenSpace(Vector2 pos, float cellwidth, float cellheight){
		drawGridScreenSpace(pos.getX(), pos.getY(), cellwidth, cellheight);
	}
	
	public void drawGridScreenSpace(float x, float y, Vector2 cellDimensions){
		drawGridScreenSpace(x, y, cellDimensions.getX(), cellDimensions.getY());
	}
	
	public void drawGridScreenSpace(Vector2 pos, Vector2 cellDimensions){
		drawGridScreenSpace(pos.getX(), pos.getY(), cellDimensions.getX(), cellDimensions.getY());
	}
	
	public void drawGrid(float x, float y, float cellwidth, float cellheight){
		drawGridScreenSpace(x - cameraX, y - cameraY, cellwidth, cellheight);
	}
	
	public void drawGrid(Vector2 pos, float cellwidth, float cellheight){
		drawGrid(pos.getX(), pos.getY(), cellwidth, cellheight);
	}
	
	public void drawGrid(float x, float y, Vector2 cellDimensions){
		drawGrid(x, y, cellDimensions.getX(), cellDimensions.getY());
	}
	
	public void drawGrid(Vector2 pos, Vector2 cellDimensions){
		drawGrid(pos.getX(), pos.getY(), cellDimensions.getX(), cellDimensions.getY());
	}
}
