package stduy.ui;

import java.awt.*;
import javax.swing.*;


class CustomFrame extends JFrame {
	CustomFrame(){
		this.setTitle("Graphic UI");
		this.setSize(400, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		// 실제적으로 JFrame에 add한 게 아니라 JFrame이 알아서 (Container의) ContentPane영역에 add한 것 뿐.
//		Container pane = this.getContentPane(); 
		JPanel pane = (JPanel) this.getContentPane(); // 나올 때는 부모타입(Container)으로 나옴. 강제 캐스팅.
		pane.setLayout(new GridLayout(2, 3,10,10));
		
//		this.setLayout(new GridLayout(2, 3, 7, 5)); // row, col, hrizon gap, vertical gap (행 우선)
		String[] ar = "월,화,수,목,금,토".split(",");
		for(int i = 0; i<ar.length; i++) {
			JComponent jc = new JToggleButton(ar[i]);
//			this.add(jc);
			pane.add(jc);
		}
		
		JPanel pnTmp = new JPanel();
//		pnTmp.setLayout(new GridLayout(3,3,5,5));
		pnTmp.setLayout(new FlowLayout(2,15,4)); // 0: 왼쪽 / 1: 센터 / 2: 오른쪽 정렬, hgap, vgap
		for(int i=1; i<=9; i++) {
			JButton t = new JButton("  "+String.valueOf(i)+"  ");
			t.setMnemonic(i+48); // 단축키 설정(alt+'키')
			pnTmp.add(t);
		}
		this.setContentPane(pnTmp);//ContentPane 변경. 주석처리하면 위의 pane 대로 나오겠지! 즉, 바꿔치기!
	}
	
	
}

public class Source02_GUI {
	public static void main(String[] args) {
		CustomFrame cf = new CustomFrame();
		cf.setVisible(true);
		
		
	}
}
