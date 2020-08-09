package com.yarharharddrive.game;

import java.util.Scanner;

import com.sun.glass.events.KeyEvent;
import com.yarharharddrive.Entity;
import com.yarharharddrive.Environment;
import com.yarharharddrive.engine.AbstractGame;
import com.yarharharddrive.engine.GameContainer;
import com.yarharharddrive.engine.Renderer;
import com.yarharharddrive.entity.Bubbles;
import com.yarharharddrive.entity.Key;
import com.yarharharddrive.entity.Player;
import com.yarharharddrive.world.RoomCloset;
import com.yarharharddrive.world.RoomCross;
import com.yarharharddrive.world.RoomCult;
import com.yarharharddrive.world.RoomDiamond;
import com.yarharharddrive.world.RoomVerticle;
import com.yarharharddrive.world.components.Room;
import com.yarharharddrive.engine.gfx.*;
import com.yarharharddrive.engine.sfx.SoundClip;
public class MichaelJacksonGame extends AbstractGame
{
	private static Player player;
	private static Player braindead;
	private static Bubbles bubbles;
	private Entity[] enemies = new Entity[20];
	private Image image;
	private static Room[] rooms = new Room[45];
	private static Key[] keys = new Key[1];
	//private static Room room;
	private static int x = 0;
	private static int y = 0;
	private static int height;
	private static int width;
	private static SoundClip theme = new SoundClip("/sounds/tempTheme.wav");
	private static SoundClip loadTheme = new SoundClip("/sounds/loadTheme.wav");
	private static SoundClip changeRoom = new SoundClip("/sounds/changeRoom.wav");
	private static SoundClip collectKey = new SoundClip("/sounds/keyPickup.wav");
	private int gameResetCountdown;
	private static int keysToWin = 1;
	
	private static boolean playing = true;
	public MichaelJacksonGame()
	{
		//image = new Image("/player.png");
		theme.setVolume(1);
		loadTheme.setVolume(1);
		//theme.loop();
	}

