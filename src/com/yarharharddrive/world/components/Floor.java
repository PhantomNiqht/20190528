package com.yarharharddrive.world.components;

import com.yarharharddrive.Environment;
import com.yarharharddrive.engine.gfx.Image;
import com.yarharharddrive.engine.sfx.SoundClip;

public class Floor extends Environment
{
	
	public Floor(String variantIn, int xIn, int yIn)
	{
		this.variant = variantIn;
		this.width = this.tileSize;
		this.height = this.tileSize;
		if(this.variant == "C")
		{
			this.img = new Image("/world/carpet-1.png.png");
		}
		else if(this.variant == "W")
		{
			this.img = new Image("/world/woodTile.png");
		}
		this.x = xIn;
		this.y = yIn;
	}
	
	
	
}
