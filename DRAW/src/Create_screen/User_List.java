package Create_screen;

import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import Default.Default_Button_Event;
import Default.Default_Frame;
import Main_Screen.Main_Background;

public class User_List extends Default_Button_Event{
	// 유저 목록에 있는 버튼을 나타내는 클래스 
	private ImageIcon User_List = new ImageIcon(Main_Background.class.getResource("/Image/LOBBY_SCREEN/PlayList/USERLIST_BUTTON.png"));
	private Default_Frame DF;
	public User_List(Default_Frame DF) {
		this.DF=DF;
		setIcon(User_List);
		setBorderPainted(false);
		setFocusable(false);
		setContentAreaFilled(false);
		addMouseListener(this);	
	}
	public void mousePressed(MouseEvent e) {
		
	}
}
