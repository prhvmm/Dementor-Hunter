import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;


public class Wand  {

	private int x;
	private int y;
	private int xSpeed;
	private int ySpeed;
	private int Width;
	private int Height;
	public Wand(int x,int y,int Width,int Height) {
		// TODO Auto-generated constructor stub
		super();
		this.x=x;
		this.y=y;
		this.xSpeed=15;
		this.ySpeed=15;
		this.Width=Width;
		this.Height=Height;
	}
	
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		
		
		URL url = getClass().getClassLoader().getResource("images/wand.png");
		ImageIcon icon = new ImageIcon(url);
		Image wand = icon.getImage();
		g.drawImage(wand, x, y-Height, Width, Height, null);
	}

	public void moveLeft()
	{
		
		
		if(x>-130)
		{
			xSpeed = -10;
			x += xSpeed;
		}
		else
			x=-130;
	}
	public void moveRight(int gameWidth)
	{
		if (x +Width < gameWidth+135) {
			
			xSpeed = 10;
			x += xSpeed;
		} else
			x = gameWidth -150;
	}
	
//	public void moveUp(int gameHeight)
//	{
//		if(y-200!=0)
//		{
//			y-=ySpeed;
//		}
//	}
//	public void moveDown(int gameHeight)
//	{
//		if(y!=gameHeight)
//		{
//			y+=ySpeed;
//		}
//	}
	public int getGunPositionX()
	{
		return(x);
	}
	public int getGunPositionY()
	{
		return(y-Height);
	}
	
}


