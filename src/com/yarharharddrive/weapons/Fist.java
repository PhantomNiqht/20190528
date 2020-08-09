package com.yarharharddrive.weapons;

import com.yarharharddrive.Weapon;

public class Fist extends Weapon
{
	private int durability;
	private int dmg;
	
	public Fist(int xIn, int yIn)
	{
		super(xIn, yIn, "Fist");
		this.dmg = 1;
		this.durability = -1;
	}
}
