package de.brotcrunsher.game.core;

import de.brotcrunsher.gfx.rendering.Renderer;
import de.brotcrunsher.gfx.rendering.Window;

public interface Game extends GameState{
	public void preInitialize();

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
