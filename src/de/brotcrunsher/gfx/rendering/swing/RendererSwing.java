package de.brotcrunsher.gfx.rendering.swing;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;

import de.brotcrunsher.game.core.GameStarter;
import de.brotcrunsher.gfx.basics.Font;
import de.brotcrunsher.gfx.basics.Image;
import de.brotcrunsher.gfx.rendering.Renderer;

public class RendererSwing extends Renderer{
	private Graphics2D g;
	private float addX = 0;
	private float addY = 0;

	public RendererSwing(Graphics2D g, float addX, float addY){
		initialize(g, addX, addY);
	}
	
	public RendererSwing(){};
	
	public void initialize(Graphics2D g, float addX, float addY){
		this.g = g;
		this.addX = addX;
		this.addY = addY;
	}


	@Override
	public void setColor(float r, float g, float b, float a) {
		this.g.setColor(new Color((int)(r * 255), (int)(g * 255), (int)(b * 255), (int)(a * 255)));
	}
	
	@Override
	public void setColor(de.brotcrunsher.gfx.basics.Color color) {
		this.g.setColor(color.awtColor());
	}

	@Override
	public void setLineWidth(float width) {
		g.setStroke(new BasicStroke(width));
	}

	@Override
	public void drawLineScreenSpace(float startX, float startY, float stopX, float stopY) {
		startX += addX;
		stopX += addX;
		startY += addY;
		stopY += addY;
		g.drawLine((int)startX, (int)startY, (int)stopX, (int)stopY);
	}

	@Override
	public void drawRectScreenSpace(float x, float y, float width, float height) {
		x += addX;
		y += addY;
		g.drawRect((int)x, (int)y, (int)width, (int)height);
	}

	@Override
	public void fillRectScreenSpace(float x, float y, float width, float height) {
		x += addX;
		y += addY;
		g.fillRect((int)x, (int)y, (int)width, (int)height);
	}

	@Override
	public void drawOvalScreenSpace(float x, float y, float width, float height) {
		x += addX;
		y += addY;
		g.drawOval((int)(x - width/2), (int)(y - height/2), (int)width, (int)height);
	}

	@Override
	public void fillOvalScreenSpace(float x, float y, float width, float height) {
		x += addX;
		y += addY;
		g.fillOval((int)(x - width/2), (int)(y - height/2), (int)width, (int)height);
	}

	@Override
	public void drawTriangleScreenSpace(float x0, float y0, float x1, float y1, float x2, float y2) {
		drawLineScreenSpace(x0, y0, x1, y1);
		drawLineScreenSpace(x1, y1, x2, y2);
		drawLineScreenSpace(x2, y2, x0, y0);
	}

	@Override
	public void fillTriangleScreenSpace(float x0, float y0, float x1, float y1, float x2, float y2) {
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
		fillRectScreenSpace(0,  0, GameStarter.getScreenWidth(), GameStarter.getScreenHeight());
	}


	@Override
	public void drawImageScreenSpace(Image img, float x, float y, float pivotX, float pivotY) {
		x += addX;
		y += addY;
		g.drawImage(((ImageSwing)img).img, (int)(x - pivotX), (int)(y - pivotY), null);
	}


	@Override
	public void fillTextScreenSpace(String txt, float x, float y) {
		x += addX;
		y += addY;
		g.drawString(txt, (int)x, (int)y);
	}


	@Override
	public void setFont(Font font) {
		g.setFont(((FontSwing)font).font);
	}

}
