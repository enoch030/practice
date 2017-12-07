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
		
		if(owner.btnEntr.getText().equals("START")) { // 시작버튼 클릭시
			String lifeTmp = owner.lbLife.getText();
			owner.lbLife.setText(lifeTmp+"5");
			System.out.println(quiz);
			owner.tfQz.setText(sbQz.toString());
			owner.btnEntr.setText("ENTER");
		} else { // 확인버튼 클릭시
			int idx = sbQz.indexOf(owner.tfUser.getText());
//			System.out.println(sbQz.getChars(srcBegin, srcEnd, dst, dstBegin));
			if(idx != -1) {
				sbQz.setCharAt(idx, owner.tfUser.getText().charAt(0));
				owner.tfQz.setText(sbQz.toString());
			}
			
		}
	}

}
