package com.yarharharddrive.entity;
import com.sun.glass.events.KeyEvent;
import com.yarharharddrive.Armor;
import com.yarharharddrive.Entity;
import com.yarharharddrive.Item;
import com.yarharharddrive.Weapon;
import com.yarharharddrive.armor.BaseArmor;
import com.yarharharddrive.engine.GameContainer;
import com.yarharharddrive.engine.Renderer;
import com.yarharharddrive.engine.gfx.Image;
import com.yarharharddrive.weapons.Fist;

public class Player extends Entity
{
	int hp; // health
	//int a; // attack
	Weapon weapon;
	Item[] inventory = new Item[5];
	int keyCount;
	Armor armor;
	public Player(int health) { //Constructor for Player
		super();
		this.hp = health;
		this.weapon = new Fist(this.x, this.y);
		this.img = new Image("/entity/playerBase.png");
		this.walkSpeed = 2;
		this.height = 32;
		this.width = 32;
		this.keyCount = 0;
		this.armor = new BaseArmor();
	}
	public int damage(Armor player) { //Calculates damage dealt by the player
		int damage = 1; //later add a weapon modifier
		return damage;
	}
	
	public void equipWeapon(Weapon newWeapon)
	{
		weapon = newWeapon;
	}
	
	public void equipWeapon()
	{
		weapon = new Fist(this.x, this.y);
	}
	
	public Weapon getWeapon()
	{
		return this.weapon;
	}
	
	public void equipArmor(String type)
	{
		this.armor = new Armor("");
	}
	
	public Armor getArmor()
	{
		return this.armor;
	}
	
	public int getKeys()
	{
		return this.keyCount;
	}
	
	public void collectKey()
	{
		this.keyCount++;
	}
	
	public int getDamage()
	{
		return this.weapon.getDamage() + 1;
	}
	
	public void takeDamage(int in)
	{
		this.hp -= ( in / armor.getNullifier() ) * 100;
	}
	
	
}
