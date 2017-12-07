package gui.hangman;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BtnEntrHandler implements ActionListener {
	HangmanFrame owner;
	String quiz;
	
	public BtnEntrHandler(HangmanFrame owner) {
		this.owner = owner;
		quiz = owner.makeQuiz();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		StringBuilder sbQz = new StringBuilder(quiz);
		for(int i = 0; i<quiz.length(); i++) {
			sbQz.setCharAt(i, '?');
		}
		
		if(owner.btnEntr.getText().equals("START")) { // ���۹�ư Ŭ����
			String lifeTmp = owner.lbLife.getText();
			owner.lbLife.setText(lifeTmp+"5");
			System.out.println(quiz);
			owner.tfQz.setText(sbQz.toString());
			owner.btnEntr.setText("ENTER");
		} else { // Ȯ�ι�ư Ŭ����
			int idx = sbQz.indexOf(owner.tfUser.getText());
//			System.out.println(sbQz.getChars(srcBegin, srcEnd, dst, dstBegin));
			if(idx != -1) {
				sbQz.setCharAt(idx, owner.tfUser.getText().charAt(0));
				owner.tfQz.setText(sbQz.toString());
			}
			
		}
	}

}
