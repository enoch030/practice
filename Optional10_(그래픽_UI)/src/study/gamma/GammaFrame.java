package study.gamma;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.Color;


public class GammaFrame extends JFrame {
	boolean attack = true;
	int game = 0;
	int win = 0;
	
	JButton btnStart;
	JLabel lbPlyr;
	JButton btn1;
	JTextArea ta;
	JLabel lblNewLabel;
	JLabel lbAtkC;
	JLabel lbAtkP;
	JLabel lbCom;
	JLabel lbScore;
	JButton btn2;
	JButton btn3;
	
	public GammaFrame() {
		setResizable(false);
		setSize(350, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		buildPane();
		addListener();
	}
	
	private void addListener() {
		
//		btn1.setActionCommand("묵"); //액션 커맨드를 변경할 수 있음. IMG를 사용한 경우 이 코드 활용해서 액션 커맨드 설정.
		btnStart.addActionListener(new BtnStartHandler(this));
		btnStart.setMnemonic('s');
		btn1.addActionListener(new PlayerBtnHandler(this));
		btn1.setMnemonic('a');
		btn2.addActionListener(new PlayerBtnHandler(this));
		btn2.setMnemonic('s');
		btn3.addActionListener(new PlayerBtnHandler(this));
		btn3.setMnemonic('d');
	}
	
	private void buildPane() {
		getContentPane().setLayout(null);
		JPanel panel = new JPanel();
		panel.setBounds(12, 166, 310, 117);
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(1, 3, 5, 0));
		
		
		String imgPath = "D:\\LSR1016\\workspace\\Optional10_(그래픽_UI)\\image\\paper.png";
		//ImageIcon객체를 생성
		ImageIcon originIcon = new ImageIcon(imgPath);  
		//ImageIcon에서 Image를 추출
		Image originImg = originIcon.getImage(); 
		//추출된 Image의 크기를 조절하여 새로운 Image객체 생성
		Image changedImg= originImg.getScaledInstance(100, 117, Image.SCALE_SMOOTH );
		//새로운 Image로 ImageIcon객체를 생성
//		ImageIcon Icon = new ImageIcon(changedImg);
		
		
		btn1 = new JButton("");
		btn1.setIcon(resizeImgIcon(imgPath));
		btn1.setForeground(Color.BLACK);
		btn1.setFont(new Font("다음_Regular", Font.BOLD, 30));
		btn1.setEnabled(false);
		panel.add(btn1);
		
		btn2 = new JButton("찌");
		btn2.setForeground(Color.BLACK);
		btn2.setFont(new Font("다음_Regular", Font.BOLD, 30));
		btn2.setEnabled(false);
		panel.add(btn2);
		
		btn3 = new JButton("빠");
		btn3.setForeground(Color.BLACK);
		btn3.setFont(new Font("다음_Regular", Font.BOLD, 30));
		btn3.setEnabled(false);
		panel.add(btn3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 291, 310, 161);
		getContentPane().add(scrollPane);
		
		ta = new JTextArea();
		ta.setLineWrap(true);
		ta.setEditable(false);
		scrollPane.setViewportView(ta);
		
		lbPlyr = new JLabel("?");
		lbPlyr.setBounds(140, 142, 57, 15);
		lbPlyr.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lbPlyr);
		
		btnStart = new JButton("START");
		btnStart.setBounds(234, 10, 88, 31);
		getContentPane().add(btnStart);
		
		lblNewLabel = new JLabel("VS");
		lblNewLabel.setBounds(140, 103, 57, 15);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblNewLabel);
		
		lbCom = new JLabel("?");
		lbCom.setFont(new Font("굴림", Font.BOLD, 25));
		lbCom.setBounds(140, 44, 57, 49);
		lbCom.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lbCom);
		
		lbAtkC = new JLabel("공격");
		lbAtkC.setHorizontalAlignment(SwingConstants.CENTER);
		lbAtkC.setForeground(Color.RED);
		lbAtkC.setBounds(234, 65, 57, 15);
		getContentPane().add(lbAtkC);
		lbAtkC.setVisible(false);
		
		lbAtkP = new JLabel("공격");
		lbAtkP.setHorizontalAlignment(SwingConstants.CENTER);
		lbAtkP.setForeground(Color.RED);
		lbAtkP.setBounds(234, 141, 57, 15);
		getContentPane().add(lbAtkP);
		
		lbScore = new JLabel("0전 0승 0패");
		lbScore.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lbScore.setBounds(12, 14, 88, 23);
		getContentPane().add(lbScore);
		lbAtkP.setVisible(false);
		
	}

	private Icon resizeImgIcon(String imgPath) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) {
		new  GammaFrame().setVisible(true);
	}
	
}
