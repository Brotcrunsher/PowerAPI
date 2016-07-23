package de.brotcrunsher.gfx.rendering;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;

public class RendererSwing implements Renderer{
	private Graphics2D g;
	private float addX = 0;
	private float addY = 0;
	
	public RendererSwing(Graphics2D g, float addX, float addY){
		this.g = g;
		this.addX = addX;
		this.addY = addY;
	}
	
	
	@Override
	public void setColor(float r, float g, float b, float a) {
		this.g.setColor(new Color((int)(r * 255), (int)(g * 255), (int)(b * 255), (int)(a * 255)));
	}

	@Override
	public void setLineWidth(float width) {
		g.setStroke(new BasicStroke(width));
	}

	@Override
	public void drawLine(float startX, float startY, float stopX, float stopY) {
		startX += addX;
		stopX += addX;
		startY += addY;
		stopY += addY;
		g.drawLine((int)startX, (int)startY, (int)stopX, (int)stopY);
	}

	@Override
	public void drawRect(float x, float y, float width, float height) {
		x += addX;
		y += addY;
		g.drawRect((int)x, (int)y, (int)width, (int)height);
	}

	@Override
	public void fillRect(float x, float y, float width, float height) {
		x += addX;
		y += addY;
		g.fillRect((int)x, (int)y, (int)width, (int)height);
	}

	@Override
	public void drawOval(float x, float y, float width, float height) {
		x += addX;
		y += addY;
		g.drawOval((int)x, (int)y, (int)width, (int)height);
	}

	@Override
	public void fillOval(float x, float y, float width, float height) {
		x += addX;
		y += addY;
		g.fillOval((int)x, (int)y, (int)width, (int)height);
	}

	@Override
	public void drawTriangle(float x0, float y0, float x1, float y1, float x2, float y2) {
		drawLine(x0, y0, x1, y1);
		drawLine(x1, y1, x2, y2);
		drawLine(x2, y2, x0, y0);
	}

	@Override
	public void fillTriangle(float x0, float y0, float x1, float y1, float x2, float y2) {
		x0 += addX;
		x1 += addX;
		x2 += addX;
		y0 += addY;
		y1 += addY;
		y2 += addY;
		int xpoints[] = {(int)x0, (int)x1, (int)x2};
		int ypoints[] = {(int)y0, (int)y1, (int)y2};
		Polygon p = new Polygon(xpoints, ypoints, 3);
		g.fillPolygon(p);
	}


	@Override
	public void clearScreen() {
		fillRect(0,  0, 8000, 8000);
	}

}
