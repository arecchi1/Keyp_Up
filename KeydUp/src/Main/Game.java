package Main;

import javax.swing.JFrame;

public class Game {
	
	public static void main (String[] args) {
		
		JFrame window = new JFrame ("SANIC THE GAEM");
		window.setContentPane (new GamePanel ());
		window.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		window.setResizable (false);
		window.pack ();
		window.setVisible (true);
		window.setLocationRelativeTo (null);
		
	}

}