import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;

public class Dementors {

	Random rnd = new Random();
	private int x;
	private int y;
	private int gameWIDTH;
	private int gameHEIGHT;
	private int xSpeed;
	private int ySpeed;
	private int width;
	private int height;
	private int yStone;
	private int xStone;
	private int widthStone;
	private int heightStone;
	Game game;
	

	public Dementors(int x, int y,int width,int height,int gameWIDTH,int gameHEIGHT) {
		// TODO Auto-generated constructor stub
		super();
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		this.gameWIDTH=gameWIDTH;
		this.xSpeed=3;
		this.ySpeed=1;
		this.yStone=y+height;
		this.xStone=x+width/2-5;
		this.gameHEIGHT=gameHEIGHT;
		this.widthStone=50;
		this.heightStone=50;

	}
	
	public void draw(Graphics g)
	{
//		g.setColor(Color.BLACK);
//		g.fillOval(x, y, width, height);
//		g.setColor(Color.darkGray);
//		g.fillOval(xStone, yStone, widthStone, heightStone);
		
		
		URL DementorUrl = getClass().getClassLoader().getResource("images/dementor.png");
		ImageIcon DementorIcon = new ImageIcon(DementorUrl);
		Image dementor = DementorIcon.getImage();
		g.drawImage(dementor, x, y, width, height, null);
		
		URL FireUrl = getClass().getClassLoader().getResource("images/fire.png");
		ImageIcon FireIcon = new ImageIcon(FireUrl);
		Image fire = FireIcon.getImage();
		g.drawImage(fire, xStone, yStone, widthStone, heightStone, null);
	}
	
	public void move()
	{
		x+=xSpeed;
		
		if(x  >= gameWIDTH-width)
			xSpeed *= -1;
		
		if(x <= 0)
			xSpeed *= -1;
	}
	public void resetStone()
	{
		yStone=y+height;
		xStone=x+width/2-5;
	}
	public void moveStone()
	{
		yStone+=ySpeed;
		if(yStone>=gameHEIGHT)
		{
			yStone=y+height;
			xStone=x+width/2-5;
		}
		
		

	}
	public int getY()
	{
		return yStone;
	}
	public int getX()
	{
		return x;
	}
	
	
	public Rectangle getBirdBound(){
		Rectangle birdRect = new Rectangle(x, y, width, height);
		return birdRect;
	}
	public Rectangle getStoneBound(){
		Rectangle stoneRect = new Rectangle(xStone-1, yStone-1, widthStone+1, heightStone+1);
		return stoneRect;
	}
	public boolean isBottom()
	{
		if(yStone+heightStone==gameHEIGHT)
		{
			return true;
		}
		else
			return false;
	}

}
