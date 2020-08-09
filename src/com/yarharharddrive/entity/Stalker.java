package com.yarharharddrive.entity;

import com.yarharharddrive.Armor;
import com.yarharharddrive.Entity;

public class Stalker extends Entity
{
	int hp; // health
	int a; // attack
	double sr; // spawnrate
	public Stalker(int health, int attack, double spawnRate) { //Constructor for Bubbles
		this.hp = health;
		this.a = attack;
		this.sr = spawnRate;
	}
	public int damage(Armor player) { //Calculates damage dealt to the player
		int damage = a * player.defense ;
		return damage;
	}
}
