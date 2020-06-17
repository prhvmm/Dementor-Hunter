import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Shot  {

	private int x;
	private int y;
	private int ySpeed;
	int width;
	int height;
	Random rnd = new Random();

	public Shot(int x, int y,int width,int height)  {
		// TODO Auto-generated constructor stub
		super();
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		this.ySpeed=-35;
		
		
	}
	
	
	
		public void draw(Graphics g)
		{
			
			URL url = getClass().getClassLoader().getResource("images/shot.png");
			ImageIcon icon = new ImageIcon(url);
			Image shot = icon.getImage();
			g.drawImage(shot, x, y, width, height, null);
			
		}
		
		public Rectangle getBound()
		{
			Rectangle shotRect = new Rectangle(x, y, width, height);
			return shotRect;
		}
		
		public void moveUp()
		{
			y+=ySpeed;
		}
	
	


	
	

}

