package de.brotcrunsher.gfx.rendering.openGL;

import de.brotcrunsher.gfx.basics.Color;
import de.brotcrunsher.gfx.rendering.Image;
import de.brotcrunsher.gfx.rendering.Renderer;
import de.brotcrunsher.math.linear.FMath;

import static org.lwjgl.opengl.GL11.*;

public class RendererOpenGL extends Renderer{
	private Color color = Color.AWT_BLACK;
	
	public RendererOpenGL() {
		setLineWidth(1);
	}
	
	@Override
	public void setColor(float r, float g, float b, float a) {
		color = new Color(r, g, b, a);
		glColor4f(r, g, b, a);
	}

	@Override
	public void setLineWidth(float width) {
		glLineWidth(width);
	}

	@Override
	public void clearScreen() {
		glClearColor(color.getR(), color.getG(), color.getB(), color.getA());
	}

	@Override
	public void drawLineScreenSpace(float startX, float startY, float stopX, float stopY) {
		glBegin(GL_LINE_STRIP);
			glVertex2f(startX, startY);
			glVertex2f(stopX, stopY);
		glEnd();
	}

	@Override
	public void drawRectScreenSpace(float x, float y, float width, float height) {
		x += 0.5f;
		glBegin(GL_LINE_LOOP);
			glVertex2f(x, y + 0.5f);
			glVertex2f(x, y + height + 0.5f);
			glVertex2f(x + width, y + height + 0.5f);
			glVertex2f(x + width, y + 0.5f);
		glEnd();
	}

	@Override
	public void fillRectScreenSpace(float x, float y, float width, float height) {
		glBegin(GL_QUADS);
			glVertex2f(x, y);
			glVertex2f(x, y + height);
			glVertex2f(x + width, y + height);
			glVertex2f(x + width, y);
		glEnd();
	}

	@Override
	public void drawOvalScreenSpace(float x, float y, float width, float height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fillOvalScreenSpace(float x, float y, float width, float height) {
		float firstX = 0, firstY = 0;//to fix missing pixel line
		float radiusX = width / 2;
		float radiusY = height / 2;
		
		glBegin(GL_TRIANGLE_FAN);
		glVertex2f(x, y);//center
		for (int i = 0; i <= 360; i++) {//TODO: use less vertexpoints
			float alpha = i * FMath.PI / 180;
			
			float cos = (float) Math.cos(alpha);
			float sin = (float) Math.sin(alpha);
			
			float posX = cos * radiusX + x;
			float posY = sin * radiusY + y;
			
			//The following lets the oval behave more like the java version
			if(FMath.isInRange(i, 0, 90) || FMath.isInRange(i, 270, 360)){
				posX++;
			}
			
			if(FMath.isInRange(i, 0, 180)){
				posY++;
			}
			
			if(i == 0){
				firstX = posX;
				firstY = posY;
			}
			
			glVertex2f(posX, posY);
		}
		glVertex2f(firstX, firstY);
		glEnd();
	}

	@Override
	public void drawTriangleScreenSpace(float x0, float y0, float x1, float y1, float x2, float y2) {
		x0 += 0.5f;
		x1 += 0.5f;
		x2 += 0.5f;
		glBegin(GL_LINE_LOOP);
			glVertex2f(x0, y0);
			glVertex2f(x1, y1);
			glVertex2f(x2, y2);
		glEnd();
	}

	@Override
	public void fillTriangleScreenSpace(float x0, float y0, float x1, float y1, float x2, float y2) {
		x0 += 0.5f;
		x1 += 0.5f;
		x2 += 0.5f;
		glBegin(GL_TRIANGLES);
			glVertex2f(x0, y0);
			glVertex2f(x1, y1);
			glVertex2f(x2, y2);
		glEnd();
	}

	@Override
	public void drawImageScreenSpace(Image img, float x, float y, float pivotX, float pivotY) {
		// TODO Auto-generated method stub
		
	}

}
