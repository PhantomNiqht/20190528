package com.yarharharddrive;

import com.yarharharddrive.engine.GameContainer;
import com.yarharharddrive.engine.Renderer;
import com.yarharharddrive.engine.gfx.Image;

public class Entity
{
	protected double walkSpeed;
	private int hp;
	protected int x;
	protected int y;
	protected int width;
	protected int height;
	private String name;
	protected int pathCooldown;
	protected int targX;
	protected int targY;
	protected Image img;
	protected int dmg;
	
	
	public Entity()
	{
		x = 0;
		y = 0;
		pathCooldown = 0;
		targX = 0;
		targY = 0;
	}
	
	public Image getImage()
	{
		return this.img;
	}
	
	public void walkN()
	{
		y -= this.walkSpeed;
	}
	
	public void walkE()
	{
		x += this.walkSpeed;
	}
	
	public void walkS()
	{
		y += this.walkSpeed;
	}
	public void walkW()
	{
		x -= this.walkSpeed;
	}
	
	public void setX(int in)
	{
		x = in;
	}
	
	public int getX()
	{
		return this.x;
	}
	
	public int getWidth()
	{
		return this.width;
	}
	
	public int getHeight()
	{
		return this.height;
	}
	
	public void setY(int in)
	{
		y = in;
	}
	
	public int getY()
	{
		return this.y;
	}
	
	public void changeHP(int value)
	{
		hp += value;
	}
	
	public int getAttack()
	{
		return this.dmg;
	}
	
}
