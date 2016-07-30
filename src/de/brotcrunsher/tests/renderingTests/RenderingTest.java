package de.brotcrunsher.tests.renderingTests;

import java.io.IOException;

import de.brotcrunsher.game.core.Game;
import de.brotcrunsher.gfx.basics.Color;
import de.brotcrunsher.gfx.rendering.Image;
import de.brotcrunsher.gfx.rendering.Renderer;
import de.brotcrunsher.gfx.rendering.Window;
import de.brotcrunsher.input.Key;
import de.brotcrunsher.input.Keyboard;
import de.brotcrunsher.input.Mouse;
import de.brotcrunsher.math.linear.Vector2;

public class RenderingTest implements Game{
	
	public Vector2 camera = new Vector2();
	
	public Vector2 mousePos = new Vector2();

	Image img = null;
	
	@Override
	public void preInitialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initialize(Window w) {
		try {
			img = w.getImage("/gfx/TestImage.png");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void update(float timeSinceLastFrame) {
		if(Keyboard.isKeyDown(Key.w)){
			camera.addToThisY(-timeSinceLastFrame * 100);
		}
		if(Keyboard.isKeyDown(Key.s)){
			camera.addToThisY(timeSinceLastFrame * 100);
		}
		if(Keyboard.isKeyDown(Key.a)){
			camera.addToThisX(-timeSinceLastFrame * 100);
		}
		if(Keyboard.isKeyDown(Key.d)){
			camera.addToThisX(timeSinceLastFrame * 100);
		}
		
		Mouse.getPos(mousePos);
	}

	@Override
	public void draw(Renderer r) {
		r.setCamera(camera);
		r.setColor(Color.AWT_GREEN);
		r.clearScreen();
		//r.setColor(Color.AWT_BLUE);
		//r.fillRect(0.1f, 0.1f, 0.1f, 0.1f);
		r.setColor(Color.AWT_BLACK);
		r.fillRect(1, 1, getScreenWidth()-2, getScreenHeight()-2);
		r.setColor(new Color(1, 0, 0, 1));
		r.fillOval(50, 50, 100, 100);
		r.setColor(new Color(0, 1, 0, 1));
		r.fillOval(new Vector2(getScreenWidth() - 50, 50), 100, 100);
		r.setColor(new Color(0, 0, 1, 1));
		r.fillOval(50, getScreenHeight() - 50, new Vector2(100, 100));
		r.setColor(new Color(1, 1, 0, 1));
		r.fillOval(new Vector2(getScreenWidth() - 50, getScreenHeight() - 50), new Vector2(100, 100));
		r.setColor(Color.AWT_MAGENTA);
		r.fillOval(300,  300, 200, 100);
		r.setColor(Color.AWT_DARK_GRAY);
		r.fillTriangle(100, 100, 300, 50, 200, 200);
		r.drawTriangle(500, 20, 550, 50, 170, 10);
		r.setColor(Color.AWT_WHITE);
		r.drawRect(800, 20, 100, 200);
		r.setColor(Color.AWT_CYAN);
		r.drawLine(400, 500, 300, 200);
		r.setLineWidth(10);
		r.drawLine(450, 550, 350, 250);
		//System.out.println(TimeManager.getFrameNumber() + " : " +  TimeManager.getAverageFrameTime());
		r.drawImage(img, 700, 300);
		
		r.setColor(Color.AWT_RED);
		r.setLineWidth(1);
		r.drawGridScreenSpace(mousePos, 64, 64);
		
		r.setColor(Color.AWT_BLUE);
		r.drawGrid(0, 0, 64, 64);
	}
	
	
	public static void main(String[] args) {
		new RenderingTest().start();
	}
}
