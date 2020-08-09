package com.yarharharddrive.world.components;

import com.yarharharddrive.Environment;
import com.yarharharddrive.engine.gfx.Image;

public class Closet extends Environment
{
	public Closet(int xIn, int yIn)
	{
		this.x = xIn;
		this.y = yIn;
		this.width = this.tileSize * 4;
		this.height = this.tileSize * 2;
		this.img = new Image("/world/closet.png");
	}
}
