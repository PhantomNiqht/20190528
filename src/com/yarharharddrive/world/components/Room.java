package com.yarharharddrive.world.components;

import com.yarharharddrive.Environment;

public class Room extends Environment
{
	protected int roomX;
	protected int roomY;
	
	protected Environment[][] roomFloors;
	protected Environment[] roomWalls;
	protected Environment[] roomExits;
	
	public Room(int xIn, int yIn)
	{
		this.roomX = xIn;
		this.roomY = yIn;
	}
	
	public Environment[][] getFloors() 
	{
		return this.roomFloors;
	}
	
	public Environment[] getWalls()
	{
		return this.roomWalls;
	}
	public Environment[] getExits()
	{
		return this.roomExits;
	}
	
	public void addDoor(int xIn, int yIn, String type, String exitType, int i)
	{
		if(exitType == "D")
		{
			roomExits[i] = new Door(type, xIn * this.tileSize + this.roomX, yIn * this.tileSize + this.roomY);
		}
		if(exitType == "S")
			roomExits[i] = new Stairs(type, xIn, yIn);
	}
	
	public void placeCloset(int xIn, int yIn, int i)
	{
		roomExits[i] = new Closet(xIn * this.tileSize + this.roomX, yIn * this.tileSize + this.roomY);
	}
	
	public int getRoomX()
	{
		return roomX;
	}
	
	public int getRoomY()
	{
		return roomY;
	}
	
	@Override
	public void translatePosition(int xChange, int yChange)
	{
		this.roomX += xChange;
		this.roomY += yChange;
	}
}
