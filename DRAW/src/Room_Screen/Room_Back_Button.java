package Room_Screen;

import java.awt.Cursor;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import Default.Default_Button_Event;
import Default.Default_Frame;
import Lobby_Screen.Lobby_Background;
import Main_Screen.Main_Background;

public class Room_Back_Button extends Default_Button_Event{

	private ImageIcon ROOM_BACK = new ImageIcon(Main_Background.class.getResource("/Image/ROOM_SCREEN/ROOM_BACK.png"));
	private ImageIcon ROOM_BACK_ENTER = new ImageIcon(Main_Background.class.getResource("/Image/ROOM_SCREEN/ROOM_BACK_ENTER.png"));
	private Default_Frame DF;

	public Room_Back_Button(ImageIcon icon, Default_Frame DF) {
		this.DF = DF;
		setIcon(icon);
		setBorderPainted(false);
		setFocusable(false);
		setContentAreaFilled(false);
		setBounds(1225,900, icon.getIconWidth(), icon.getIconHeight());
		addMouseListener(this);
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		setIcon(ROOM_BACK_ENTER);//������� �ٲ�
		setCursor(new Cursor(Cursor.HAND_CURSOR));// Ŀ���� �հ��� �������
	}

	@Override
	public void mouseExited(MouseEvent e) {
		setIcon(ROOM_BACK);// �ٽ� �����·�
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// Ŀ���� �⺻����
	}

	@Override
	public void mousePressed(MouseEvent e) {
		DF.getContentPane().removeAll();
		DF.add(new Lobby_Background(DF));//Select_Background �г� �ҷ��� 
		DF.revalidate();
	}
}
