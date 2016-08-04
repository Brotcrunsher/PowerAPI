package de.brotcrunsher.snd;

import static org.lwjgl.openal.ALC10.alcCloseDevice;
import static org.lwjgl.openal.ALC10.alcCreateContext;
import static org.lwjgl.openal.ALC10.alcMakeContextCurrent;
import static org.lwjgl.openal.ALC10.alcOpenDevice;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

import org.lwjgl.openal.AL;
import org.lwjgl.openal.ALC;
import org.lwjgl.openal.ALCCapabilities;

public class SoundSystem {
	private static boolean iniDone = false;
	private static long device = 0;

	public static void ini(){
		if(iniDone) return;


		device = alcOpenDevice((ByteBuffer)null);
		if (device == 0)
			throw new IllegalStateException("Failed to open the default device.");
		ALCCapabilities deviceCaps = ALC.createCapabilities(device);
		long context = alcCreateContext(device, (IntBuffer) null);
		if (context == 0)
			throw new IllegalStateException("Failed to create an OpenAL context.");
		alcMakeContextCurrent(context);
		AL.createCapabilities(deviceCaps);

		iniDone = true;
	}

	public static void close(){
		alcCloseDevice(device);
	}
}
