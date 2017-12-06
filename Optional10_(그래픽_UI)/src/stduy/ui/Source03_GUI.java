package stduy.ui;

import java.awt.*;
import javax.swing.*;

public class Source03_GUI extends JFrame {

	Source03_GUI(){
		this.setSize(400,300);
		this.setLocation(600, 200); // 모니터 기준. 좌측 상단 (0, 0)
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		buildPane();
		}
		
	private void buildPane() {
		// BorderLayout : 동서남북중앙의 5가지 영역으로 나뉨.
		getContentPane().setLayout(new BorderLayout());
		
		JPasswordField pf = new JPasswordField(); // 한 줄 짜리
		JTextField tf = new JTextField(); // 한 줄 짜리
		JTextArea ta = new JTextArea(); // 여러 줄 짜리
//		JEditorPane ep = new JEditorPane(); // 여러 줄 짜리
		JToggleButton ep = new JToggleButton("ON");
		JToggleButton tb2 = new JToggleButton("OFF");
		
		getContentPane().add(pf, BorderLayout.SOUTH);
		getContentPane().add(tf, "North");
		getContentPane().add(ta, BorderLayout.CENTER);
		getContentPane().add(ep, "East");
		getContentPane().add(tb2, BorderLayout.EAST); // 같은 영역에 두 개 안 됨. 덮어씌워짐.
		
		JPanel tp = new JPanel();
		tp.setLayout(new GridLayout(2,1));
			tp.add(ep);
			tp.add(tb2);
		getContentPane().add(tp, BorderLayout.EAST);
		
	}
	
	public static void main(String[] args) {
		new Source03_GUI().setVisible(true);
	}
	
	
	
}
