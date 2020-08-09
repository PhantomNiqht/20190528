package com.yarharharddrive.world;

import com.yarharharddrive.Environment;
import com.yarharharddrive.world.components.Floor;
import com.yarharharddrive.world.components.Room;

public class RoomCult extends Room
{
	public RoomCult(int xIn, int yIn)
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
				if(i == 9 || i == 10 || j == 6 || j == 7 || j == 8 || i == 8 && 4 < j && j < 10 || i == 11 && 4 < j && j < 10)
					roomFloors[i][j] = new Floor("C", this.roomX + i * tileSize, this.roomY + j * tileSize);
				else
					roomFloors[i][j] = new Floor("W", this.roomX + i * tileSize, this.roomY + j * tileSize);
			}
		}
		
		roomFloors[9][6] = new Floor("W", this.roomX + 9 * tileSize, this.roomY + 6 * tileSize);
		roomFloors[9][7] = new Floor("W", this.roomX + 9 * tileSize, this.roomY + 7 * tileSize);
		roomFloors[9][8] = new Floor("W", this.roomX + 9 * tileSize, this.roomY + 8 * tileSize);
		roomFloors[10][6] = new Floor("W", this.roomX + 10 * tileSize, this.roomY + 6 * tileSize);
		roomFloors[10][7] = new Floor("W", this.roomX + 10 * tileSize, this.roomY + 7 * tileSize);
		roomFloors[10][8] = new Floor("W", this.roomX + 10 * tileSize, this.roomY + 8 * tileSize);
		
		
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