	@Override
	public void update(GameContainer gc, float dt)
	{
		
		if(gc.getInput().isKey(KeyEvent.VK_B))			//ACTIVATE AT YOUR OWN RISK
		{
			if(theme.isRunning())
			{
				theme.stop();
			}
			else if(!theme.isRunning())
			{
				theme.loop();
			}
		}
		
		//System.out.println(checkCollision(player, braindead));
		
		/////////////////////
		// PLAYER MOVEMENT //
		/////////////////////
		
		if(!playing)
		{
			gameResetCountdown--;
			if(gameResetCountdown<0)
				try {
					gc.stop();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		
		if(playing)
		{
			
		for(int k = 0; k < rooms.length; k++) // Render Doors
		{
			if(rooms[k] != null)
			{
				for(int i = 0; i < rooms[k].getExits().length; i++)
				{
					if(rooms[k].getExits()[i] != null)
					{
						if(checkCollision(player, rooms[k].getExits()[i]) && player.getKeys() >= keysToWin && playing == true)
						{
							playing = false;
							gameResetCountdown = 660;
						}
					}
				}
			}
		}
		
		
		
		if(gc.getInput().isKeyDown(KeyEvent.VK_W) &&
				!gc.getInput().isKeyDown(KeyEvent.VK_A) &&
				!gc.getInput().isKeyDown(KeyEvent.VK_S) &&
				!gc.getInput().isKeyDown(KeyEvent.VK_D) &&
				player.getY() > 5)
		{
			player.walkN();
			for(int k = 0; k < rooms.length; k++)
			{
				if(rooms[k] != null)
				{
					for(int i = 0; i< rooms[k].getFloors().length; i++) 
					{
						for(int j = 0; j < rooms[k].getFloors()[i].length; j++)
						{
							if(checkCollision(player, rooms[k].getFloors()[i][j]))
							{
								Environment.playStep(rooms[k].getFloors()[i][j].getVariant());
							}
						}
					}
				}
			}
		}
		
		else if(gc.getInput().isKeyDown(KeyEvent.VK_A) &&
				!gc.getInput().isKeyDown(KeyEvent.VK_W) &&
				!gc.getInput().isKeyDown(KeyEvent.VK_S) &&
				!gc.getInput().isKeyDown(KeyEvent.VK_D) &&
				player.getX() > 5)
		{
			player.walkW();
			for(int k = 0; k < rooms.length; k++)
			{
				if(rooms[k] != null)
				{
					for(int i = 0; i< rooms[k].getFloors().length; i++) 
					{
						for(int j = 0; j < rooms[k].getFloors()[i].length; j++)
						{
							if(checkCollision(player, rooms[k].getFloors()[i][j]))
							{
								Environment.playStep(rooms[k].getFloors()[i][j].getVariant());
							}
						}
					}
				}
			}
		}
		else if(gc.getInput().isKeyDown(KeyEvent.VK_D) &&
				!gc.getInput().isKeyDown(KeyEvent.VK_W) &&
				!gc.getInput().isKeyDown(KeyEvent.VK_S) &&
				!gc.getInput().isKeyDown(KeyEvent.VK_A) &&
				player.getX() < 603)
		{
			player.walkE();
			for(int k = 0; k < rooms.length; k++)
			{
				if(rooms[k] != null)
				{
					for(int i = 0; i< rooms[k].getFloors().length; i++) 
					{
						for(int j = 0; j < rooms[k].getFloors()[i].length; j++)
						{
							if(checkCollision(player, rooms[k].getFloors()[i][j]))
							{
								Environment.playStep(rooms[k].getFloors()[i][j].getVariant());
							}
						}
					}
				}
			}
		}
		else if(gc.getInput().isKeyDown(KeyEvent.VK_S) &&
				!gc.getInput().isKeyDown(KeyEvent.VK_W) &&
				!gc.getInput().isKeyDown(KeyEvent.VK_A) &&
				!gc.getInput().isKeyDown(KeyEvent.VK_D) &&
				player.getY() < 443)
		{
			player.walkS();
			for(int k = 0; k < rooms.length; k++)
			{
				if(rooms[k] != null)
				{
					for(int i = 0; i< rooms[k].getFloors().length; i++) 
					{
						for(int j = 0; j < rooms[k].getFloors()[i].length; j++)
						{
							if(checkCollision(player, rooms[k].getFloors()[i][j]))
							{
								Environment.playStep(rooms[k].getFloors()[i][j].getVariant());
							}
						}
					}
				}
			}
		}
		bubbles.cooldown();
		if(bubbles.getSpawnStatus())
		{
			
			bubbles.findPlayerPath(player);
			bubbles.staminaCheck();
			if(checkCollision(player, bubbles) && bubbles.getCooldownStatus() <= 0)
			{
				player.takeDamage(bubbles.getDamage());
				System.out.println("[INFO] Player took " + bubbles.getDamage() + " damage");
			}
			//bubbles.damage(player)
		}
		for(int i = 0; i < keys.length; i++)
		{
			if(keys[i] != null)
			if(checkCollision(player, keys[i]))
			{
				keys[i] = null;
				player.collectKey();
				collectKey.play();
			}
		}
		
		for(int k = 0; k < rooms.length; k++)
		{
			if(rooms[k] != null)
			{
				for(int i = 0; i< rooms[k].getExits().length; i++) 
				{
					if(rooms[k].getExits()[i] != null)
					{
						if(checkCollision(player, rooms[k].getExits()[i]))
						{
							if((rooms[k].getExits()[i]).getFacing() == "N")
							{
								player.setY(414);
								changeRoom("N", rooms, true);
							}
							if((rooms[k].getExits()[i]).getFacing() == "S")
							{
								player.setY(47);
								changeRoom("S", rooms, true);
							}
							if((rooms[k].getExits()[i]).getFacing() == "E")
							{
								player.setX(47);
								changeRoom("E", rooms, true);
							}
							if((rooms[k].getExits()[i]).getFacing() == "W")
							{
								player.setX(593);
								changeRoom("W", rooms, true);
							}
						}
					}
				}
			}
		}
		
		}
		
		/*
		if(player.getX() > 620)
		{
			player.setX(20);
			changeRoom("E", rooms, true);
		}
		if(player.getX() < 10)
		{
			player.setX(600);
			changeRoom("W", rooms, true);
		}
		if(player.getY() > 460)
		{
			player.setY(20);
			changeRoom("S", rooms, true);
		}
		if(player.getY() < 10)
		{
			player.setY(420); //haha MLG 420 blazeit u friken noobs what is this line of code even fricketh you paytion
			changeRoom("N", rooms, true);
		}
		*/
		
		
	}

	@Override
	public void render(GameContainer gc, Renderer r)
	{
		//r.drawImage(image, x, y);
		
		//player.draw(r);
		for(int k = 0; k < rooms.length; k++) // Render Floors
		{
			if(rooms[k] != null)
			{
				for(int i = 0; i< rooms[k].getFloors().length; i++)
				{
					for(int j = 0; j < rooms[k].getFloors()[i].length; j++)
					{
					
						r.drawImage(rooms[k].getFloors()[i][j].getImage(), rooms[k].getFloors()[i][j].getX(), rooms[k].getFloors()[i][j].getY());
					}
				}
				
				for(int i = 0; i < rooms[k].getWalls().length; i++)
				{
					//r.drawImage(room.getWalls()[i].getImage(), room.getWalls()[i].getX(), room.getWalls()[i].getY());
					//System.out.println(room.getWalls()[i].getX());
				}
			}
		}
		for(int k = 0; k < rooms.length; k++) // Render Doors
		{
			if(rooms[k] != null)
			{
				for(int i = 0; i < rooms[k].getExits().length; i++)
				{
					if(rooms[k].getExits()[i] != null)
					{
						r.drawImage(rooms[k].getExits()[i].getImage(), rooms[k].getExits()[i].getX(), rooms[k].getExits()[i].getY());
						if(checkCollision(player, rooms[k].getExits()[i]) && player.getKeys() < keysToWin && playing)
						{
							r.drawText("You must collect all the keys to Free Michael Jackson...", 200, 250, 0xff00ffff);
						}
						else if(!playing)
						{
							r.drawText("You have Freed Michael Jackson!", 250, 250, 0xff00ffff);
							if(gameResetCountdown / 60 > 0)
							r.drawText("Resetting Window in:  " + gameResetCountdown / 60, 275, 260, 0xffffFF00);
						}
					}
				}
			}
		}
		
		for(int i = 0; i < keys.length; i++)
		{
			if(keys[i] != null)
			{
				r.drawImage(keys[i].getImage(), keys[i].getX(), keys[i].getY());
			}
		}
		
		//r.drawImage(braindead.getImage(), braindead.getX(), braindead.getY());
		r.drawImage(player.getImage(), player.getX(), player.getY());
		if(bubbles.getSpawnStatus())
			r.drawImage(bubbles.getImage(), bubbles.getX(), bubbles.getY());
		
		
		
	}
	
	public static void main(String[] args)
	{
		x = 0;
		y = 0;
		
		
		Scanner temp = new Scanner(System.in); // Delay Start of Game until Enter Pressed
		
		
		
		System.out.println("[INFO] Initializing Game");
		GameContainer gc = new GameContainer(new MichaelJacksonGame());
		loadTheme.loop();
		System.out.println("[INFO] Game Container Loaded");
		height = gc.getHeight();
		width = gc.getWidth();
		
		System.out.println("[INFO] Creating Entities");
		player = new Player(100);
		player.setX(300);
		player.setY(440);
		//braindead = new Player(1);
		bubbles = new Bubbles(1000, 0, 50);
		
		
		System.out.println("[INFO] Generating Rooms"); // Takes a few centuries to load, but it does
		
		rooms[0] = new RoomCult(0 * width, 0 * height);
		System.out.println("[INFO] Room 01 Successfully Created");
		
		rooms[1] = new RoomVerticle(1 * width, 0 * height);
		System.out.println("[INFO] Room 02 Successfully Created");
		
		rooms[2] = new RoomCloset(2 * width, 0 * height);
		System.out.println("[INFO] Room 03 Successfully Created");
		
		rooms[5] = new RoomDiamond(0 * width, 1 * height);
		System.out.println("[INFO] Room 06 Successfully Created");
		
		rooms[6] = new RoomVerticle(1 * width, 1 * height);
		System.out.println("[INFO] Room 07 Successfully Created");
		
		rooms[7] = new RoomVerticle(2 * width, 1 * height);
		System.out.println("[INFO] Room 08 Successfully Created");
		
		rooms[12] = new RoomCross(2 * width, 2 * height);
		System.out.println("[INFO] Room 13 Successfully Created");
		
		rooms[13] = new RoomVerticle(3 * width, 2 * height);
		System.out.println("[INFO] Room 14 Successfully Created");
		
		rooms[14] = new RoomVerticle(4 * width, 2 * height);
		System.out.println("[INFO] Room 15 Successfully Created");
		
		rooms[15] = new RoomVerticle(0 * width, 3 * height);
		System.out.println("[INFO] Room 16 Successfully Created");
		
		rooms[17] = new RoomCross(2 * width, 3 * height);
		System.out.println("[INFO] Room 18 Successfully Created");
		
		rooms[19] = new RoomVerticle(4 * width, 3 * height);
		System.out.println("[INFO] Room 20 Successfully Created");
		
		rooms[22] = new RoomVerticle(2 * width, 4 * height);
		System.out.println("[INFO] Room 23 Successfully Created");
		
		
		
		System.out.println("[INFO] Populating Entities");
		
		changeRoom("E", rooms, false);
		changeRoom("E", rooms, false);
		changeRoom("S", rooms, false);
		changeRoom("S", rooms, false);
		changeRoom("S", rooms, false);
		
		System.out.println("[INFO] Crafting Doors"); // Create Door Objects
		rooms[1].addDoor(9, 14, "S", "D", 0);
		
		rooms[2].addDoor(9, 14, "S", "D", 0);
		rooms[2].placeCloset(8, 0, 1); // THIS IS THE ONLY CLOSET
		
		rooms[6].addDoor(0, 14, "N", "D", 0);
		
		rooms[7].addDoor(9, 14, "S", "D", 0);
		rooms[7].addDoor(9, 0, "N", "D", 1);
		
		rooms[12].addDoor(9, 14, "S", "D", 0);
		rooms[12].addDoor(9, 0, "N", "D", 1);
		
		rooms[17].addDoor(9, 14, "S", "D", 0);
		rooms[17].addDoor(9, 0, "N", "D", 1);
		rooms[17].addDoor(0, 6, "W", "D", 2);
		rooms[17].addDoor(19, 6, "E", "D", 3);
		
		rooms[22].addDoor(9, 0, "N", "D", 0);		
		
		System.out.println("[INFO] \"Hiding\" the Keys");
		keys[0] = new Key(10, 7, rooms[17].getRoomX(), rooms[17].getRoomY());
		
		System.out.println("[INFO] Initialized Game");
		
		System.out.println("Press Enter to Begin");//. Type anything and Press Enter to Quit");
		
		
		String in = temp.nextLine();
		temp.close();
		loadTheme.stop();
		
		changeRoom("S", rooms, true);
			gc.start();
		
	}
	

	public boolean checkCollision(Entity e1, Entity e2)
	{
		
		return e1.getX() > e2.getX() - e1.getWidth() &&
				e1.getX() < e2.getX() + e2.getWidth() &&
				e1.getY() > e2.getY() - e1.getHeight() &&
				e1.getY() < e2.getY() + e2.getHeight();
	}
	
	public boolean checkCollision(Entity e1, Environment e2)
	{
		
		return e1.getX() > e2.getX() - e1.getWidth() &&
				e1.getX() < e2.getX() + e2.getWidth() &&
				e1.getY() > e2.getY() - e1.getHeight() &&
				e1.getY() < e2.getY() + e2.getHeight();
	}
	
	/*
	 * def are_touching?(obj1, obj2) // Check Collision Source Code
    obj1.x > obj2.x - obj1.width and obj1.x < obj2.x + obj2.width and obj1.y > obj2.y - obj1.height and obj1.y < obj2.y + obj2.height
  end
	 */
	
	public static void changeRoom(String dir, Room[] rooms, boolean audio)
	{
		if(dir == "N")
			/*for(int i = 0; i <keys.length; i++)
			{
				if(keys[i] != null)
				{
					keys[i].translatePosition(0, 480);
					
				}
			}*/
		for(int k = 0; k < rooms.length; k++)
		{
			if(rooms[k] != null)
			{
				for(int i = 0; i< rooms[k].getFloors().length; i++) 
				{
					for(int j = 0; j < rooms[k].getFloors()[i].length; j++)
					{
					
						rooms[k].getFloors()[i][j].translatePosition(0, 480);
					}
				}
			
				for(int i = 0; i < rooms[k].getWalls().length; i++)
				{
					//r.drawImage(room.getWalls()[i].getImage(), room.getWalls()[i].getX(), room.getWalls()[i].getY());
					//System.out.println(room.getWalls()[i].getX());
				}
				for(int i = 0; i < rooms[k].getExits().length; i++)
				{
					if(rooms[k].getExits()[i] != null)
						rooms[k].getExits()[i].translatePosition(0, 480);
				}
			rooms[k].translatePosition(0,  480);
			}
		}
		if(dir == "S")
			/*for(int i = 0; i <keys.length; i++)
			{
				if(keys[i] != null)
				{
					keys[i].translatePosition(0, -480);
					System.out.println("Yeet");
				}
			}*/
			for(int k = 0; k < rooms.length; k++)
			{
				if(rooms[k] != null)
				{
				for(int i = 0; i< rooms[k].getFloors().length; i++) 
				{
					for(int j = 0; j < rooms[k].getFloors()[i].length; j++)
					{
						
						rooms[k].getFloors()[i][j].translatePosition(0, -480);;
					}
				}
				
				for(int i = 0; i < rooms[k].getWalls().length; i++)
				{
					//r.drawImage(room.getWalls()[i].getImage(), room.getWalls()[i].getX(), room.getWalls()[i].getY());
					//System.out.println(room.getWalls()[i].getX());
				}
				for(int i = 0; i < rooms[k].getExits().length; i++)
				{
					if(rooms[k].getExits()[i] != null)
						rooms[k].getExits()[i].translatePosition(0, -480);
				}
				rooms[k].translatePosition(0,  -480);
				}
			}
		if(dir == "E")
			/*for(int i = 0; i <keys.length; i++)
			{
				if(keys[i] != null)
				{
					keys[i].translatePosition(-640, 0);
				}
			}*/
			
			for(int k = 0; k < rooms.length; k++)
			{
				if(rooms[k] != null)
				{
					for(int i = 0; i< rooms[k].getFloors().length; i++) 
					{
						for(int j = 0; j < rooms[k].getFloors()[i].length; j++)
						{
						
							rooms[k].getFloors()[i][j].translatePosition(-640, 0);;
						}
					}
				
					for(int i = 0; i < rooms[k].getWalls().length; i++)
					{
						//r.drawImage(room.getWalls()[i].getImage(), room.getWalls()[i].getX(), room.getWalls()[i].getY());
						//System.out.println(room.getWalls()[i].getX());
					}
					
					for(int i = 0; i < rooms[k].getExits().length; i++)
					{
						if(rooms[k].getExits()[i] != null)
							rooms[k].getExits()[i].translatePosition(-640,  0);
					}
				rooms[k].translatePosition(-640,  0);
				}
			}
		if(dir == "W")
			/*for(int i = 0; i <keys.length; i++)
			{
				if(keys[i] != null)
				{
					keys[i].translatePosition(640, 0);
				}
			}*/
			for(int k = 0; k < rooms.length; k++)
			{
				if(rooms[k] != null)
				{
				for(int i = 0; i< rooms[k].getFloors().length; i++) 
				{
					for(int j = 0; j < rooms[k].getFloors()[i].length; j++)
					{
						
						rooms[k].getFloors()[i][j].translatePosition(640, 0);;
					}
				}
				
				for(int i = 0; i < rooms[k].getWalls().length; i++)
				{
					//r.drawImage(room.getWalls()[i].getImage(), room.getWalls()[i].getX(), room.getWalls()[i].getY());
					//System.out.println(room.getWalls()[i].getX());
				}
				for(int i = 0; i < rooms[k].getExits().length; i++)
				{
					if(rooms[k].getExits()[i] != null)
						rooms[k].getExits()[i].translatePosition(640,  0);
				}
				rooms[k].translatePosition(640,  0);
				}
			}
		if(audio == true)
		{
			changeRoom.play();
			System.out.println("[INFO] Player Entered New Room");
		}
		
		if(Math.random() > 0.65)
			bubbles.resetStamina(500);
	}

}
