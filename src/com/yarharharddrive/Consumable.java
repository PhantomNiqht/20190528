package com.yarharharddrive;

public class Consumable extends Item {
	
	public Consumable(int xIn, int yIn, String nameIn) {
		super(xIn, yIn, nameIn);
	}
	
	int db = 1; //Durability
	
	int cassette_time;
	
	int restore_dur;
}
