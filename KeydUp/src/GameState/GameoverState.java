package GameState;

import TileMap.Background;

import java.awt.*;

public class GameoverState extends GameState {
	
	private Background bg;
	
	public GameoverState (GameStateManager gsm) {
		
		this.gsm = gsm;
		
		try {
			
			bg = new Background ("/Resources/menubg2.gif", 1);
			bg.setVector (-1, 0); //background menu scrolling speed
			
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
		
		g.setColor(Color.PINK);
		g.drawString("ur sk0re wuz " + PlayState.score, 50, 50);
		
	}

	
	public void keyPressed (int k) {
		PlayState.score = 0;
		GameStateManager.currentState = 0;
	}
	public void keyReleased (int k) {}
	
}

