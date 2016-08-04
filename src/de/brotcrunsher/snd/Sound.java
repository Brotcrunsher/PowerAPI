package de.brotcrunsher.snd;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

import org.lwjgl.BufferUtils;
import org.lwjgl.openal.AL10;

public class Sound {
	private boolean loaded = false;
	private boolean isMono = false;
	private File file;
	private int buffer = 0;
	private float duration = 0;
	
	public Sound(String path) {
		this(new File(path), false);
	}

	public Sound(File file) {
		this(file, false);
	}
	
	public Sound(String path, boolean shouldLoad){
		this(new File(path), shouldLoad);
	}

	public Sound(File file, boolean shouldLoad) {
		if (file == null)
			throw new NullPointerException();
		this.file = file;
		if (shouldLoad) {
			load();
		}
	}

	public void close() {
		AL10.alDeleteBuffers(buffer);
	}

	public void load() {
		if (loaded)
			return;
		SoundSystem.ini();

		AudioInputStream audioStream = null;
		try {
			audioStream = AudioSystem.getAudioInputStream(file);
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		AudioFormat audioFormat = audioStream.getFormat();
		duration = (float)audioStream.getFrameLength() / audioFormat.getFrameRate();
		int format = getOpenAlFormat(audioFormat.getChannels(), audioFormat.getSampleSizeInBits());
		int samplerate = (int) audioFormat.getSampleRate();
		int bytesPerFrame = audioFormat.getFrameSize();
		int totalBytes = (int) (audioStream.getFrameLength() * bytesPerFrame);
		ByteBuffer data = BufferUtils.createByteBuffer(totalBytes);
		byte[] dataArray = new byte[totalBytes];
		try {
			int bytesRead = audioStream.read(dataArray, 0, totalBytes);
			data.clear();
			data.put(dataArray, 0, bytesRead);
			data.flip();
		} catch (IOException e) {
			e.printStackTrace();
		}

		this.buffer = AL10.alGenBuffers();
		AL10.alBufferData(buffer, format, data, samplerate);
		try {
			audioStream.close();
			data.clear();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		loaded = true;
	}

	public float getDurationInSeconds() {
		if(!loaded) throw new IllegalStateException("Sound must be loaded first!");
		return duration;
	}

	private int getOpenAlFormat(int channels, int bitsPerSample) {
		if (channels == 1) {
			isMono = true;
			return bitsPerSample == 8 ? AL10.AL_FORMAT_MONO8 : AL10.AL_FORMAT_MONO16;
		} else {
			return bitsPerSample == 8 ? AL10.AL_FORMAT_STEREO8 : AL10.AL_FORMAT_STEREO16;
		}
	}

	/* pp */ int getBuffer() {
		if (!loaded)
			load();
		return buffer;
	}
	
	public boolean isMono(){
		if(!loaded) throw new IllegalStateException("Sound must be loaded first!");
		return isMono;
	}
}
