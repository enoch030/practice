package stduy.ui;

/*
 * 프로그램을 Console기반의 TUI(Text User Interface)가 아닌, GUI(Graphic User Interface)로 만들어보자!
 * 
 * java 초칭기에는 GUI 구축을 위해 awt 패키지를 이용했음. (기능/모양 투박)
 * awt를 extends한 swing 클래스 사용해서 GUI 구축.
 * 
 * 
 * GUI구축은 블럭조립이랑 비슷.
 * 
 *  - 독립적으로 화면에 뜰 수 있는 컨테이너(Top-Level) 클래스 필요. (기본적으로 Thread임. 창 닫아도 프로그램 돌아가는 중)
 *    (JFrame, JDialog, JWinodow...) - Super class : Container
 *     JFrame : 메뉴바 / 뷰(컴포넌트 배치) 2가지 영역
 * 
 *------------------------------------------------------------------------------------------------------------------------------ 
 * 
 *  - [메뉴 영역]
 *    JMenu, JMenuItem, JCheckBoxMenuItem
 *    bar에는 JMenu만 붙음.
	  JMenu에도 JMenu 붙일 수 있고, JMenu에는 JMenuItem을 하위로 붙일 수 있음.
 *      
 *  - 컨테이너 클래스에 swing-Component를 추가(add()시킴.
 *    (JButton, JCheckBox ...) - Super class : Component
 *    
 *------------------------------------------------------------------------------------------------------------------------------
 *    
 *  - [컴포넌트 영역]
 *    레이아웃 매니저(매니저를 활용하지 않으면 한 컨테이너에 한 component 밖에 추가 못 함)
 *    (CardLayout, GridLayout, FlowLayout...) - Super class : LayoutManager
 *    GridLayout : 동일크기 격자 분할 (default 1행)
 *    FlowLayout : (JPanel의 디폴트) Component 최소 크기(공백을 앞뒤로 주면 조금 커지긴 함) 로 특정 위치없이 띄움. 
 *                 사이즈 설정 불가.
 *    BorderLayout : (JFrame의 디폴트) 동서남북중앙의 5가지 영역 (영역 모두 설정하지 않으면 중앙 영역이 확장함)
 *     			     영역에 Component 뿐 아니라 Component들을 배치한 Panel 자체를 붙일 수도 있음.
 *    AbsoluteLayout : LayoutManager 안 씀(null) : 내 맘대로 배치할 거임. (component 크기 조절하고 싶으면 이걸로)
 *    	               setResizable(false) : 창 크기 확대 막기
 *    
 *    				   (AbsoluteLayout 위에 각종 Layout 패널들을 올릴 수는 있음!)
 *    
 *------------------------------------------------------------------------------------------------------------------------------
 * 
 * ==> 보통 GUI를 Main에서 직접 조립하진 않음. (tool 사용도 어렵기 때문에)
 *    - 아예 JFrame을 extends한 클래스를 만들어서 생성자 안에 기본 설정(사이즈, 타이틀 등)을 세팅함.
 *      (이 기본 설정도 따로 메소드를 세분화 해야 관리하기 편함. 생성자에서는 그 메소드를 호출)
 *    - main에서 frame을 설정한 클래스를 생성 후, setVisible()
 * 
 */

import java.awt.*;
import javax.swing.*;

public class Source01_GUI {
	public static void main(String[] args) {
		
//		Container f = new JFrame();
		JFrame f = new JFrame(); // X버튼 기본이 Hide. setDefaultCloseOperation으로 설정 바꿔야 함. 
//		JDialog f = new JDialog(); // 창크기 최소/최대 버튼 없음.
//		JWindow f = new JWindow(); // 창크기 버튼/ 닫기 버튼 없음. 아무 버튼도 없음.
		f.setSize(300,200); //JWindow는 창 크기(width,height) 설정해야함.
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 0 : 닫기 눌러도 무반응 1: 창 사라짐 2:프로그램까지 끝남.
		
		
//		LayoutManager mng = new FlowLayout();
		LayoutManager mng = new GridLayout();
		f.setLayout(mng);
		
		
		// [swing-Component] - Super Class : Component
//		Component b = new JButton("BUTTON");
		JButton b = new JButton("BUTTON");
		f.add(b);
//		JRadioButton bt = new JRadioButton("SWING");
		JCheckBox bt = new JCheckBox("SWING?");
		f.add(bt);
		
		
		f.setVisible(true); // 모든 세팅 후 setVisible() 해야 함.
		
		System.out.println("Source01_GUI execute.");
		
		
		
	}
}
