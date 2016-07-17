package de.brotcrunsher.input;

public class Keyboard {
	private static KeyMapping keyMapping = null;
	private static boolean[] keys = new boolean[Key.last.ordinal()];
	private static boolean[] keysLastFrame = new boolean[keys.length];
	private static boolean[] keysNextFrame = new boolean[keys.length];
	
	public static boolean isKeyDown(Key key){
		return keys[key.ordinal()];
	}
	
	public static boolean isKeyUp(Key key){
		return !isKeyDown(key);
	}
	
	public static boolean isKeyPressedThisFrame(Key key){
		return keys[key.ordinal()] && !keysLastFrame[key.ordinal()];
	}
	
	public static boolean isKeyReleasedThisFrame(Key key){
		return !keys[key.ordinal()] && keysLastFrame[key.ordinal()];
	}
	
	public static void ZZINTERN_onKeyPress(int key){
		Key k = keyMapping.rawToKey(key);
		int index = k.ordinal();
		keysNextFrame[index] = true;
	}
	
	public static void ZZINTERN_onKeyRelease(int key){
		Key k = keyMapping.rawToKey(key);
		int index = k.ordinal();
		keysNextFrame[index] = false;
	}
	
	public static void ZZINTERN_setKeyMapping(KeyMapping mapping){
		keyMapping = mapping;
	}
	
	public static void ZZINTERN_onFrameEnd(){
		for(int i = 0; i<keys.length; i++){
			keysLastFrame[i] = keys[i];
			keys[i] = keysNextFrame[i];
		}
	}
}
