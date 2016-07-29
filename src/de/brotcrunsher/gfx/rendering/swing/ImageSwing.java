package de.brotcrunsher.gfx.rendering.swing;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import de.brotcrunsher.gfx.rendering.Image;

public class ImageSwing extends Image{
	/*pp*/ BufferedImage img;

	public ImageSwing(String path) throws IOException{
		URL res = ImageSwing.class.getResource(path);
		img = ImageIO.read(res);
	}

	@Override
	public float getWidth() {
		return img.getWidth();
	}

	@Override
	public float getHeight() {
		return img.getHeight();
	}
}
