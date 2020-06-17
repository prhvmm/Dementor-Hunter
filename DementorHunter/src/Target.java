import java.awt.Color;
import java.awt.Graphics;

public class Target {

	private int x;
	private int y;
	private int width;
	private int height;
	private int xSpeed;
	private int ySpeed;
	public Target(int x,int y,int width,int height) {
		super();
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		this.xSpeed=5;
		this.ySpeed=5;
		
	}
	
	public void draw(Graphics g)
	{
		g.setColor(Color.BLACK);

			g.drawOval(x, y-300, width, height);
			g.drawLine(x+width/2, y-300, x+width/2, y-300+height);
			g.drawLine(x, y-300+height/2, x+width, y-300+height/2);
			
			
			
		
	}
	
	public void moveLeft()
	{
	
		
		if(x>0)
		{
			xSpeed = -5;
			x += xSpeed;
		}
		else
			x=0;
	}
	public void moveRight(int gameWidth)
	{
		if (x + width < gameWidth) {
			xSpeed = 5;
			x += xSpeed;
		} else
			x = gameWidth - 30;
	}
	public void moveUp()
	{
		if(y-300!=0)
		{
			y-=ySpeed;
		}
	}
	public void moveDown(int gameHeight)
	{
		if(y!=gameHeight-100)
		{
			
			y+=ySpeed;
		}
	}
}
