package de.brotcrunsher.gfx.rendering;

import de.brotcrunsher.gfx.basics.Color;

import static org.lwjgl.opengl.GL11.*;

public class RendererOpenGL implements Renderer{
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
	public void drawLine(float startX, float startY, float stopX, float stopY) {
		glBegin(GL_LINE_STRIP);
			glVertex2f(startX, startY);
			glVertex2f(stopX, stopY);
		glEnd();
	}

	@Override
	public void drawRect(float x, float y, float width, float height) {
		x += 0.5f;
		glBegin(GL_LINE_LOOP);
			glVertex2f(x, y + 0.5f);
			glVertex2f(x, y + height + 0.5f);
			glVertex2f(x + width, y + height + 0.5f);
			glVertex2f(x + width, y + 0.5f);
		glEnd();
	}

	@Override
	public void fillRect(float x, float y, float width, float height) {
		glBegin(GL_QUADS);
			glVertex2f(x, y);
			glVertex2f(x, y + height);
			glVertex2f(x + width, y + height);
			glVertex2f(x + width, y);
		glEnd();
	}

	@Override
	public void drawOval(float x, float y, float width, float height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fillOval(float x, float y, float width, float height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drawTriangle(float x0, float y0, float x1, float y1, float x2, float y2) {
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
	public void fillTriangle(float x0, float y0, float x1, float y1, float x2, float y2) {
		x0 += 0.5f;
		x1 += 0.5f;
		x2 += 0.5f;
		glBegin(GL_TRIANGLES);
			glVertex2f(x0, y0);
			glVertex2f(x1, y1);
			glVertex2f(x2, y2);
		glEnd();
	}

}
