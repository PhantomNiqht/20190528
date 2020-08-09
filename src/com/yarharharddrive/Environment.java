package com.yarharharddrive;

import com.yarharharddrive.engine.gfx.Image;
import com.yarharharddrive.engine.sfx.SoundClip;

// Tiled World, Static, soon to be Random Generated
public abstract class Environment
{
	protected int x;
	protected int y;
	protected int width;
	protected int height;
	protected static int tileSize = 32;
	protected Image img;
	protected static SoundClip woodStep = new SoundClip("/sounds/stepWood.wav");
	protected static SoundClip carpetStep = new SoundClip("/sounds/stepCarpet.wav");
	protected String variant;
	protected String facing;
	
	public Environment()
	{
		
	}
	
	public static void playStep(String type)
	{
		woodStep.setVolume(6);
		carpetStep.setVolume(6);
		if(type == "W")
		{
			if(woodStep == null)
			{
				System.out.println("[ERROR] footstep \\\"woodStep.wav\\\" Resource Not Available");
				return;
			}
			if(!woodStep.isRunning())
				woodStep.play();
		}
		if(type == "C")
		{
			if(carpetStep == null)
			{
				System.out.println("[ERROR] footstep \"carpetStep.wav\" Resource Not Available");
				return;
			}
			if(!carpetStep.isRunning())
			carpetStep.play();
		}
	}
	
	public Image getImage()
	{
		return this.img;
	}
	
	public int getWidth()
	{
		return this.width;
	}

	public int getHeight()
	{
		return this.height;
	}

	public int getY()
	{
		return this.y;
	}
	
	public int getX()
	{
		return this.x;
	}
	
	public void translatePosition(int xChange, int yChange)
	{
		this.x += xChange;
		this.y += yChange;
	}
	public String getVariant()
	{
		return this.variant;
	}
	
	public String getFacing()
	{
		return facing;
	}
	
	public static int getTileSize()
	{
		return tileSize;
	}
}
