package GameState;

import TileMap.Background;

import java.awt.*;

public class HelpState extends GameState {
	
	private Background bg;
	
	public HelpState (GameStateManager gsm) {
		
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
		
		//some really crappy instructions that are bound to be changed
		g.setFont(MenuState.font);
		g.setColor(Color.MAGENTA);
		g.drawString("Press the button that is shown on the screen to dodge", 5, 50);
		g.drawString("the bullet that is approaching you", 5, 70);
		g.drawString("If you take too long to make a move or if you press the", 5, 90);
		g.drawString("wrong key, you lose", 5, 110);
		
	}
	
	public void keyPressed (int k) {
		GameStateManager.currentState = 0;
	}
	public void keyReleased (int k) {}
	
}


