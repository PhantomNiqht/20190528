package com.yarharharddrive.world;

import com.yarharharddrive.Environment;
import com.yarharharddrive.world.components.Floor;
import com.yarharharddrive.world.components.Room;

public class RoomCross extends Room
{
	public RoomCross(int xIn, int yIn)
	{
		super(xIn, yIn);
		roomFloors = new Environment[20][15];
		roomWalls = new Environment[64];
		roomExits = new Environment[5];
		
		// Draw Floor Tiles
		for(int i = 0; i < roomFloors.length; i++)
		{
			for(int j = 0; j < roomFloors[i].length; j++)
			{
				if(i < 9 && j < 6 || i > 10 && j > 8 || i < 9 && j > 8 || i > 10 && j < 6)
					roomFloors[i][j] = new Floor("W", this.roomX + i * tileSize, this.roomY + j * tileSize);
				else
					roomFloors[i][j] = new Floor("C", this.roomX + i * tileSize, this.roomY + j * tileSize);
			}
		}
	/*	for(int i = 0; i < 12; i++)
		{
			roomWalls[i] = new Wall("H", i * tileSize, 0 * tileSize);
		}
		for(int i = 0; i < 16; i++)
		{
			roomWalls[i + 12] = new Wall("V", 0 * tileSize, i * tileSize);
		}
		
		for(int i = 0; i < 12; i++)
		{
			roomWalls[i + 28] = new Wall("H", i * tileSize, 17 * tileSize);
		}
		for(int i = 0; i < 16; i++)
		{
			roomWalls[i + 44] = new Wall("V", 13 * tileSize, i * tileSize);
		}
		roomWalls[60] = new Wall("C", 13 * tileSize, 0 * tileSize);
		roomWalls[61] = new Wall("C", 13 * tileSize, 17 * tileSize);
		roomWalls[62] = new Wall("C", 0 * tileSize, 17 * tileSize);
		roomWalls[63] = new Wall("C", 0 * tileSize, 0 * tileSize);
		//Room is 12 wide, 16 tall
		//5 wood, 2 carpet, 5 wood
		//
		*/
	}
}
