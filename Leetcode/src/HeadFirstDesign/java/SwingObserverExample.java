package HeadFirstDesign.java;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SwingObserverExample {
	private JFrame myFrame;
	
	private void go() {
		JButton myBotton = new JButton("Should I do it?");
		myFrame.getContentPane().add(myBotton);
		myBotton.addActionListener(new AngleListener());
		myBotton.addActionListener(new devilListener());
		myFrame.setSize(400, 400);
		myBotton.setSize(20, 20);
		myFrame.setVisible(true);
		
	}
	
	class AngleListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("Don't do it, you will regret!");
			
		}
		
	}
	
	class devilListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Just Do It!");
		}
		
	}
	
	
	
	public static void main(String[] args) {
		SwingObserverExample twoAnswer = new SwingObserverExample();
		twoAnswer.myFrame=new JFrame();
		twoAnswer.go();
	}



}
