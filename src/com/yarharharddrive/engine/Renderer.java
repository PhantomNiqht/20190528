package com.yarharharddrive.engine;

import java.awt.image.DataBufferInt;

import com.yarharharddrive.engine.gfx.Font;
import com.yarharharddrive.engine.gfx.Image;

public class Renderer
{
	private int pxW, pxH;
	private int[] px;
	
	private Font font = Font.STANDARD;
	
	public Renderer(GameContainer gc)
	{
		pxW = gc.getWidth();
		pxH = gc.getHeight();
		px = ((DataBufferInt)gc.getWindow().getImage().getRaster().getDataBuffer()).getData();
	}
	
	public void clear()
	{
		for(int i = 0; i < px.length; i++)
		{
			px[i] = 555;
		}
	}
	
	public void setPixel(int x, int y, int value)
	{
 		if((x < 0 || x >= pxW || y < 0 || y >= pxH) || value == 0xffff00ff)
 		{
 		return;	
 		}
 		
 		px[x + y * pxW] = value;
 		
	}
	
	public void drawText(String text, int offX, int offY, int color)
	{
		Image fontImage = font.getFontImage();
		
		text = text.toUpperCase();
		int offset = 0;
		
		for(int i = 0; i < text.length(); i++)
		{
			int unicode = text.codePointAt(i) - 32;
			
			for(int y = 0; y < fontImage.getH(); y++)
			{
				for(int x = 0; x < font.getWidths()[unicode]; x++)
				{
					if(font.getFontImage().getP()[(x + font.getOffset()[unicode]) + y * font.getFontImage().getW()] == 0xffffffff)
					{
						setPixel(x + offX + offset, y + offY, color);
					}
				}
			}
			
			offset += font.getWidths()[unicode];
		}
	}
	
	public void drawImage(Image image, int offX, int offY ) 
	{
		for(int y = 0; y < image.getH(); y++) 
		{
			for(int x = 0; x < image.getW(); x++)
			{
				setPixel(x + offX, y + offY, image.getP()[ x + y * image.getW()]);
			}
		}
	}
	
}
