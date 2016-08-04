package de.brotcrunsher.snd;

import static org.lwjgl.openal.AL10.*;

import de.brotcrunsher.math.linear.Vector2;

public class SoundPlayer {
	private Vector2 position = new Vector2();
	private Vector2 speed = new Vector2();
	private Sound sound;
	private int id;

	private float rolloffFactor;
	private float referenceDistance;
	private float maxDistance;
	
	public SoundPlayer(Sound sound){
		this(sound, 0, 0);
	}

	public SoundPlayer(Sound sound, Vector2 position){
		this(sound, position.getX(), position.getY());
	}

	public SoundPlayer(Sound sound, float x, float y){
		if(sound == null){
			throw new NullPointerException();
		}
		SoundSystem.ini();

		this.sound = sound;
		id = alGenSources();
		alSourcef(id, AL_GAIN, 1);
		alSourcef(id, AL_PITCH, 1);
		alSource3f(id, AL_POSITION, 0, 0, 0);

		alSourcei(id, AL_BUFFER, sound.getBuffer());
		alSourcePlay(id);

		setPosition(new Vector2(x, y));
		setReferenceDistance(300);
		setMaxDistance(2000);
	}

	public void play(){
		stop();
		alSourcePlay(id);
	}

	public void pause(){
		alSourcePause(id);
	}

	public void continuePlaying(){
		alSourcePlay(id);
	}

	public void stop(){
		alSourceStop(id);
	}

	public void close(){
		stop();
		alDeleteSources(id);
	}

	public void setPosition(Vector2 pos){
		setPosition(pos.getX(), pos.getY());
	}
	
	public void setPosition(float x, float y){
		if(sound.isMono() == false && x != 0 && y != 0){
			throw new IllegalStateException("You tried to set the position of a Soundplayer but it's sound wasn't mono.");
		}
		position.set(x, y);
		alSource3f(id, AL_POSITION, x, 0, y);
	}

	public Vector2 getPosition(Vector2 result){
		if(result == null){
			result = new Vector2();
		}
		result.set(position);
		return result;
	}
	
	public void setSpeed(Vector2 speed){
		setSpeed(speed.getX(), speed.getY());
	}
	
	public void setSpeed(float x, float y){
		if(sound.isMono() == false && x != 0 && y != 0){
			throw new IllegalStateException("You tried to set the speed of a Soundplayer but it's sound wasn't mono.");
		}
		speed.set(x, y);
		alSource3f(id, AL_VELOCITY, x, 0, y);
	}
	
	public Vector2 getSpeed(Vector2 result){
		if(result == null){
			result = new Vector2();
		}
		
		result.set(speed);
		return result;
	}

	public void setVolume(float volume){
		alSourcef(id, AL_GAIN, volume);
	}

	public void setPitch(float pitch){
		alSourcef(id, AL_PITCH, pitch);
	}

	public void setVolicity(float x, float y){
		alSource3f(id, AL_VELOCITY, x, 0, y);
	}

	public void setLooping(boolean loop){
		alSourcei(id, AL_LOOPING, loop ? AL_TRUE : AL_FALSE);
	}

	public boolean isPlaying(){
		return alGetSourcei(id, AL_SOURCE_STATE) == AL_PLAYING;
	}
	

	
	public void setRolloffFactor(float rolloffFactor){
		this.rolloffFactor = rolloffFactor;
		alSourcef(id, AL_ROLLOFF_FACTOR, rolloffFactor);
	}
	
	public void setMaxDistance(float maxDistance){
		this.maxDistance = maxDistance;
		alSourcef(id, AL_MAX_DISTANCE, maxDistance);
	}
	
	public void setReferenceDistance(float referenceDistance){
		this.referenceDistance = referenceDistance;
		alSourcef(id, AL_REFERENCE_DISTANCE, referenceDistance);
	}
	
	public float getRolloffFactor(){
		return rolloffFactor;
	}
	
	public float getMaxDistance(){
		return maxDistance;
	}
	
	public float getReferenceDistance(){
		return referenceDistance;
	}
}
