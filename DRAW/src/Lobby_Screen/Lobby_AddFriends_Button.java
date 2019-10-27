package Lobby_Screen;

import java.awt.Cursor;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import Default.Default_Button_Event;
import Default.Default_Frame;
import Login_Screen.Login_Background;
import Main_Screen.Main_Background;
import Select_Screen.Select_Background;

public class Lobby_AddFriends_Button extends Default_Button_Event{
	private ImageIcon ADDFREIDNS = new ImageIcon(Main_Background.class.getResource("/Image/LOBBY_SCREEN/LOBBY_ADDFRIENDS.png"));
	private ImageIcon ADDFREIDNS_ENTER = new ImageIcon(Main_Background.class.getResource("/Image/LOBBY_SCREEN/LOBBY_ADDFRIENDS_ENTER.png"));
	private Default_Frame DF;
	
	public Lobby_AddFriends_Button(ImageIcon icon, Default_Frame DF) {
		this.DF = DF;
		setIcon(icon);
		setBorderPainted(false);
		setFocusable(false);
		setContentAreaFilled(false);
		setBounds(1240,689, icon.getIconWidth(), icon.getIconHeight());
		addMouseListener(this);
		setVisible(true);
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		setIcon(ADDFREIDNS_ENTER);//흰색으로 바뀜
		setCursor(new Cursor(Cursor.HAND_CURSOR));// 커서가 손가락 모양으로
	}

	@Override
	public void mouseExited(MouseEvent e) {
		setIcon(ADDFREIDNS);// 다시 원상태로
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// 커서가 기본으로
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}
}
