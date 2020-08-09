package com.yarharharddrive;

public abstract class Weapon extends Item
{
	protected String name;
	protected int damage;
	protected int range;
	
	public Weapon(int xIn, int yIn, String nameIn)
	{
		super(xIn, yIn, nameIn);
	}
	
	public int getDamage()
	{
		return damage;
	}
	
	public String getName()
	{
		return name;
	}
	
	protected void setName(String newName)
	{
		name = newName;
	}
	
	protected void useWeapon()
	{
		this.durability -= 1;
	}
	
	
}
