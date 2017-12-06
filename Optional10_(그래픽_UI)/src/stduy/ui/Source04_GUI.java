package stduy.ui;

import java.awt.*;
import javax.swing.*;

public class Source04_GUI extends JFrame {

	Source04_GUI(){
		setting();
		buildMenu();
		buildPane();
		
	}

	private void buildMenu() {
		JMenuBar bar = new JMenuBar();
		// JMenu, JMenuItem, JCheckBoxMenuItem
		// bar에는 JMenu만 붙음.
		// JMenu에도 JMenu 붙일 수 있고, JMenu에는 JMenuItem을 하위로 붙일 수 있음.
		JMenu mn01 = new JMenu("설정");
			JMenuItem mi01 = new JMenuItem("새로하기");
			JMenuItem mi02 = new JMenuItem("불러오기");
			mn01.add(mi01);
			mn01.add(mi02);
			JMenu mn01_01 = new JMenu("저장하기");
			mn01.add(mn01_01);
				JMenuItem mi01_a = new JMenuItem("새 이름으로");
				JMenuItem mi01_b = new JMenuItem("기존이름으로");
				mn01_01.add(mi01_a);
				mn01_01.add(mi01_b);
		JMenu mn02 = new JMenu("도움말");
			JCheckBoxMenuItem cmi_01 = new JCheckBoxMenuItem("배경움");
			JCheckBoxMenuItem cmi_02 = new JCheckBoxMenuItem("효과음");
			mn02.add(cmi_01);
			mn02.add(cmi_02);
		
		bar.add(mn01);
		bar.add(mn02);
		
		setJMenuBar(bar);
	}

	private void buildPane() { //Panel 꾸미기 코드
		// AbsoluteLayout : LayoutManager 안 씀 : 내 맘대로 배치할 거임.
		getContentPane().setLayout(null);
		
		JLabel lb = new JLabel("한 줄짜리 글씨 적어두는 컴포넌트");
		JComboBox<String> cb = new JComboBox<>(new String[] {"초등학교","중학교","고등학교"});
	
		lb.setSize(100,30);
		lb.setLocation(100,50); // JFrame의 contentPane이 기준.
		getContentPane().add(lb);
		cb.setBounds(100,80,130,30); // setSize/setLocation 따로 할 필요 없이 한 번에 x,y,w,h 설정
		getContentPane().add(cb);
		
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(1,2,5,5));
		JTextField t = new JTextField();
		p.add(t);
		JPasswordField pf = new JPasswordField();
		p.add(pf);
		p.setBounds(200,300,200,30);
		getContentPane().add(p);
	
	}

	private void setting() { 
		this.setSize(500,400);
		this.setLocation(600, 200);
		this.setResizable(false);
		
	}
	
	
	public static void main(String[] args) {
		new Source04_GUI().setVisible(true);
		
		
		
	}
	
}
