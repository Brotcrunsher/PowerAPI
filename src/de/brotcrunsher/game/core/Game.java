package de.brotcrunsher.game.core;

import de.brotcrunsher.gfx.rendering.Renderer;
import de.brotcrunsher.gfx.rendering.Window;

public interface Game {
	public void preInitialize();
	public void initialize(Window window);
	public void update(float timeSinceLastFrame);
	public void draw(Renderer r);

	public default void onGameEnd(){
		//Do nothing on default
	}
	public default void start(){
		GameStarter.startGame(this);
	}
	public default int getScreenWidth(){
		return GameStarter.getScreenWidth();
	}
	public default int getScreenHeight(){
		return GameStarter.getScreenHeight();
	}

}
