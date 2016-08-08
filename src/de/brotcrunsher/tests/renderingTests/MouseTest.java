package de.brotcrunsher.tests.renderingTests;

import de.brotcrunsher.game.core.Game;
import de.brotcrunsher.gfx.basics.Color;
import de.brotcrunsher.gfx.rendering.Renderer;
import de.brotcrunsher.gfx.rendering.Window;
import de.brotcrunsher.input.Mouse;
import de.brotcrunsher.input.MouseButton;
import de.brotcrunsher.math.linear.Interpolations;
import de.brotcrunsher.math.linear.Vector2;

public class MouseTest implements Game{
	
	public static void main(String[] args) {
		new MouseTest().start();
	}
	
	Vector2 pos;
	Color color = new Color();
	
	@Override
	public void preInitialize() {
		
	}

	@Override
	public void initialize(Window w) {
		
	}

	@Override
	public void update(float timeSinceLastFrame) {
		Mouse.getPos(pos);

		System.out.println(pos + " " + Mouse.isButtonDown(MouseButton.left) + " " + Mouse.isButtonDown(MouseButton.right) + " " + Mouse.isButtonDown(MouseButton.middle));
		
		if(Mouse.isButtonPressedThisFrame(MouseButton.left)){
			System.out.println("Left pressed");
		}
		if(Mouse.isButtonPressedThisFrame(MouseButton.right)){
			System.out.println("Right pressed");
		}
		if(Mouse.isButtonPressedThisFrame(MouseButton.middle)){
			System.out.println("Middle pressed");
		}

		if(Mouse.isButtonReleasedThisFrame(MouseButton.left)){
			System.out.println("Left released");
		}
		if(Mouse.isButtonReleasedThisFrame(MouseButton.right)){
			System.out.println("Right released");
		}
		if(Mouse.isButtonReleasedThisFrame(MouseButton.middle)){
			System.out.println("Middle released");
		}
	}

	@Override
	public void draw(Renderer r) {
		r.setColor(Color.WHITE);
		r.clearScreen();
		r.setColor(Color.RED);
		float posSum = pos.getX() + pos.getY();
		Interpolations.cosine(color, Color.YELLOW, Color.BLUE, pos.getX() / posSum);
		color.standardize();
		r.setColor(color);
		r.fillRect(pos, pos);
	}

}
