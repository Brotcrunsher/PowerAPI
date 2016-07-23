package de.brotcrunsher.unitTests;

import de.brotcrunsher.game.core.Game;
import de.brotcrunsher.gfx.basics.Color;
import de.brotcrunsher.gfx.rendering.Renderer;
import de.brotcrunsher.input.Key;
import de.brotcrunsher.input.Keyboard;
import de.brotcrunsher.input.Mouse;
import de.brotcrunsher.math.linear.BezierCurve2;
import de.brotcrunsher.math.linear.Interpolations;
import de.brotcrunsher.math.linear.Vector2;

public class BezierCurveRenderingTest implements Game{
	public static void main(String[] args) {
		new BezierCurveRenderingTest().start();
	}
	
	private Vector2 start = new Vector2();
	private Vector2 stop  = new Vector2();
	private Vector2[] control = new Vector2[8];
	private BezierCurve2 bc2 = new BezierCurve2(start, stop, control);
	
	private Vector2 result = new Vector2();
	private Vector2 result2 = new Vector2();
	private Vector2 resultDirection = new Vector2();
	
	@Override
	public void preInitialize() {
		for(int i = 0; i<control.length; i++){
			control[i] = new Vector2();
		}
	}

	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(float timeSinceLastFrame) {
		if(Keyboard.isKeyDown(Key._1)){
			Mouse.getPos(start);
		}
		if(Keyboard.isKeyDown(Key._0)){
			Mouse.getPos(stop);
		}
		if(Keyboard.isKeyDown(Key._2)){
			Mouse.getPos(control[0]);
		}
		if(Keyboard.isKeyDown(Key._3)){
			Mouse.getPos(control[1]);
		}
		if(Keyboard.isKeyDown(Key._4)){
			Mouse.getPos(control[2]);
		}
		if(Keyboard.isKeyDown(Key._5)){
			Mouse.getPos(control[3]);
		}
		if(Keyboard.isKeyDown(Key._6)){
			Mouse.getPos(control[4]);
		}
		if(Keyboard.isKeyDown(Key._7)){
			Mouse.getPos(control[5]);
		}
		if(Keyboard.isKeyDown(Key._8)){
			Mouse.getPos(control[6]);
		}
		if(Keyboard.isKeyDown(Key._9)){
			Mouse.getPos(control[7]);
		}
		if(timeSinceLastFrame > 0.008)
			System.out.println(timeSinceLastFrame);
	}

	@Override
	public void draw(Renderer r) {
		r.setColor(Color.AWT_WHITE);
		r.clearScreen();
		
		
		r.setColor(Color.AWT_BLACK);
		r.setLineWidth(3);
		
		/*bc2.eval(result, 0);
		for(float i = 0; i<= 1; i += 0.01f){
			bc2.eval(result2, i);
			r.drawLine(result, result2);
			bc2.direction(resultDirection, i);
			//resultDirection.rotate90ClockwiseThis();
			resultDirection.multThis(30);
			resultDirection.addToThis(result);
			r.drawLine(result, resultDirection);
			
			result.set(result2);
		}*/
		
		bc2.draw(r);
		
		r.setColor(Color.AWT_RED);
		r.fillRect(start.sub(null, 5, 5), 10, 10);
		r.setColor(Color.AWT_GREEN);
		r.fillRect(stop.sub(null, 5, 5), 10, 10);
		r.setColor(Color.AWT_BLUE);
		for(int i = 0; i<control.length; i++){
			r.fillRect(control[i].sub(null, 5, 5), 10, 10);
		}
	}
}
