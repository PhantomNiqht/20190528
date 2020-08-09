package com.yarharharddrive.world.components;

import com.yarharharddrive.Environment;
import com.yarharharddrive.engine.gfx.Image;

public class Door extends Environment
{
	public Door(String dir, int xIn, int yIn)
	{
		this.x = xIn;
		this.y = yIn;
		this.facing = dir;
		if(dir == "N" || dir == "S")
		{
			this.width = this.tileSize * 2;
			this.height = this.tileSize * 1;
			this.img = new Image("/world/newDoor.png");
		}
		
		else if(dir == "W")
		{
			this.width = this.tileSize * 1;
			this.height = this.tileSize * 3;
			this.img = new Image("/world/newSideDoorL.png");
		}
		else if(dir == "E")
		{
			this.width = this.tileSize * 1;
			this.height = this.tileSize * 3;
			this.img = new Image("/world/newSideDoorR.png");
		}
	}
	
	@Override
	public int getX()
	{
		return this.x;
	}
	
	@Override
	public int getY()
	{
		return this.y;
	}
	
}
