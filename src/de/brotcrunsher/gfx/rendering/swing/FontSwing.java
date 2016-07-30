package de.brotcrunsher.gfx.rendering.swing;

import de.brotcrunsher.gfx.basics.Font;

public class FontSwing extends Font{
	/*pp*/ java.awt.Font font;
	
	public FontSwing(float size){
		this(size, "Calibri");
	}
	
	public FontSwing(float size, String path){
		font = new java.awt.Font(path, java.awt.Font.PLAIN, (int)size);
	}
}
