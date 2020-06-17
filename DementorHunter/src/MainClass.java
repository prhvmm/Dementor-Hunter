import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.print.DocFlavor.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


import java.io.*;
import javax.sound.sampled.*;
import javax.swing.*;
public class MainClass  {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		JFrame frame = new JFrame("Game Project");
		String userInput = JOptionPane.showInputDialog(frame,"Enter your name");
		
		
		
	   

		
		if(userInput!=null)
		{
			Game game = new Game(userInput);
		
		
		//setLayout(new BorderLayout());


		game.setPreferredSize(new Dimension(Game.WIDTH, Game.HEIGHT));
		frame.add(game);		
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		Menu menu = new Menu(frame,game);
		menu.render();
		frame.setVisible(true);
		}

		
	}

}
