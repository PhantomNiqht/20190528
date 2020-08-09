package com.yarharharddrive.world.components;

import com.yarharharddrive.Environment;
import com.yarharharddrive.engine.gfx.Image;

public class Wall extends Environment
{
	protected String variant;
	public Wall(String variantIn, int xIn, int yIn)
	{
		this.variant = variantIn;
		this.x = xIn;
		this.y = yIn;
		if(this.variant == "H")
		{
			this.x -= 1;
			this.img = new Image("/world/wallH.png");
		}
		else if(this.variant == "V")
		{
			this.y -= 1;
			this.img = new Image("/world/wallV.png");
		}
		else if(this.variant == "C")
		{
			this.y -= 1;
			this.x -= 1;
			this.img = new Image("/world/wallC.png");
		}
		
	}
}
