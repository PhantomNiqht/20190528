package com.yarharharddrive;

public abstract class Item {
	protected String name;
	protected int x;
	protected int y;
	protected int durability; //depends on item
	
	public Item(int xIn, int yIn, String nameIn)
	{
		this.x = xIn;
		this.y = yIn;
		this.name = nameIn;
	}
	
	public void setDurability(String type, int newDura)
	{
		if(type == "c")
		{
			this.durability += newDura;
		}
		else if(type == "s")
		{
			this.durability = newDura;
		}
	}
	
	public int getDurability()
	{
		return this.durability;
	}
	
	public int limit; //carry limit for that type of item
	
	protected String identifier;
	
	public void translatePosition(int xChange, int yChange)
	{
		this.x += xChange;
		this.y += yChange;
	}
}
