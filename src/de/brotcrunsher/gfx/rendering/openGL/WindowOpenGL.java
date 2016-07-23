package de.brotcrunsher.gfx.rendering.openGL;

import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;

import de.brotcrunsher.game.core.GameStarter;
import de.brotcrunsher.gfx.rendering.Renderer;
import de.brotcrunsher.gfx.rendering.Window;
import de.brotcrunsher.input.KeyMapping;
import de.brotcrunsher.input.KeyMappingOpenGL;
import de.brotcrunsher.input.MouseMapping;

import static org.lwjgl.glfw.Callbacks.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.*;


public class WindowOpenGL implements Window{

	private long window;

	@Override
	public void create(String name, int screenWidth, int screenHeight) {
		if(!glfwInit()){
			throw new IllegalStateException("Unable to initialize GLFW");
		}
		
		glfwWindowHint(GLFW_RESIZABLE, GL_TRUE);
		window = glfwCreateWindow(screenWidth, screenHeight, name, NULL, NULL);
		if(window == NULL){
			throw new RuntimeException("Failed to create the GLFW window");
		}
		
		glfwWindowHint(GLFW_RESIZABLE, GLFW_FALSE);
		
		GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());
		glfwSetWindowPos(window, 100, 100);
		glfwMakeContextCurrent(window);
		glfwShowWindow(window);
		
		
		glfwMakeContextCurrent(window);
		GL.createCapabilities();
		System.out.println("Version: " + glGetString(GL_VERSION));

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
		// Poll for window events. The key callback above will only be
		// invoked during this call.
		glfwPollEvents();
		
		if(glfwWindowShouldClose(window)){
			GameStarter.stopGame();
		}
		return new RendererOpenGL();
	}
	
	@Override
	public void postRender() {
		glfwSwapBuffers(window); // swap the color buffers
	}
	
	@Override
	public void cleanup() {
		glfwFreeCallbacks(window);
		glfwDestroyWindow(window);
		glfwTerminate();
		glfwSetErrorCallback(null).free();
	}

	@Override
	public KeyMapping generateKeyMapping() {
		return new KeyMappingOpenGL();
	}

	@Override
	public MouseMapping generateMouseMapping() {
		// TODO Auto-generated method stub
		return null;
	}

}
