package AddFriends_screen;

import java.awt.Cursor;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import Default.Default_Button_Event;
import Default.Default_Frame;
import Main_Screen.Main_Background;

public class AddFriends_Add_Button extends Default_Button_Event{
	private ImageIcon ADD_IN = new ImageIcon(Main_Background.class.getResource("/Image/LOBBY_SCREEN/FRIENDS/FRIENDS_ADD_BUTTON_IN.png"));
	private ImageIcon ADD_ENTER = new ImageIcon(Main_Background.class.getResource("/Image/LOBBY_SCREEN/FRIENDS/FRIENDS_ADD_BUTTON_ENTER.png"));
	
	public AddFriends_Add_Button(ImageIcon icon) {
		setIcon(icon);
		setBorderPainted(false);
		setFocusable(false);
		setContentAreaFilled(false);
		setBounds(25,390, icon.getIconWidth(), icon.getIconHeight());
		addMouseListener(this);	
	}
	public void mouseEntered(MouseEvent e) {
		setIcon(ADD_ENTER);//������� �ٲ�
		setCursor(new Cursor(Cursor.HAND_CURSOR));// Ŀ���� �հ��� �������
	}

	@Override
	public void mouseExited(MouseEvent e) {
		setIcon(ADD_IN);// �ٽ� �����·�
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// Ŀ���� �⺻����
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}
}
