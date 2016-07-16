package de.brotcrunsher.gfx.rendering;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;

import de.brotcrunsher.game.core.Game;

public class WindowSwing extends JFrame implements Window{
	private Screen screen;
	private Game game;
	
	@Override
	public void create(String name, int screenWidth, int screenHeight) {
		this.setTitle(name);
		screen = new Screen();
		screen.setBounds(0, 0, screenWidth, screenHeight);
		add(screen);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		this.pack();
		Insets insets = getInsets();
		this.setSize(screenWidth + insets.left + insets.right, screenHeight + insets.top + insets.bottom);
	}

	@Override
	public void renderScreen(Game game) {
		this.game = game;
		screen.repaint();
	}
	
	
	private class Screen extends JLabel{
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			game.draw(new RendererSwing((Graphics2D)g));
			
		}
	}
}
