package GameState;

import TileMap.Background;

import java.awt.*;
import java.awt.event.KeyEvent;

public class MenuState extends GameState {
	
	private Background bg;
	
	private int currentChoice = 0;
	private String[] options = {
			"Start", "Help", "Quit"
	};
	
	public static Font titleFont;
	
	public static Font font;
	
	public MenuState (GameStateManager gsm) {
		
		this.gsm = gsm;
		
		try {
			
			bg = new Background ("/Resources/menubg2.gif", 1);
			bg.setVector (-1, 0); //background menu scrolling speed
			
			titleFont = new Font ("Century Gothic", Font.PLAIN, 28);
			font = new Font ("Arial", Font.PLAIN, 12);
			
		}
		catch (Exception e) {
			e.printStackTrace ();
		}

			try
			{
				java.applet.AudioClip clip =
						java.applet.Applet.newAudioClip (
								new java.net.URL ("file:\\H:\\Documents\\Videos\\ReadySucksCPT\\src\\Resources\\sonicgreenhillzone.wav"));
				clip.loop ();
			}
			catch (java.net.MalformedURLException murle)
			{
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
		g.setFont (titleFont);
		g.drawString ("Insert Title Here", 80, 70);
		
		//draw menu options
		g.setFont (font);
		for (int i = 0; i < options.length; i++) {
			if (i == currentChoice) {
				g.setColor (Color.RED);
			}
			else {
				g.setColor (Color.BLUE);
			}
			g.drawString (options[i], 145, 140 + i * 15);
			
			//draw credit thingy
			g.setColor (Color.ORANGE);
			g.setFont (font);
			g.drawString ("2016 Get Recchid", 220, 225);
			g.drawString ("+ tehc", 220, 235);
			
		}
	}
	
	private void select () {
		if (currentChoice == 0) {			
			GameStateManager.currentState = 1;
		}
		if (currentChoice == 1) {
			GameStateManager.currentState = 3;
		}
		if (currentChoice == 2) {
			System.exit (0);
		}
	}
	
	public void keyPressed (int k) {
		if (k == KeyEvent.VK_ENTER || k == KeyEvent.VK_SPACE) {
			select ();
		}
		if (k == KeyEvent.VK_UP) {
			currentChoice--;
			if (currentChoice == -1) {
				currentChoice = options.length - 1;
			}
		}
		if (k == KeyEvent.VK_DOWN) {
			currentChoice++;
			if (currentChoice == options.length) {
				currentChoice = 0;
			}
		}
	}
	public void keyReleased (int k) {}
	
}
