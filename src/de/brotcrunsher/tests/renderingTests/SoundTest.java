package de.brotcrunsher.tests.renderingTests;

import de.brotcrunsher.game.core.Game;
import de.brotcrunsher.game.core.TimeManager;
import de.brotcrunsher.gfx.basics.Color;
import de.brotcrunsher.gfx.rendering.Renderer;
import de.brotcrunsher.gfx.rendering.Window;
import de.brotcrunsher.input.Key;
import de.brotcrunsher.input.Keyboard;
import de.brotcrunsher.math.linear.Vector2;
import de.brotcrunsher.snd.Sound;
import de.brotcrunsher.snd.SoundListener;
import de.brotcrunsher.snd.SoundPlayer;

public class SoundTest implements Game{
	public static void main(String[] args) {
		new SoundTest().start();
	}

	Sound sound = null;
	SoundPlayer soundPlayer = null;

	Vector2 playerPos = new Vector2(400, 400);
	Vector2 sourcePos = new Vector2();
	Vector2 sourceSpeed = new Vector2();
	@Override
	public void initialize(Window window) {
	}

	@Override
	public void update(float timeSinceLastFrame) {
		float speed = 1000;
		sourceSpeed.set(0, 0);
		if(Keyboard.isKeyDown(Key.w)){
			sourceSpeed.addToThisY(-speed);
		}
		if(Keyboard.isKeyDown(Key.s)){
			sourceSpeed.addToThisY(speed);
		}
		if(Keyboard.isKeyDown(Key.a)){
			sourceSpeed.addToThisX(-speed);
		}
		if(Keyboard.isKeyDown(Key.d)){
			sourceSpeed.addToThisX(speed);
		}
		
		sourceSpeed.multThis(timeSinceLastFrame);
		
		sourcePos.addToThis(sourceSpeed);

		soundPlayer.setPosition(sourcePos);
		soundPlayer.setSpeed(sourceSpeed);
		SoundListener.setPosition(playerPos);
	}

	@Override
	public void draw(Renderer r) {
		r.clearScreen();

		r.setColor(Color.AWT_GREEN);
		r.fillRect(playerPos.getX() - 50, playerPos.getY() - 50, 100, 100);

		r.setColor(Color.AWT_BLUE);
		r.fillRect(sourcePos.getX() - 50, sourcePos.getY() - 50, 100, 100);
	}

	@Override
	public void preInitialize() {
		sound = new Sound("src/snd/testsound.wav");
		sound.load();
		System.out.println(sound.getDurationInSeconds());
		soundPlayer = new SoundPlayer(sound);
		soundPlayer.setLooping(true);
		soundPlayer.setPosition(sourcePos);
		soundPlayer.play();
		
		SoundListener.setDopplerFactor(10);
	}

}
