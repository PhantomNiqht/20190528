package com.yarharharddrive.entity;
import com.yarharharddrive.Armor;
import com.yarharharddrive.Entity;
import com.yarharharddrive.engine.gfx.Image;

public class Bubbles extends Entity implements Pathfinder {
	int hp; // health
	int st; // stamina
	int a; // attack
	int attackCooldown;
	public Bubbles(int health, int stamina, int attack) { //Constructor for Bubbles
		this.hp = health;
		this.st = stamina;
		this.a = attack;
		this.img = new Image("/entity/bubbles.png");
		this.walkSpeed = 3;
		this.attackCooldown = 0;
	}/*
	public int damage(Player player) { //Calculates damage dealt to the player
		int damage = a * player.defense ;
		return damage;
	}*/
	public boolean staminaCheck()
	{ //Checks if Bubbles has stamina: return True or False
	if(st >= 0) {
		this.st--;
		
		calculateSpeed();
		
		return true;
	}
	else {
	return false;
		}
	}
	@Override
	public void findPlayerPath(Player p)
	{
		if(this.pathCooldown < 1)
		{
			this.targX = p.getX();
			this.targY = p.getY();
			this.pathCooldown = 5;
		}
		if(this.y > this.targY && Math.abs((this.y - this.targY)) > 6)
		{
			this.walkN();
		}
		else if(this.y < this.targY && Math.abs((this.y - this.targY)) > 6)
		{
			this.walkS();
		}
		else if(this.x < this.targX && Math.abs((this.x - this.targX)) > 6)
		{
			this.walkE();
		}
		else if(this.x > this.targX && Math.abs((this.x - this.targX)) > 6)
		{
			this.walkW();
		}
		this.pathCooldown--;
	}
	
	public boolean getSpawnStatus()
	{
		return this.st > 0;
	}
	
	public int getDamage()
	{
		this.attackCooldown += 180;
		
		return (int) ((this.a * Math.random() * 1.5)) + 2;
	}
	
	public int getCooldownStatus()
	{
		return this.attackCooldown;
	}
	
	public void cooldown()
	{
		this.attackCooldown--;
	}
	
	public void calculateSpeed()
	{
		if(this.st > 0 && 50 > this.st)
		{
			walkSpeed = 2.1;
		}
		else if(this.st > 50 && 100 > this.st)
		{
			walkSpeed = 2.5;
		}
		else if(this.st > 100 && 150 > this.st)
		{
			walkSpeed = 2.7;
		}
		else if(this.st > 150 && 200 > this.st)
		{
			walkSpeed = 2.9;
		}
		else if(this.st > 200)
		{
			walkSpeed = 3;
		}
	}
	
	public void resetStamina(int in)
	{
		this.st = in;
	}

/* Bubbles
 * Random chance to spawn in the same room as the player | UPDATE | Has a spawnrate, but is not used yet
 * Attacks the player| UPDATE | Can deal damage, but does not directly attack the player yet
 * Player can attack Bubbles to reduce Bubbles stamina
 * Bubbles will drop a random rare item
 * get player x and y and attempt to walk towards it
 */
}
