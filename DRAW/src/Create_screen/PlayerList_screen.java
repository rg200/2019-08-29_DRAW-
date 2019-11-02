package Create_screen;

import java.awt.FlowLayout;

import javax.swing.JPanel;

public class PlayerList_screen extends JPanel{
	// 유저 목록을 나타내는 패널 
	public PlayerList_screen() {
		setLayout(new FlowLayout(FlowLayout.LEFT)); 
		setOpaque(false);
		setBounds(1250, 260, 370, 395);	
		
	}

}
