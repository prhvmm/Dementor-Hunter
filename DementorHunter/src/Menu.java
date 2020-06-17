import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;


public class Menu {
	
	private JFrame frame;
	 private Game game;

	public Menu(JFrame frame,Game game) {
		this.frame = frame;
		this.game=game; 
	}
	
	public void render(){
		JMenuBar menuBar = new JMenuBar();
		
		JMenu file = new JMenu("File");
		
		JMenuItem restart = new JMenuItem("Restart");
		file.add(restart);
		restart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				game.restart();
			}
		});
		
		JMenuItem pause = new JMenuItem("Pause");
		file.add(pause);
		pause.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				game.pause();
			}
		});
		
		JMenuItem Continue = new JMenuItem("Resume");
		file.add(Continue);
		Continue.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				game.Resume();
			}
		});
		
		file.addSeparator();
		
		JMenuItem exit = new JMenuItem("Exit");
		file.add(exit);
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		menuBar.add(file);
		
		
		JMenu help = new JMenu("Help");
		JMenuItem about = new JMenuItem("About Us");
		about.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, "This is about us.");				
			}
		});
		help.add(about);
		
		menuBar.add(help);
		
JMenu difficulty = new JMenu("Difficulty");
		
		JMenuItem easy = new JMenuItem("Easy");
		difficulty.add(easy);
		easy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				game.easy();
				game.restart();
			}
		});
		JMenuItem normal = new JMenuItem("Normal");
		difficulty.add(normal);
		normal.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				game.normal();
				game.restart();
			}
		});
		JMenuItem hard = new JMenuItem("Hard");
		difficulty.add(hard);
		hard.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				game.hard();
				game.restart();
			}
		});
		
		menuBar.add(difficulty);
		
		frame.setJMenuBar(menuBar);
	}

}
