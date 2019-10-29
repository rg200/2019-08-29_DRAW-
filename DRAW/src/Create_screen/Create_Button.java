package Create_screen;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JTextField;

import Default.Default_Button_Event;
import Default.Default_Frame;
import Login_Screen.Login_Background;
import Main_Screen.Main_Background;

public class Create_Button extends Default_Button_Event{
	private ImageIcon CREATE_IN = new ImageIcon(Main_Background.class.getResource("/Image/LOBBY_SCREEN/CREATE/CREATE_CREATE_BUTTON_IN.png"));
	private ImageIcon CREATE_ENTER = new ImageIcon(Main_Background.class.getResource("/Image/LOBBY_SCREEN/CREATE/CREATE_CREATE_BUTTON_ENTER.png"));

	public Create_Button(ImageIcon icon) {
		setIcon(icon);
		setBorderPainted(false);
		setFocusable(false);
		setContentAreaFilled(false);
		setBounds(25,575, icon.getIconWidth(), icon.getIconHeight());
		addMouseListener(this);
		
	}
	public void mouseEntered(MouseEvent e) {
		setIcon(CREATE_ENTER);//������� �ٲ�
		setCursor(new Cursor(Cursor.HAND_CURSOR));// Ŀ���� �հ��� �������
	}

	@Override
	public void mouseExited(MouseEvent e) {
		setIcon(CREATE_IN);// �ٽ� �����·�
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// Ŀ���� �⺻����
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}
}
