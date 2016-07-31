package de.brotcrunsher.game.core;

import de.brotcrunsher.gfx.rendering.Window;

public interface GameState extends GameObject{

	public void initialize(Window window);
	public default void onGameStateLeave(){
		//Do nothing on default
	}
}
