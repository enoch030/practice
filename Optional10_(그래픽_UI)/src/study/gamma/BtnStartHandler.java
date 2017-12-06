package study.gamma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BtnStartHandler implements ActionListener {
	GammaFrame owner;
	
	public BtnStartHandler(GammaFrame gammaFrame) {
		owner = gammaFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		owner.btnStart.setEnabled(false);
		owner.ta.setText("===================================\n[SYSTEM] 게임을 시작합니다!\n[SYSTEM] 당신의 선공입니다!\n");
		owner.btn1.setEnabled(true);
		owner.btn2.setEnabled(true);
		owner.btn3.setEnabled(true);
		owner.lbAtkP.setVisible(true);
		owner.game++;
	}

}
