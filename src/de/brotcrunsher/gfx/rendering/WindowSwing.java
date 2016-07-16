package de.brotcrunsher.gfx.rendering;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;
import javax.swing.JLabel;

import de.brotcrunsher.game.core.Game;

public class WindowSwing extends JFrame implements Window{
	private Game game;
	private BufferStrategy strat;
	private float top;
	private float left;
	
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
	}

	private void makeStrat(){
		createBufferStrategy(2);
		strat = getBufferStrategy();
	}
	
	@Override
	public void renderScreen(Game game) {
		Graphics g = strat.getDrawGraphics();
		game.draw(new RendererSwing((Graphics2D)g, left, top));
		g.dispose();
		strat.show();
	}
}
