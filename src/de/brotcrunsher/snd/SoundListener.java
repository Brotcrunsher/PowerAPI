package de.brotcrunsher.snd;

import static org.lwjgl.openal.AL10.*;
import static org.lwjgl.openal.AL11.*;

import de.brotcrunsher.math.linear.Vector2;

public class SoundListener {
	private static Vector2 listenerPosition = new Vector2();
	private static Vector2 listenerSpeed = new Vector2();
	private static DistanceModel distanceModel;
	private static float dopplerFactor;	
	
	static{
		SoundSystem.ini();
		setDistanceModel(DistanceModel.linear);
		setDopplerFactor(1);
	}
	
	
	public static void setPosition(Vector2 listenerPosition){
		if(listenerPosition == null) throw new NullPointerException();
		
		setPosition(listenerPosition.getX(), listenerPosition.getY());
	}
	
	public static void setPosition(float x, float y){
		if(Float.isNaN(x)) throw new IllegalArgumentException("x was NaN!");
		if(Float.isNaN(y)) throw new IllegalArgumentException("y was NaN!");
		SoundListener.listenerPosition.set(x, y);

		alListener3f(AL_POSITION, x, 0, y);
	}

	public static Vector2 getPosition(Vector2 result){
		if(result == null){
			result = new Vector2();
		}

		result.set(listenerPosition);
		return result;
	}
	
	public static void setSpeed(Vector2 listenerSpeed){
		if(listenerPosition == null) throw new NullPointerException();
		setSpeed(listenerSpeed.getX(), listenerSpeed.getY());
	}
	
	public static void setSpeed(float x, float y){
		if(Float.isNaN(x)) throw new IllegalArgumentException("x was NaN!");
		if(Float.isNaN(y)) throw new IllegalArgumentException("y was NaN!");
		SoundListener.listenerSpeed.set(listenerSpeed);
		
		alListener3f(AL_VELOCITY, listenerSpeed.getX(), 0, listenerPosition.getY());
	}
	
	public static void setDistanceModel(DistanceModel dm){
		int idm = -1;
		switch(dm){
		case exponent:
			idm = AL_EXPONENT_DISTANCE;
			break;
		case exponent_clamped:
			idm = AL_EXPONENT_DISTANCE_CLAMPED;
			break;
		case inverse:
			idm = AL_INVERSE_DISTANCE;
			break;
		case inverse_clamped:
			idm = AL_INVERSE_DISTANCE_CLAMPED;
			break;
		case linear:
			idm = AL_LINEAR_DISTANCE;
			break;
		case linear_clamped:
			idm = AL_LINEAR_DISTANCE_CLAMPED;
			break;
		default:
			throw new IllegalArgumentException(dm + " is not supported!");
		}
		
		alDistanceModel(idm);
	}
	
	public static DistanceModel getDistanceModel(){
		return distanceModel;
	}
	
	public static void setDopplerFactor(float factor){
		alDopplerFactor(factor);
		dopplerFactor = factor;
	}
	
	public static float getDopplerFactor(){
		return dopplerFactor;
	}
}
