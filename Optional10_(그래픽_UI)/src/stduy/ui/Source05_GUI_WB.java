package stduy.ui;

import javax.swing.*;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.Color;

/*
 * WindowBuilder로 꾸미고자하는 클래스는, extends JFrame, extends JDialog, extends JPanel... 해야 함.
 * 
 * class 우클릭 -> open with -> WindowBuilder Editor
 * 그러나 크기 설정은 수동으로 코딩해야만 함...
 * 
 */

public class Source05_GUI_WB extends JFrame {
	public Source05_GUI_WB() {
		setSize(537,368);
		setTitle("Graphic UI by WB");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.GRAY);
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("메뉴");
		mnNewMenu.setMnemonic('z');
		mnNewMenu.setForeground(Color.BLACK);
		mnNewMenu.setFont(new Font("나눔고딕코딩", Font.PLAIN, 12));
		menuBar.add(mnNewMenu);
		
		buildPane();
	}

	private void buildPane() {
		getContentPane().setLayout(null);

		JButton btn01 = new JButton("버튼");
		btn01.setFont(new Font("나눔바른펜", Font.PLAIN, 14));
		btn01.setBounds(412, 10, 97, 33);
		getContentPane().add(btn01);

		JPanel panel = new JPanel();
		panel.setBounds(12, 10, 291, 125);
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(0, 3, 0, 0));

		JToggleButton tglbtn_2 = new JToggleButton("New toggle button");
		panel.add(tglbtn_2);
				
						JToggleButton tglbtn = new JToggleButton("New toggle button");
						panel.add(tglbtn);
		
				JToggleButton tglbtn_1 = new JToggleButton("New toggle button");
				panel.add(tglbtn_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 188, 144, 132);
		getContentPane().add(scrollPane);

		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		scrollPane.setViewportView(textArea);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(168, 188, 144, 132);
		getContentPane().add(scrollPane_1);

		JTree tree = new JTree();
		scrollPane_1.setViewportView(tree);
		
		JLabel label = new JLabel("텍스트 영역");
		label.setBounds(12, 166, 130, 15);
		getContentPane().add(label);
		
		JLabel label2 = new JLabel("제이트리");
		label2.setBounds(170, 166, 57, 15);
		getContentPane().add(label2);
	}

	public static void main(String[] args) {
		new Source05_GUI_WB().setVisible(true);
	}
}
