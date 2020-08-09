package com.yarharharddrive.entity;

import com.yarharharddrive.Entity;
import com.yarharharddrive.Item;
import com.yarharharddrive.engine.gfx.Image;
import com.yarharharddrive.world.components.Room;

public class Key extends Entity
{
	public Key(int xIn, int yIn, int roomXIn, int roomYIn)
	{
		super();
		this.x = xIn * Room.getTileSize() + roomXIn;
		this.y = yIn * Room.getTileSize() + roomYIn;
		this.width = 14;
		this.height = 7;
		this.img = new Image("/item/key.png");
	}
	
	public void translatePosition(int xChange, int yChange)
	{
		this.x += xChange;
		this.y += yChange;
	}
}
