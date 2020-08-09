 package com.yarharharddrive.engine;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class Window
{
	private JFrame frame;
	private BufferedImage image;
	private Canvas canvas;
	private BufferStrategy bs;
	private Graphics gfx;
	
	
	public Window(GameContainer gc)
	{
		image = new BufferedImage(gc.getWidth(), gc.getHeight(), BufferedImage.TYPE_INT_RGB);
		canvas = new Canvas();
		Dimension s = new Dimension((int)(gc.getWidth() * gc.getScale()), (int)(gc.getHeight() * gc.getScale()));
		canvas.setPreferredSize(s);
		canvas.setMaximumSize(s);
		canvas.setMinimumSize(s);
		canvas.setBackground(Color.BLACK);
		
		frame = new JFrame(gc.getTitle());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.add(canvas, BorderLayout.CENTER);
		//frame.setUndecorated(true);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setVisible(true);
		
		canvas.createBufferStrategy(2);
		bs = canvas.getBufferStrategy();
		gfx = bs.getDrawGraphics();
	}
	
	public JFrame getFrame() {
		return frame;
	}

	public BufferedImage getImage() {
		return image;
	}

	public Canvas getCanvas() {
		return canvas;
	}

	public void update()
	{
		gfx.drawImage(image, 0, 0, canvas.getWidth(), canvas.getHeight(), null);
		bs.show();
	}
}
