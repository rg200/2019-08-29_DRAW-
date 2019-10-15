package Default;


import javax.swing.JFrame;

import Main_Screen.Main_Background;


public class Default_Frame extends JFrame {

	public static final int SCREEN_WIDTH = 1680;
	public static final int SCREEN_HEIGHT = 1050;
	
	public Default_Frame() {
		
		add(new Main_Background(this));
		setSize(Default_Frame.SCREEN_WIDTH, Default_Frame.SCREEN_HEIGHT);// ũ�� ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Draw!");
		setResizable(false);// ũ�� ���� �Ұ�
		setLocationRelativeTo(null);// ���۽� ������ �߾� ��ġ	
		setVisible(true);
	}
	public static void main(String[] args) {
		new Default_Frame();
	}

}
