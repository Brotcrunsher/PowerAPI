package de.brotcrunsher.game.core;

import de.brotcrunsher.gfx.rendering.Renderer;
import de.brotcrunsher.gfx.rendering.Window;
import de.brotcrunsher.gfx.rendering.WindowOpenGL;
import de.brotcrunsher.gfx.rendering.WindowSwing;

public class GameStarter {
	private static int gameScreenWidth = 1024;
	private static int gameScreenHeight = 712;
	private static Window window;
	private static String windowName = "Test";
	private static boolean running = false;
	
	public static void startGame(Game game){
		startGame(game, HostMode.openGL);
	}
	
	public static void startGame(Game game, HostMode hm){
		switch(hm){
		case swing:
			startGame(game, new WindowSwing());
			break;
		case openGL:
			startGame(game, new WindowOpenGL());
			break;
		default:
			throw new IllegalArgumentException("The HostMode " + hm + " is not supported!");
		}
	}
	
	private static void startGame(Game game, Window window){
		GameStarter.running = true;
		GameStarter.window = window;
		game.preInitialize();
		
		GameStarter.window.create(windowName, gameScreenWidth, gameScreenHeight);
		game.initialize();
		
		
		while(GameStarter.running){
			TimeManager.update();
			
			game.update(TimeManager.getTimeSinceLastFrame());
			Renderer renderer = window.prepareRendering();
			game.draw(renderer);
			window.postRender();
			
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		window.cleanup();
		game.onGameEnd();
	}
	
	public static int getScreenWidth(){
		return gameScreenWidth;
	}
	public static int getScreenHeight(){
		return gameScreenHeight;
	}
	
	public static String getWindowName(){
		return windowName;
	}
	
	public static void setWindowName(String name){
		windowName = name;
	}
	
	public static void stopGame(){
		if(!GameStarter.running){
			throw new IllegalStateException();
		}
		GameStarter.running = false;
	}
}
