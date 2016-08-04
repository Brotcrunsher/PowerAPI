package de.brotcrunsher.game.core;

import de.brotcrunsher.datastructures.RingArrayLong;

public class TimeManager {
	public final static long GameStartTimestamp;
	
	private static long lastFrame;
	private static long thisFrame;
	
	private static long timeSinceLastFrameMillis = 0;
	private static float timeSinceLastFrame = 0;
	private static int frameNumber = 0;
	private static int amountOfFrameTimeRecords = 30;
	private static RingArrayLong frameTimesForLastFrames = new RingArrayLong(amountOfFrameTimeRecords);
	
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
		frameTimesForLastFrames.set(frameNumber, timeSinceLastFrameMillis);
		timeSinceLastFrame = timeSinceLastFrameMillis / 1000f;
	}
	
	public static long getTimeSinceLastFrameMillis(){
		return timeSinceLastFrameMillis;
	}
	
	public static float getTimeSinceLastFrame(){
		return timeSinceLastFrame;
	}
	
	public static float getAverageFrameTime(){
		if(frameNumber < amountOfFrameTimeRecords){
			return frameTimesForLastFrames.calculateSum() / frameNumber / 1000f;
		}
		return frameTimesForLastFrames.calculateAvg() / 1000f;
	}
	
	public static float getTimeSinceStartup(){
		return (thisFrame - GameStartTimestamp) / 1000f;
	}
	
	public static int getFrameNumber(){
		return frameNumber;
	}
}
