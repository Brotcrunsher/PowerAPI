package de.brotcrunsher.gfx.rendering.swing;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferStrategy;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;

import de.brotcrunsher.game.core.Game;
import de.brotcrunsher.game.core.GameStarter;
import de.brotcrunsher.gfx.basics.Font;
import de.brotcrunsher.gfx.basics.Image;
import de.brotcrunsher.gfx.rendering.Renderer;
import de.brotcrunsher.gfx.rendering.Window;
import de.brotcrunsher.input.KeyMapping;
import de.brotcrunsher.input.KeyMappingSwing;
import de.brotcrunsher.input.Keyboard;
import de.brotcrunsher.input.Mouse;
import de.brotcrunsher.input.MouseMapping;
import de.brotcrunsher.input.MouseMappingSwing;

public class WindowSwing extends JFrame implements Window, KeyListener, MouseMotionListener, MouseListener, WindowListener{
	private BufferStrategy strat;
	private float top;
	private float left;
	private Graphics g;

	private RendererSwing renderer;

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
		addMouseListener(this);
		addMouseMotionListener(this);
		addWindowListener(this);
		renderer = new RendererSwing();
	}

	private void makeStrat(){
		createBufferStrategy(3);
		strat = getBufferStrategy();
	}

	@Override
	public Renderer prepareRendering() {
		g = strat.getDrawGraphics();
		strat.show();
		renderer.initialize((Graphics2D)g, left, top);
		return renderer;
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
	public MouseMapping generateMouseMapping() {
		return new MouseMappingSwing(left, top);
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

	@Override
	public void mouseDragged(MouseEvent e) {
		mouseMoved(e);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		Mouse.ZZINTERN_setX(e.getX());
		Mouse.ZZINTERN_setY(e.getY());
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		//unused
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		//unused
	}

	@Override
	public void mouseExited(MouseEvent e) {
		//unused
	}

	@Override
	public void mousePressed(MouseEvent e) {
		Mouse.ZZINTERN_onButtonPress(e.getButton());
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		Mouse.ZZINTERN_onButtonRelease(e.getButton());

	}

	@Override
	public Image getImage(String path) throws IOException {
		return new ImageSwing(path);
	}

	@Override
	public Font getFont(float size) {
		return new FontSwing(size);
	}

	@Override
	public Font getFont(float size, String path) {
		return new FontSwing(size, path);
	}

	@Override
	public void windowActivated(WindowEvent e) {}

	@Override
	public void windowClosed(WindowEvent e) {}

	@Override
	public void windowClosing(WindowEvent e) {
		GameStarter.stopGame();
	}

	@Override
	public void windowDeactivated(WindowEvent e) {}

	@Override
	public void windowDeiconified(WindowEvent e) {}

	@Override
	public void windowIconified(WindowEvent e) {}

	@Override
	public void windowOpened(WindowEvent e) {}

	@Override
	public Image getGrayscaleImage(float[][] arr) {
		return new ImageSwing(arr);
	}

}
