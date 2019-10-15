package Default;


import javax.swing.JFrame;

import Main_Screen.Main_Background;


public class Default_Frame extends JFrame {

	public static final int SCREEN_WIDTH = 1680;
	public static final int SCREEN_HEIGHT = 1050;
	
	public Default_Frame() {
		
		add(new Main_Background(this));
		setSize(Default_Frame.SCREEN_WIDTH, Default_Frame.SCREEN_HEIGHT);// 크기 고정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Draw!");
		setResizable(false);// 크기 조절 불가
		setLocationRelativeTo(null);// 시작시 무조건 중앙 배치	
		setVisible(true);
	}
	public static void main(String[] args) {
		new Default_Frame();
	}

}
