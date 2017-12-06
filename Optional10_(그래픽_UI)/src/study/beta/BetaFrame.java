package study.beta;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/*
 *  [ 이벤트 제어 ]
 *  
 *  : 단순히 필요한 객체를 인자로 넘기는 것보다 깔끔한 처리를 원한다면 
 *   - 차후 제어 (상태 변경, 상태 확인)가 필요한 컴포넌트를 필드로 설정.
 *     (WB에서 "covert local to field" 클릭)
 *   - 핸들러 클래스에게 프레임 객체 자체를 this로 통채로 넘김.
 * 	 
 *   ==> 일일이 인자를 넘길 필요 없음. 객체 통채로 받아 그 객체의 필드를 사용하면 됨.
 * 
 *   - 여러 개의 컴포넌트가 같은 이벤트를 실행한다면 그룹처리해서 한 개의 액션 핸들러로 커맨드 분리 작업할 수 있음!
 *     핸들러 클래스의 actionPerformed(ActionEvent e)의 매개변수 e의 getActionCommand() / getSource() 활용.
 *     (cf. study.gamma 패키지)
 */




class BtnCreateHandler implements ActionListener{
	BetaFrame owner;
	
	public BtnCreateHandler(BetaFrame betaFrame) {
		owner = betaFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String msg = "ID: "+owner.tfId.getText()+"\nPW: "+ new String(owner.pfPass.getPassword())+"\nMODE: "
				   + (owner.rbtnPublic.isSelected()? "Public":(owner.rbtnPrivate.isSelected()?"Private":"Null"))+"\n이대로 진행하시겠습니까?";
		
		int sel = JOptionPane.showConfirmDialog(owner, msg); // 해당 프레임의 주인(owner)을 인자로 주면 그 owner 프레임의 정중앙에 뜸.
		if(sel == 0) { // Yes == 0
			owner.setVisible(false); //hide시키기
		} else if(sel == 1) {
			System.out.println("아니오?");
		}
	}
}



class BtnResetHandler implements ActionListener{
	BetaFrame owner;
	
	public BtnResetHandler(BetaFrame betaFrame) {
		owner = betaFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		owner.tfId.setText("");
		owner.pfPass.setText("");
		owner.modeGroup.clearSelection();
	}
	
}



public class BetaFrame extends JFrame {
	JTextField tfId;
	JPasswordField pfPass;
	JRadioButton rbtnPublic;
	JRadioButton rbtnPrivate;
	JButton btnCreate;
	JButton btnReset;
	ButtonGroup modeGroup;

	public BetaFrame() {
		UIManager.put("Label.font", new Font("맑은 고딕", Font.PLAIN, 12));
		setSize(265,340);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		buildPane();
		addListener();
	}

	private void addListener() {
		btnCreate.addActionListener(new BtnCreateHandler(this)); // 이 클래스(객체)값 자체를 통채로 넘김.
		btnReset.addActionListener(new BtnResetHandler(this));
	
	}

	private void buildPane() {
		getContentPane().setLayout(null);
		
		JLabel lbID = new JLabel("ID");
		lbID.setBounds(51, 86, 57, 15);
		getContentPane().add(lbID);
		
		JLabel lbPass = new JLabel("PASS");
		lbPass.setBounds(51, 111, 57, 15);
		getContentPane().add(lbPass);
		
		JLabel lbName = new JLabel("NAME");
		lbName.setBounds(51, 136, 57, 15);
		getContentPane().add(lbName);
		
		tfId = new JTextField();
		tfId.setBounds(93, 83, 116, 21);
		getContentPane().add(tfId);
		tfId.setColumns(10);
		
		pfPass = new JPasswordField();
		pfPass.setBounds(93, 108, 116, 21);
		getContentPane().add(pfPass);
		
		rbtnPublic = new JRadioButton("PUBLIC");
		rbtnPublic.setSelected(true);
		rbtnPublic.setBounds(93, 132, 121, 23);
		getContentPane().add(rbtnPublic);
		
		rbtnPrivate = new JRadioButton("PRIVATE");
		rbtnPrivate.setBounds(93, 157, 121, 23);
		getContentPane().add(rbtnPrivate);
		
		// 라디오 버튼 여러 개 중 한 개만 체크되길 원한다면 버튼 그룹으로 꼭 묶어줘야함!
		
		modeGroup = new ButtonGroup();
		modeGroup.add(rbtnPublic);
		modeGroup.add(rbtnPrivate);
		
				
				
		btnCreate = new JButton("CREATE");
		btnCreate.setMnemonic('c');
		btnCreate.setBounds(84, 226, 97, 23);
		getContentPane().add(btnCreate);		
		
		btnReset = new JButton("RESET");
		btnReset.setMnemonic('r');
		btnReset.setBounds(84, 259, 97, 23);
		getContentPane().add(btnReset);
	}


	public static void main(String[] args) {
		new BetaFrame().setVisible(true);
	}

}
