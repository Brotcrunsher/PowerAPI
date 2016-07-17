package de.brotcrunsher.gfx.rendering;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;
import javax.swing.JLabel;

import de.brotcrunsher.game.core.Game;
import de.brotcrunsher.input.KeyMapping;
import de.brotcrunsher.input.KeyMappingSwing;
import de.brotcrunsher.input.Keyboard;

public class WindowSwing extends JFrame implements Window, KeyListener{
	private BufferStrategy strat;
	private float top;
	private float left;
	private Graphics g;
	
	@Override
	public void create(String name, int screenWidth, int screenHeight) {
		this.setTitle(name);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		this.pack();
		Insets insets = getInsets();
		this.setSize(screenWidth + insets.left + insets.right, screenHeight + insets.top + insets.bottom);
		top = insets.top;
		left = insets.left;
		makeStrat();
		addKeyListener(this);
	}

	private void makeStrat(){
		createBufferStrategy(2);
		strat = getBufferStrategy();
	}
	
	@Override
	public Renderer prepareRendering() {
		g = strat.getDrawGraphics();
		strat.show();
		return new RendererSwing((Graphics2D)g, left, top);
	}

	@Override
	public void postRender() {
		g.dispose();
	}

	@Override
	public KeyMapping generateKeyMapping() {
		return new KeyMappingSwing();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		Keyboard.ZZINTERN_onKeyPress(e.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		Keyboard.ZZINTERN_onKeyRelease(e.getKeyCode());
	}

	@Override
	public void keyTyped(KeyEvent e) {
		//unused
	}
}
