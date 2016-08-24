package de.brotcrunsher.gfx.rendering;

import java.io.IOException;

import de.brotcrunsher.gfx.basics.Font;
import de.brotcrunsher.gfx.basics.Image;
import de.brotcrunsher.input.KeyMapping;
import de.brotcrunsher.input.MouseMapping;

public interface Window {
	public void create(String name, int screenWidth, int screenHeight);
	public Renderer prepareRendering();
	public KeyMapping generateKeyMapping();
	public MouseMapping generateMouseMapping();
	public Image getImage(String path) throws IOException;
	public Image getGrayscaleImage(float[][] arr);
	public Font getFont(float size);
	public Font getFont(float size, String path);
	public default void postRender(){
		//do nothing on default
	}
	public default void cleanup(){
		//do nothing on default
	}
}
