package study.event.alpha;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

/*
 * [Event Handling]
 * 
 * - Swing의 컴포넌트들은 사용자가 어떤 행위를 할 때마다 정해진 이벤트들이 발생함.
 * - 컴포넌트별로 어떤 이벤트가 발생하는지와 그 처리 방법을 알면 됨.
 *   
 *   [ 리스너 클래스 작성 및 연동 ]
 *
 *   - 처리하고 싶은 컴포넌트를 핸들링 할 클래스로 implements 처리할 이벤트 리스너 후
 *     actionPerformed() 오버라이드 하고
 *     컴포넌트.addActionListener(액션리스너 구현한 클래스);
 *
 *   [ 컴포넌트 제어 ]
 *   
 *   - 핸들링 클래스에 필요한 객체를 인자로 넘겨 제어할 수도 있음. but, 인자가 많은 경우엔?
 * 
 */

//============================================[ 액션 리스너 ]

class BtLeftActionHandler implements ActionListener {
	
	JLabel lbCenter;
	
	public BtLeftActionHandler(JLabel lbCenter) {
		this.lbCenter = lbCenter;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		lbCenter.setText("Left");
		System.out.println("Action!!");
	}
}


class BtRightActionHandler implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null, "ACTION!");
	}
}


class LbCenterActionListener implements MouseWheelListener {
	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		JOptionPane.showMessageDialog(null, "Wheeling!!");
	}
}

//=============================================================================

public class AlphaFrame extends JFrame {

	public AlphaFrame(){
		
		setSize(300,130);
		setTitle("Event HANDLE"); // Frame 자체에 대한 설정
		buildPane(); // Frame의 ContentPane 구축
//		addEventListener(); // Component의 Event Listener 등록
	}
	
//	private void addEventListener() {
//		
//	}

	private void buildPane() {
		JButton btLeft = new JButton("LEFT");
		btLeft.setMnemonic('L');
		getContentPane().add(btLeft, BorderLayout.WEST);
		
		JButton btRight = new JButton("RIGHT");
		getContentPane().add(btRight, BorderLayout.EAST);
		
		JLabel lbCenter = new JLabel("???????");
		lbCenter.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lbCenter, BorderLayout.CENTER);		
		
//		ActionListener al = new BtLeftActionHandler();
//		btLeft.addActionListener(al);
		btLeft.addActionListener(new BtLeftActionHandler(lbCenter));
		btRight.addActionListener(new BtRightActionHandler());
		lbCenter.addMouseWheelListener(new LbCenterActionListener());
		lbCenter.setText("XXXXXX");
		
	}

	public static void main(String[] args) {
		new AlphaFrame().setVisible(true);
	}
	
	
}
