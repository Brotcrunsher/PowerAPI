package de.brotcrunsher.gfx.rendering.swing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import de.brotcrunsher.gfx.basics.Image;

public class ImageSwing extends Image{
	/*pp*/ BufferedImage img;

	public ImageSwing(String path) throws IOException{
		URL res = ImageSwing.class.getResource(path);
		img = ImageIO.read(res);
	}
	
	public ImageSwing(float[][] arr){
		img = new BufferedImage(arr.length, arr[0].length, BufferedImage.TYPE_4BYTE_ABGR);
		
		for(int i = 0; i<arr.length; i++){
			for(int k = 0; k<arr[i].length; k++){
				float val = arr[i][k];
				int colorVal = (int)(val * 255);
				Color c = new Color(colorVal, colorVal, colorVal, 255);
				img.setRGB(i, k, c.getRGB());
			}
		}
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
