package de.brotcrunsher.gfx.rendering;

import org.lwjgl.*;
import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;

import de.brotcrunsher.game.core.GameStarter;

import static org.lwjgl.glfw.Callbacks.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.*;


public class WindowOpenGL implements Window{

	private long window;

	@Override
	public void create(String name, int screenWidth, int screenHeight) {
		// Setup an error callback. The default implementation
		// will print the error message in System.err.
		GLFWErrorCallback.createPrint(System.err).set();

		// Initialize GLFW. Most GLFW functions will not work before doing this.
		if ( !glfwInit() )
			throw new IllegalStateException("Unable to initialize GLFW");

		// Configure our window
		glfwDefaultWindowHints(); // optional, the current window hints are already the default
		glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE); // the window will stay hidden after creation
		glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE); // the window will be resizable

		// Create the window
		window = glfwCreateWindow(screenWidth, screenHeight, name, NULL, NULL);
		if ( window == NULL )
			throw new RuntimeException("Failed to create the GLFW window");

		// Setup a key callback. It will be called every time a key is pressed, repeated or released.
		glfwSetKeyCallback(window, (window, key, scancode, action, mods) -> {
		if ( key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE )
			glfwSetWindowShouldClose(window, true); // We will detect this in our rendering loop
		});

		// Get the resolution of the primary monitor
		GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());
		// Center our window
		glfwSetWindowPos(
			window,
			(vidmode.width() - screenWidth) / 2,
			(vidmode.height() - screenHeight) / 2
		);

		// Make the OpenGL context current
		glfwMakeContextCurrent(window);
		// Enable v-sync
		glfwSwapInterval(1);

		// Make the window visible
		glfwShowWindow(window);
		
		// This line is critical for LWJGL's interoperation with GLFW's
		// OpenGL context, or any context that is managed externally.
		// LWJGL detects the context that is current in the current thread,
		// creates the GLCapabilities instance and makes the OpenGL
		// bindings available for use.
		GL.createCapabilities();
		
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, screenWidth, screenHeight, 0, 1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_BLEND);	//Transparenz zulassen
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
	}

	@Override
	public Renderer prepareRendering() {
		// Run the rendering loop until the user has attempted to close
		// the window or has pressed the ESCAPE key.
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); // clear the framebuffer
		glfwSwapBuffers(window); // swap the color buffers
		// Poll for window events. The key callback above will only be
		// invoked during this call.
		glfwPollEvents();
		
		if(glfwWindowShouldClose(window)){
			GameStarter.stopGame();
		}
		return new RendererOpenGL();
	}
	
	@Override
	public void cleanup() {
		glfwFreeCallbacks(window);
		glfwDestroyWindow(window);
		glfwTerminate();
		glfwSetErrorCallback(null).free();
	}

}
