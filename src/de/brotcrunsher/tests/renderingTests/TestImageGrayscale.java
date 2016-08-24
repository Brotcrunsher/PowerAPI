package de.brotcrunsher.tests.renderingTests;

import de.brotcrunsher.array.ArrayUtil;
import de.brotcrunsher.array.NeighborMode;
import de.brotcrunsher.game.core.Game;
import de.brotcrunsher.game.core.GameStarter;
import de.brotcrunsher.game.core.TimeManager;
import de.brotcrunsher.gfx.basics.Image;
import de.brotcrunsher.gfx.rendering.Renderer;
import de.brotcrunsher.gfx.rendering.Window;
import de.brotcrunsher.math.random.RNG;

public class TestImageGrayscale implements Game{
	
	Window w;
	float[][] a;
	float[][] b;
	
	public static void main(String[] args) {
		new TestImageGrayscale().start();
	}
	
	@Override
	public void initialize(Window window) {
		this.w = window;
		a = new float[1024][1024];
		b = new float[a.length][a[0].length];
		for(int i = 0; i<a.length; i++){
			for(int k = 0; k<a[i].length; k++){
				a[i][k] = RNG.nextFloat() / 10 - 1000;
			}
		}
	}

	@Override
	public void update(float timeSinceLastFrame) {
		
	}

	@Override
	public void draw(Renderer r) {
		if(TimeManager.getFrameNumber() % 32 == 0){
			for(int i = 0; i<a.length; i++){
				for(int k = 0; k<a[i].length; k++){
					a[i][k] = a[i][k] > 0.5 ? 1 : 0;
				}
			}
			Image img = w.getGrayscaleImage(b);
			
			for(int i = 0; i<GameStarter.getScreenWidth(); i+= a.length){
				for(int k = 0; k<GameStarter.getScreenHeight(); k+= a[0].length){
					r.drawImage(img, i, k);
				}
			}
		}
		
//		if(TimeManager.getFrameNumber() % 3 == 0){
//			for(int i = 0; i<a.length; i++){
//				for(int k = 0; k<a[i].length; k++){
//					a[i][k] += RNG.nextGaussian() * 0.1f;
//				}
//			}
//		}
		
		ArrayUtil.standardize(a);
		
		if(TimeManager.getFrameNumber() % 4 == 0)
			ArrayUtil.smooth(b, a, true, NeighborMode.eight);
		else
			ArrayUtil.smooth(b, a, true, NeighborMode.horizontal);
		
		
		
		System.out.println(TimeManager.getFrameNumber());
		
		
		
		float[][] temp = b;
		b = a;
		a = temp;
	}

	@Override
	public void preInitialize() {
		GameStarter.setScreenHeight(1024);
		GameStarter.setScreenWidth(1024);
	}

}
