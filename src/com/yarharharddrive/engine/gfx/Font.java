package com.yarharharddrive.engine.gfx;

public class Font
{
	public static final Font STANDARD = new Font("/fonts/basicFont.png");
	
	private Image fontImage;
	private int[] offset;
	private int[] widths;
	
	public Font(String path)
	{
		fontImage = new Image(path);
		
		offset = new int[59];
		widths = new int[59];
		
		int unicode = 0;
		
		for(int i = 0; i < fontImage.getW(); i++)
		{
			if(fontImage.getP()[i] == 0xff0000ff)
			{
				offset[unicode] = i;
			}
			if(fontImage.getP()[i] == 0xffffff00)
			{
				widths[unicode] = i - offset[unicode];
				unicode++;
			}
		}
	}
	
	public Image getFontImage()
	{
		return this.fontImage;
	}
	
	public int[] getWidths()
	{
		return widths;
	}
	
	public int[] getOffset()
	{
		return offset;
	}
}
