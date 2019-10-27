package Lobby_Screen;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.lang.reflect.Field;

import javax.swing.ImageIcon;

import Default.Default_Button_Event;
import Default.Default_Frame;
import Login_Screen.Login_Background;
import Main_Screen.Main_Background;
import Select_Screen.Select_Background;

public class Lobby_AddFriends_Button extends Default_Button_Event{
	private ImageIcon ADDFREIDNS = new ImageIcon(Main_Background.class.getResource("/Image/LOBBY_SCREEN/LOBBY_ADDFRIENDS.png"));
	private ImageIcon ADDFREIDNS_ENTER = new ImageIcon(Main_Background.class.getResource("/Image/LOBBY_SCREEN/LOBBY_ADDFRIENDS_ENTER.png"));
	private Lobby_Background LB;
	private Default_Frame DF;
	private AddFriends_Background AB;
	
	public Lobby_AddFriends_Button(ImageIcon icon, Lobby_Background LB) {	
		this.LB = LB;
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
		setIcon(ADDFREIDNS_ENTER);//������� �ٲ�
		setCursor(new Cursor(Cursor.HAND_CURSOR));// Ŀ���� �հ��� �������
	}

	@Override
	public void mouseExited(MouseEvent e) {
		setIcon(ADDFREIDNS);// �ٽ� �����·�
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// Ŀ���� �⺻����
	}

	@Override
	public void mousePressed(MouseEvent e) {
		LB.setAB();
	}
}
