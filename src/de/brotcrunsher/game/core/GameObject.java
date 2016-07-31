package de.brotcrunsher.game.core;

import de.brotcrunsher.gfx.rendering.Renderer;

public interface GameObject {
	public void update(float timeSinceLastFrame);
	public void draw(Renderer r);
}
