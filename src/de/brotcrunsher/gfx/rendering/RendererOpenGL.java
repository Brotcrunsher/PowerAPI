package de.brotcrunsher.gfx.rendering;

import de.brotcrunsher.gfx.basics.Color;

import org.lwjgl.*;
import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;

import static org.lwjgl.glfw.Callbacks.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.*;

public class RendererOpenGL implements Renderer{
	private Color color = Color.AWT_BLACK;
	
	@Override
	public void setColor(float r, float g, float b, float a) {
		color = new Color(r, g, b, a);
		glColor4f(r, g, b, a);
	}

	@Override
	public void setLineWidth(float width) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clearScreen() {
		glClearColor(color.getR(), color.getG(), color.getB(), color.getA());
	}

	@Override
	public void drawLine(float startX, float startY, float stopX, float stopY) {
		// TODO Auto-generated method stub
		
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
		glBegin(GL_TRIANGLE_STRIP);
			glVertex2f(x, y);
			glVertex2f(x, y + height);
			glVertex2f(x + width, y);
			glVertex2f(x + width, y + height);
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fillTriangle(float x0, float y0, float x1, float y1, float x2, float y2) {
		// TODO Auto-generated method stub
		
	}

}
