package de.brotcrunsher.game.core;

import de.brotcrunsher.gfx.rendering.Renderer;
import de.brotcrunsher.gfx.rendering.Window;
import de.brotcrunsher.gfx.rendering.openGL.WindowOpenGL;
import de.brotcrunsher.gfx.rendering.swing.WindowSwing;
import de.brotcrunsher.input.Keyboard;
import de.brotcrunsher.input.Mouse;
import de.brotcrunsher.snd.SoundSystem;

public class GameStarter {
	private static int gameScreenWidth = 1024;
	private static int gameScreenHeight = 712;
	private static Window window;
	private static String windowName = "Test";
	private static boolean running = false;
	private static boolean changeGameStateRequested = false;
	private static GameState gameStateToChangeTo = null;

	public static void startGame(Game game){
		startGame(game, HostMode.swing);
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

	public static void changeGameState(GameState state){
		if(state == null) throw new NullPointerException();

		changeGameStateRequested = true;
		gameStateToChangeTo = state;
	}

	private static void startGame(Game game, Window window){
		GameStarter.running = true;
		GameStarter.window = window;
		game.preInitialize();
		GameState state = (GameState)game;

		GameStarter.window.create(windowName, gameScreenWidth, gameScreenHeight);
		SoundSystem.ini();

		Keyboard.ZZINTERN_setKeyMapping(window.generateKeyMapping());
		Mouse.ZZINTERN_setMouseMapping(window.generateMouseMapping());

		game.initialize(window);

		while(GameStarter.running){
			TimeManager.update();

			state.update(TimeManager.getTimeSinceLastFrame());
			Renderer renderer = window.prepareRendering();
			state.draw(renderer);
			window.postRender();

			Keyboard.ZZINTERN_onFrameEnd();
			Mouse.ZZINTERN_onFrameEnd();

			if(changeGameStateRequested){
				changeGameStateRequested = false;
				state.onGameStateLeave();
				state = gameStateToChangeTo;
				gameStateToChangeTo = null;
				state.initialize(window);
			}

			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}


		SoundSystem.close();
		window.cleanup();
		state.onGameStateLeave();
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
