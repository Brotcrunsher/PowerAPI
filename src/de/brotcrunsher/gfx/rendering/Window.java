package de.brotcrunsher.gfx.rendering;

import de.brotcrunsher.input.KeyMapping;

public interface Window {
	public void create(String name, int screenWidth, int screenHeight);
	public Renderer prepareRendering();
	public KeyMapping generateKeyMapping();
	public default void postRender(){
		//do nothing on default
	}
	public default void cleanup(){
		//do nothing on default
	}
}
