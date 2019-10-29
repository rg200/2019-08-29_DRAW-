package Lobby_Screen;

import java.awt.Cursor;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import Default.Default_Button_Event;
import Default.Default_Frame;
import Main_Screen.Main_Background;

public class Lobby_Create_Buttonn extends Default_Button_Event{
	private ImageIcon CREATE = new ImageIcon(Main_Background.class.getResource("/Image/LOBBY_SCREEN/LOBBY_CREATE_BUTTON.png"));
	private ImageIcon CREATE_ENTER = new ImageIcon(Main_Background.class.getResource("/Image/LOBBY_SCREEN/LOBBY_CREATE_BUTTON_ENTER.png"));
	private Lobby_Background LB;
	private Default_Frame DF;
	
	public Lobby_Create_Buttonn(ImageIcon icon, Lobby_Background LB) {	
		this.LB = LB;
		setIcon(icon);
		setBorderPainted(false);
		setFocusable(false);
		setContentAreaFilled(false);
		setBounds(825,80, icon.getIconWidth(), icon.getIconHeight());
		addMouseListener(this);
		setVisible(true);
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		setIcon(CREATE_ENTER);//������� �ٲ�
		setCursor(new Cursor(Cursor.HAND_CURSOR));// Ŀ���� �հ��� �������
	}

	@Override
	public void mouseExited(MouseEvent e) {
		setIcon(CREATE);// �ٽ� �����·�
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// Ŀ���� �⺻����
	}

	@Override
	public void mousePressed(MouseEvent e) {
		Lobby_Background.CreateSetvisible();
	}
}
