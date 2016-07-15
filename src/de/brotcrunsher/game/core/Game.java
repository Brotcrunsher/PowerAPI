package de.brotcrunsher.game.core;

import de.brotcrunsher.gfx.rendering.Renderer;

public interface Game {
	public void preInitialize();
	public void initialize();
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
