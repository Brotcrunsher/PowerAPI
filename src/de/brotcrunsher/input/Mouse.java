package de.brotcrunsher.input;

import de.brotcrunsher.math.linear.Vector2;

public class Mouse {
	private static MouseMapping mouseMapping = null;
	private static boolean[] buttons = new boolean[MouseButton.last.ordinal()];
	private static boolean[] buttonsLastFrame = new boolean[buttons.length];
	private static boolean[] buttonsNextFrame = new boolean[buttons.length];
	
	private static float x = 0;
	private static float preX = 0;
	private static float y = 0;
	private static float preY = 0;
	
	public static boolean isButtonDown(MouseButton button){
		return buttons[button.ordinal()];
	}
	
	public static boolean isButtonUp(MouseButton button){
		return !isButtonDown(button);
	}
	
	public static boolean isButtonPressedThisFrame(MouseButton button){
		return buttons[button.ordinal()] && !buttonsLastFrame[button.ordinal()];
	}
	
	public static boolean isButtonReleasedThisFrame(MouseButton button){
		return !buttons[button.ordinal()] && buttonsLastFrame[button.ordinal()];
	}
	
	public static float getX(){
		return x;
	}
	
	public static float getY(){
		return y;
	}
	
	public static void getPos(Vector2 result){
		result.set(getX(), getY());
	}
	
	public static float getDX(){
		return x - preX;
	}
	
	public static float getDY(){
		return y - preY;
	}
	
	public static void getDelta(Vector2 result){
		result.set(getDX(), getDY());
	}
	
	public static void ZZINTERN_onButtonPress(int raw){
		MouseButton mb = mouseMapping.rawToMouseButton(raw);
		int index = mb.ordinal();
		buttonsNextFrame[index] = true;
	}
	
	public static void ZZINTERN_onButtonRelease(int raw){
		MouseButton mb = mouseMapping.rawToMouseButton(raw);
		int index = mb.ordinal();
		buttonsNextFrame[index] = false;
	}
	
	public static void ZZINTERN_setMouseMapping(MouseMapping mapping){
		mouseMapping = mapping;
	}
	
	public static void ZZINTERN_onFrameEnd(){
		for(int i = 0; i<buttons.length; i++){
			buttonsLastFrame[i] = buttons[i];
			buttons[i] = buttonsNextFrame[i];
		}
	}
	
	public static void ZZINTERN_setX(float x){
		if(mouseMapping == null) return;
		preX = Mouse.x;
		Mouse.x = mouseMapping.transformXPos(x);
	}
	public static void ZZINTERN_setY(float y){
		if(mouseMapping == null) return;
		preY = Mouse.y;
		Mouse.y = mouseMapping.transformYPos(y);
	}
}
