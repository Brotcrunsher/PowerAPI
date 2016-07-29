package de.brotcrunsher.tests.renderingTests;

import java.io.IOException;

import de.brotcrunsher.game.core.Game;
import de.brotcrunsher.gfx.basics.Color;
import de.brotcrunsher.gfx.rendering.Image;
import de.brotcrunsher.gfx.rendering.Renderer;
import de.brotcrunsher.gfx.rendering.Window;

public class RenderingImage implements Game{
	
	public static void main(String[] args) {
		new RenderingImage().start();
	}
	
	Image img = null;
	
	@Override
	public void preInitialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initialize(Window window) {
		try {
			img = window.getImage("/gfx/TestImage.png");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void update(float timeSinceLastFrame) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(Renderer r) {
		r.setColor(Color.RED);
		r.fillRect(0,  0, getScreenWidth() / 2, getScreenHeight() / 2);
		r.setColor(Color.GREEN);
		r.fillRect(getScreenWidth() / 2,  0, getScreenWidth() / 2, getScreenHeight() / 2);
		r.setColor(Color.BLUE);
		r.fillRect(0,  getScreenHeight() / 2, getScreenWidth() / 2, getScreenHeight() / 2);
		r.setColor(Color.PINK);
		r.fillRect(getScreenWidth() / 2,  getScreenHeight() / 2, getScreenWidth() / 2, getScreenHeight() / 2);
		r.drawImage(img, getScreenWidth() / 2 - img.getWidth() / 2, getScreenHeight() / 2 - img.getHeight() / 2);
		r.drawImage(img, 0, 0);
	}

}
