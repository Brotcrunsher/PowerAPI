package de.brotcrunsher.game.core;

import de.brotcrunsher.gfx.rendering.Window;
import de.brotcrunsher.gfx.rendering.WindowSwing;

public class GameStarter {
	private static int gameScreenWidth = 1024;
	private static int gameScreenHeight = 712;
	private static Window window;
	private static String windowName = "Test";
	private static boolean running = false;
	
	public static void startGame(Game game){
		startGame(game, HostMode.swing);
	}
	
	public static void startGame(Game game, HostMode hm){
		switch(hm){
		case swing:
			startGame(game, new WindowSwing());
			break;
		default:
			throw new IllegalArgumentException("The HostMode " + hm + " is not supported!");
		}
	}
	
	public static void startGame(Game game, Window window){
		GameStarter.window = window;
		game.preInitialize();
		
		GameStarter.window.create(windowName, gameScreenWidth, gameScreenHeight);
		
		GameStarter.running = true;
		
		while(GameStarter.running){
			TimeManager.update();
			
			game.update(TimeManager.getTimeSinceLastFrame());
			window.renderScreen(game);
			
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		game.onGameEnd();
	}
	
	public static int getScreenWidth(){
		return gameScreenWidth;
	}
	public static int getScreenHeight(){
		return gameScreenHeight;
	}
}
