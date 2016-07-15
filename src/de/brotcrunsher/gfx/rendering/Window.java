package de.brotcrunsher.gfx.rendering;

import de.brotcrunsher.game.core.Game;

public interface Window {
	public void create(String name, int screenWidth, int screenHeight);
	public void renderScreen(Game game);
}
