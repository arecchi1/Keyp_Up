package GameState;

import TileMap.Background;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.*;

public class PlayState extends GameState {
	
	Random random = new Random ();
	private int generator = 0;
	private char display = ' ';
	private static Timer timer;
	private int interval = 5;
	private int intervalLoss = 0;
	public static int score = 0;
	private int initializer = 0;
	private int challengeUp = 0;
	
	//private Image image = Toolkit.getDefaultToolkit().getImage("DosMoves1.png");
	
	private Background bg;
	
	public PlayState (GameStateManager gsm) {
		
		this.gsm = gsm;
		
		try {
			
			bg = new Background ("/Resources/menubg.gif", 1);
			bg.setVector (0, 0); //background menu scrolling speed
			
		}
		catch (Exception e) {
			e.printStackTrace ();
		}			
	}
	
	public void init () {}
	public void update () {
		bg.update ();
	}
	public void draw (Graphics2D g) {
		
		//draw background
		bg.draw (g);
		
		//draw title
		g.setColor (Color.MAGENTA);
		g.setFont (MenuState.titleFont);
		g.drawString ("PRESS", 125, 70);
		
		g.setColor(Color.RED);	
		g.drawString ("" + display, 155, 120);
		
		g.setColor (Color.BLUE);
		g.drawString ("Time:", 215, 25);
		g.drawString ("Score:", 5, 25);
		
		g.setColor (Color.YELLOW);
		g.drawString ("" + interval, 290, 25);
		
		g.setColor (Color.ORANGE);
		g.drawString ("" + score, 95, 25);
					
	}
	
	public void timer () {
		generator = random.nextInt ((90 - 65) + 1) + 65;
		display = (char) generator;
		timer = new Timer ();
		timer.scheduleAtFixedRate (new TimerTask () {
			public void run () {
				setInterval ();
			}
		}
		, 1000, 1000);
	}
	
	public int setInterval () {
		if (interval == 0)
			GameStateManager.currentState = 2;
		return--interval;
	}
	
	public void keyPressed (int k) {
		if (initializer == 1) {
			if (k == generator) {
				timer.cancel ();
				interval = 5 - intervalLoss;
				score++;
				challengeUp++;
				if (challengeUp % 5 == 0) {
					if (intervalLoss != 5)
						intervalLoss++;
				}
				timer ();
			}
			else {
				timer.cancel ();
				interval = 5;
				intervalLoss = 0;
				challengeUp = 0;
				initializer = 0;
				display = ' ';
				GameStateManager.currentState = 2;
			}
		}
		
		else {
			if (k == KeyEvent.VK_ENTER || k == KeyEvent.VK_SPACE) {
				initializer++;
				timer ();
			}
		}
	}
	public void keyReleased (int k) {}
	
}
