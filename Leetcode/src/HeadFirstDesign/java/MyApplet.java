package HeadFirstDesign.java;

import java.applet.Applet;
import java.awt.Graphics;

public class MyApplet extends Applet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String message;
	
	public void init(){
		message = "Hello world, I'm alive!";
		repaint();
	}

	public void start(){
		message = "I love Tiffany and Neo!!!";
		repaint();		
	}

	public void stop(){
		message = "Oh, now I'm being stopped ...";
	}

	public void paint(Graphics g){
		g.drawString(message, 5, 15);
	}

}
