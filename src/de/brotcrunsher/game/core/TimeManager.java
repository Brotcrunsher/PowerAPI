package de.brotcrunsher.game.core;

public class TimeManager {
	public final static long GameStartTimestamp;
	
	private static long lastFrame;
	private static long thisFrame;
	
	private static long timeSinceLastFrameMillis = 0;
	private static float timeSinceLastFrame = 0;
	
	static{
		GameStartTimestamp = System.currentTimeMillis();
		lastFrame = GameStartTimestamp;
		thisFrame = GameStartTimestamp;
	}
	
	public static void update(){
		lastFrame = thisFrame;
		thisFrame = System.currentTimeMillis();
		
		timeSinceLastFrameMillis = thisFrame - lastFrame;
		timeSinceLastFrame = timeSinceLastFrameMillis / 1000f;
	}
	
	public static long getTimeSinceLastFrameMillis(){
		return timeSinceLastFrameMillis;
	}
	
	public static float getTimeSinceLastFrame(){
		return timeSinceLastFrame;
	}
}
