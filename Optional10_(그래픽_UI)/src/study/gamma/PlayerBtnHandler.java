package study.gamma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class PlayerBtnHandler implements ActionListener {
	GammaFrame owner;
	
	public PlayerBtnHandler(GammaFrame gammaFrame) {
		owner = gammaFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String logTmp;
		
		// 매개변수 ActionEvent e : 이벤트에 접근 가능.
		// e.getActionCommand() : 해당 컴포넌트에 적힌 글씨를 반환.
		// 컴포넌트.setActionCommand()로 액션 커맨드 변경/설정 가능.
		
		String cmd = e.getActionCommand();
//		Object o = e.getSource(); // 이벤트 발생시킨 객체 값
//		if (o == owner.btn1) { // 이 이벤트 일으킨 놈이 묵이면!
//			System.out.println();
//		}
		owner.lbPlyr.setText(cmd);
		logTmp = owner.ta.getText();
		owner.ta.setText(logTmp+"[SYSTEM] 플레이어가 "+(cmd.equals("묵")?cmd+"을":cmd+"를")+" 냈습니다.\n");

		String[] ar = "묵,찌,빠".split(",");
		int r = (int)(Math.random()*3);
		String com = ar[r];
		owner.lbCom.setText(com);
		owner.ta.append("[SYSTEM] 컴퓨터가 "+(com.equals("묵")?com+"을":com+"를")+" 냈습니다.\n");
		
		String winner = null;
		String msg = null;
		
		if(owner.attack == owner.lbAtkP.isVisible()) {
			if(cmd.equals(com)) {
				winner = "플레이어";
				msg = "승리";
				owner.win++;
			} else if(cmd.equals("묵")){
				if(com.equals("빠")) {
					owner.lbAtkC.setVisible(true);
					owner.lbAtkP.setVisible(false);
				}
			} else if(cmd.equals("찌")) {
				if(com.equals("묵")) {
					owner.lbAtkC.setVisible(true);
					owner.lbAtkP.setVisible(false);
				}
			} else if(cmd.equals("빠")) {
				if(com.equals("찌")) {
					owner.lbAtkC.setVisible(true);
					owner.lbAtkP.setVisible(false);
				}
			}
		} else if(owner.attack == owner.lbAtkC.isVisible()) {
			if(cmd.equals(com)) {
				winner = "컴퓨터";
				msg = "패배";
			} else if (com.equals("묵")){
				if(cmd.equals("빠")) {
					owner.lbAtkC.setVisible(false);
					owner.lbAtkP.setVisible(true);
				}
			} else if (com.equals("찌")) {
				if(cmd.equals("묵")) {
					owner.lbAtkC.setVisible(false);
					owner.lbAtkP.setVisible(true);
				}
			} else if(com.equals("빠")) {
				if(cmd.equals("찌")) {
					owner.lbAtkC.setVisible(false);
					owner.lbAtkP.setVisible(true);
				}
			}
		}
		if(winner != null) {
			owner.ta.append("[SYSTEM] "+winner+"의 승리!\n");
			JOptionPane.showMessageDialog(owner, msg+"...!!!");
			owner.btnStart.setEnabled(true);
			owner.btn1.setEnabled(false);
			owner.btn2.setEnabled(false);
			owner.btn3.setEnabled(false);
			owner.lbAtkP.setVisible(false);
			owner.lbAtkC.setVisible(false);
			owner.lbCom.setText("?");
			owner.lbPlyr.setText("?");
			owner.lbScore.setText(owner.game+"전 "+owner.win+"승 "+(owner.game-owner.win)+"패");
			owner.ta.append("[SYSTEM] 당신의 ☆"+msg+"★로 게임 종료!");
		}
		
	}

}
