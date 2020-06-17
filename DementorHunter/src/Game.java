import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

import javax.print.attribute.standard.Media;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Game extends JPanel implements ActionListener, KeyListener {

	Random rnd = new Random();
	JPanel btnPanel = new JPanel();
	Game game;
	Wand gun;
	Timer timer;
	Shot shot;
	Dementors bird;
	private boolean level1;
	private boolean level2;
	private boolean level3;
	private boolean easy;
	private boolean normal;
	private boolean hard;
	private int indexOfBird;
	private int indexOfShot;
	private int level;
	private String name;
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	private ArrayList<Dementors> Birds;
	private ArrayList<Shot> Shot;
	public Component obj;
	int score;
	private int remainingShots;
	private boolean play;
	private int difficulty;
	private int ScorePanelHEIGHT;
	private int gunHeight;
	private int gunWidth;

	public Game(String name) {
		super();
		timer = new Timer(40, this);
		timer.start();
		this.addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(true);
		this.ScorePanelHEIGHT=100;
		this.level=1;
		this.indexOfBird = -1;
		this.indexOfShot = -1;
		play = true;
		this.difficulty=3;
		this.remainingShots = 15;
		this.score = 0;
		this.name = name;
		this.level1 = true;
		this.level2 = false;
		this.level3 = false;
		this.easy=false;
		this.normal=false;
		this.hard=false;
		this.gunHeight=140;
		this.gunWidth=300;
		gun = new Wand(WIDTH / 2 -(gunWidth/2), HEIGHT, gunWidth, gunHeight);
		Shot = new ArrayList<Shot>();
		Birds = new ArrayList<Dementors>();
		Birds.add(new Dementors(rnd.nextInt(WIDTH - 100), rnd.nextInt(10) + 25+ScorePanelHEIGHT, 100, 70, WIDTH, HEIGHT));
		Birds.add(new Dementors(rnd.nextInt(WIDTH - 100), rnd.nextInt(35) + 35+ScorePanelHEIGHT, 100, 70, WIDTH, HEIGHT));
		Birds.add(new Dementors(rnd.nextInt(WIDTH - 100), rnd.nextInt(70) + 75+ScorePanelHEIGHT, 100, 70, WIDTH, HEIGHT));
		
		try {
	         // Open an audio input stream.           
	          File soundFile = new File("E:\\Downloads\\hp.wav"); //you could also get the sound file with an URL
	          AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);              
	         // Get a sound clip resource.
	         Clip clip = AudioSystem.getClip();
	         // Open audio clip and load samples from the audio input stream.
	         clip.open(audioIn);
	         clip.start();
	      } catch (UnsupportedAudioFileException e) {
	         e.printStackTrace();
	      } catch (IOException e) {
	         e.printStackTrace();
	      } catch (LineUnavailableException e) {
	         e.printStackTrace();
	      }
		
		
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		
		//setBackground(Color.MAGENTA);
		if(level1==true) {
			
		
				URL url = getClass().getClassLoader().getResource("images/hogwarts.jpg");
				ImageIcon icon = new ImageIcon(url);
				Image backGround = icon.getImage();
				g.drawImage(backGround, 0, ScorePanelHEIGHT, WIDTH, HEIGHT, null);
		}
		if(level2==true) {
			
			
			URL url = getClass().getClassLoader().getResource("images/hogwarts2.jpg");
			ImageIcon icon = new ImageIcon(url);
			Image backGround = icon.getImage();
			g.drawImage(backGround, 0, ScorePanelHEIGHT, WIDTH, HEIGHT, null);
	}
		if(level3==true) {
			
			
			URL url = getClass().getClassLoader().getResource("images/azkaban.jpg");
			ImageIcon icon = new ImageIcon(url);
			Image backGround = icon.getImage();
			g.drawImage(backGround, 0, ScorePanelHEIGHT, WIDTH, HEIGHT, null);
	}
		
		// Score Panel
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, ScorePanelHEIGHT);
		
		g.setColor(Color.WHITE);
		g.drawRect(5, 5 , WIDTH-10, 90);
		
		g.setColor(Color.YELLOW);
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD + Font.ITALIC, 16));
		g.drawString("Dementor Hunter", 10, 30);
		
		g.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 12));
		g.drawString("Remaining Shots : " + remainingShots + " ---------" + " Score : " + score + " Name: " + name+" Level: "+level, 10,
				60);
		
		gun.draw(g);

		for (Dementors Birds : Birds)
			Birds.draw(g);

		for (Shot Shot : Shot)
			Shot.draw(g);

		if (remainingShots == 0)// Game Over
		{
			play = false;
			g.setColor(Color.RED);
			g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));

			g.drawString("Game Over", WIDTH / 2 - 30, HEIGHT / 2);
			g.drawString("Please press CONTROL to restart the game", WIDTH / 2 - 120, HEIGHT / 2 + 20);

			Shot.clear();
			Birds.clear();
		}
		if (score == 7 && level1 == true)// Level 1 victory
		{
			play = false;
			g.setColor(Color.BLACK);
			g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));

			g.drawString("Brilliant...You have won!", WIDTH / 2 - 60, HEIGHT / 2);
			g.drawString("Please press ENTER to go to the next level", WIDTH / 2 - 120, HEIGHT / 2 + 20);

			Shot.clear();
			Birds.clear();
		}
		if (score == 13 && level2 == true)// Level 2 victory
		{
			play = false;
			g.setColor(Color.BLACK);
			g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));

			g.drawString("Brilliant...You have won!", WIDTH / 2 - 60, HEIGHT / 2);
			g.drawString("Please press ENTER to go to the next level", WIDTH / 2 - 120, HEIGHT / 2 + 20);

			Shot.clear();
			Birds.clear();
		}if (score == 16 && level3 == true)// Level 3 victory
		{
			play = false;
			g.setColor(Color.WHITE);
			g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));

			g.drawString("You have won the game!", WIDTH / 2 - 60, HEIGHT / 2);
			g.drawString("Please press CONTROL to restart the game", WIDTH / 2 - 120, HEIGHT / 2 + 20);

			Shot.clear();
			Birds.clear();
		}
		
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		
		if (play == true) {
			for (Dementors Birds : Birds) {
				Birds.move();
				Birds.moveStone();
			}
			for (Shot Shots : Shot) {
				Shots.moveUp();

			}
			repaint();
		}

		for (Dementors birds : Birds) {
			for (Shot shots : Shot) {
				if (birds.getBirdBound().intersects(shots.getBound())) {
					indexOfBird = Birds.indexOf(birds);
					indexOfShot = Shot.indexOf(shots);
					score++;
				}

			}
		}
		for (Dementors birds : Birds) {
			for (Shot shots : Shot) {
				if (birds.getStoneBound().intersects(shots.getBound())) {
					birds.resetStone();
					indexOfShot = Shot.indexOf(shots);
				}

			}
		}
		if (indexOfShot != -1) {
			Shot.remove(indexOfShot);
			indexOfShot = -1;

		}
		if (indexOfBird != -1) {
			Birds.remove(indexOfBird);
			indexOfBird = -1;
			Birds.add(new Dementors(rnd.nextInt(WIDTH - 100), rnd.nextInt(35) + 35+ScorePanelHEIGHT, 100, 70, WIDTH, HEIGHT));
		}
		
		for (Dementors Birds : Birds) {
			if(Birds.isBottom()==true&&score>0)
			{
				
				score--;
			}
		}
		
		


		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT && play == true) {
			gun.moveLeft();
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT && play == true) {
			gun.moveRight(WIDTH);
		}
		

		if (e.getKeyCode() == KeyEvent.VK_SPACE && play == true) {
			remainingShots -= 1;
			
			Shot.add(new Shot(gun.getGunPositionX() + gunWidth/2 -15, gun.getGunPositionY() , 20, 20));

			for (Shot Shot : Shot) {
				Shot.draw(getGraphics());
			}

		}
		if (e.getKeyCode() == KeyEvent.VK_CONTROL && play == false) {
			restart();
		}
		if (e.getKeyCode() == KeyEvent.VK_ENTER && play == false) {
			if (level1 == true && level2 == false) {
				level1 = false;
				level2 = true;
				level2();
			} else if (level2 == true && level3 == false) {
				level2 = false;
				level3 = true;
				level3();
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void restart() {
		Shot.clear();
		Birds.clear();
		play = true;
		level1=true;
		level2=false;
		level3=false;
		level=1;
		remainingShots = 18-difficulty;
		score = 0;
		resetShapes();
		repaint();
		
	}
	public void level2() {
		play = true;
		level=2;
		remainingShots = 23-difficulty;
		score = 0;
		resetShapes();
		repaint();
	}
	public void level3() {
		play = true;
		level=3;
		remainingShots = 28-difficulty;
		score = 0;
		resetShapes();
		repaint();
	}
	
	
	public void pause()
	{
		play=false;
	}
	public void Resume()
	{
		play=true;
	}
	public void easy()
	{
		difficulty=-3;
	}
	public void normal()
	{
		difficulty=3;

	}
	public void hard()
	{
		difficulty=8;

	}
	
	public void resetShapes()
	
	{
		gun = new Wand(WIDTH / 2 -(gunWidth/2), HEIGHT, gunWidth, gunHeight);
		Birds.add(new Dementors(rnd.nextInt(WIDTH - 100), rnd.nextInt(10) + 25+ScorePanelHEIGHT, 100, 70, WIDTH, HEIGHT));
		Birds.add(new Dementors(rnd.nextInt(WIDTH - 100), rnd.nextInt(35) + 35+ScorePanelHEIGHT, 100, 70, WIDTH, HEIGHT));
		Birds.add(new Dementors(rnd.nextInt(WIDTH - 100), rnd.nextInt(70) + 75+ScorePanelHEIGHT, 100, 70, WIDTH, HEIGHT));

	}

	
}
