package HeadFirstDesign.java;

import java.awt.Graphics;

import javax.swing.JFrame;


public class MyFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MyFrame(String title){
		super(title);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300, 300);
		this.setVisible(true);		
	}
	
	public void paint(Graphics graphic){
		super.paint(graphic); 
		String text="I Love Tiffany";
		graphic.drawString(text, 100, 100);
	}
	
	public static void main(String[] args){
		MyFrame myframe=new MyFrame("Head first design");		
	}

}
