package gui.hangman;

import javax.swing.*;
import java.awt.Font;

public class HangmanFrame extends JFrame {
	JLabel lbLife;
	JTextField tfQz;
	JLabel lbShow;
	JTextField tfUser;
	JButton btnEntr;
	String[] quiz;
	
	public HangmanFrame() {
		setResizable(false);
		setTitle("HANGMAN");
		setSize(450,545);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		buildPane();
		addListener();
	}
	
	public String makeQuiz() {
		quiz = "ELEPHANTE,ALLIGATOR,CROCODILE,RABBIT".split(",");
		return quiz[(int)(Math.random()*quiz.length)];
	}
	
	private void addListener() {
		btnEntr.addActionListener(new BtnEntrHandler(this));
	}

	private void buildPane() {
		tfQz = new JTextField();
		tfQz.setEditable(false);
		tfQz.setHorizontalAlignment(SwingConstants.CENTER);
		tfQz.setText("???????");
		tfQz.setFont(new Font("±¼¸²", Font.BOLD, 30));
		tfQz.setBounds(109, 104, 211, 55);
		getContentPane().add(tfQz);
		tfQz.setColumns(10);
		
		lbLife = new JLabel("\uB0A8\uC740 \uAE30\uD68C : ");
		lbLife.setFont(new Font("³ª´®°íµñÄÚµù", Font.BOLD, 18));
		lbLife.setBounds(31, 40, 127, 28);
		getContentPane().add(lbLife);
		
		tfUser = new JTextField();
		tfUser.setBounds(195, 396, 53, 55);
		getContentPane().add(tfUser);
		tfUser.setColumns(10);
		
		JLabel lbInput = new JLabel("\uC785\uB825 :");
		lbInput.setHorizontalAlignment(SwingConstants.CENTER);
		lbInput.setFont(new Font("³ª´®°íµñÄÚµù", Font.BOLD, 25));
		lbInput.setBounds(91, 400, 90, 40);
		getContentPane().add(lbInput);
		
		btnEntr = new JButton("START");
		btnEntr.setFont(new Font("³ª´®°íµñÄÚµù", Font.BOLD, 15));
		btnEntr.setBounds(271, 396, 75, 55);
		getContentPane().add(btnEntr);
		
		lbShow = new JLabel("O X");
		lbShow.setFont(new Font("±¼¸²", Font.BOLD, 80));
		lbShow.setHorizontalAlignment(SwingConstants.CENTER);
		lbShow.setBounds(91, 182, 255, 190);
		getContentPane().add(lbShow);
		lbShow.setVisible(false);
	}

	public static void main(String[] args) {
		new HangmanFrame().setVisible(true);
	}
}
