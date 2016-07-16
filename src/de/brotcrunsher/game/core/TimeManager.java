package de.brotcrunsher.game.core;

import de.brotcrunsher.datastructures.RingArrayLong;

public class TimeManager {
	public final static long GameStartTimestamp;
	
	private static long lastFrame;
	private static long thisFrame;
	
	private static long timeSinceLastFrameMillis = 0;
	private static float timeSinceLastFrame = 0;
	private static int frameNumber = 0;
	private static RingArrayLong frameTimesForLast30Frames = new RingArrayLong(30);
	
	static{
		GameStartTimestamp = System.currentTimeMillis();
		lastFrame = GameStartTimestamp;
		thisFrame = GameStartTimestamp;
	}
	
	public static void update(){
		frameNumber++;
		lastFrame = thisFrame;
		thisFrame = System.currentTimeMillis();
		
		timeSinceLastFrameMillis = thisFrame - lastFrame;
		frameTimesForLast30Frames.set(frameNumber, timeSinceLastFrameMillis);
		timeSinceLastFrame = timeSinceLastFrameMillis / 1000f;
	}
	
	public static long getTimeSinceLastFrameMillis(){
		return timeSinceLastFrameMillis;
	}
	
	public static float getTimeSinceLastFrame(){
		return timeSinceLastFrame;
	}
	
	public static float getAverageFrameTime(){
		return frameTimesForLast30Frames.calculateAvg() / 1000f;
	}
}
