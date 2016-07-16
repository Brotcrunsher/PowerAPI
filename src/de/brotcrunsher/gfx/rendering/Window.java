package de.brotcrunsher.gfx.rendering;

import de.brotcrunsher.game.core.Game;

public interface Window {
	public void create(String name, int screenWidth, int screenHeight);
	public Renderer prepareRendering();
	public default void postRender(){
		//do nothing on default
	}
	public default void cleanup(){
		//do nothing on default
	}
}
