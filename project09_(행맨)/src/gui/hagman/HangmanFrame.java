package gui.hagman;

import javax.swing.*;

public class HangmanFrame extends JFrame {
	
	
	public HangmanFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new HangmanFrame().setVisible(true);
	}
}
