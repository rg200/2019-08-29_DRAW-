package Create_screen;

import java.awt.FlowLayout;

import javax.swing.JPanel;

import Default.Default_Frame;

public class PlayerList_screen extends JPanel{
	// 유저 목록을 나타내는 패널
	private User_List UL;
	private Default_Frame DF;
	public PlayerList_screen() {
		setLayout(new FlowLayout(FlowLayout.LEFT)); 
		setOpaque(false);
		setBounds(1235, 260, 370, 395);
		UL = new User_List(DF);
		add(UL);
		
	}

}
