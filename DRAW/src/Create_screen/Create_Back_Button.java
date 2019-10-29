package Create_screen;

import java.awt.Cursor;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import Default.Default_Button_Event;
import Default.Default_Frame;
import Lobby_Screen.Lobby_Background;
import Main_Screen.Main_Background;

public class Create_Back_Button extends Default_Button_Event{
	private ImageIcon CREATE_BACK_IN = new ImageIcon(Main_Background.class.getResource("/Image/LOBBY_SCREEN/CREATE/CREATE_BACK_BUTTON_IN.png"));
	private ImageIcon CREATE_BACK_ENTER = new ImageIcon(Main_Background.class.getResource("/Image/LOBBY_SCREEN/CREATE/CREATE_BACK_BUTTON_ENTER.png"));
	private Lobby_Background LB;
	private Default_Frame DF;
	
	public Create_Back_Button(ImageIcon icon, Lobby_Background LB) {
		this.LB = LB;
		setIcon(icon);
		setBorderPainted(false);
		setFocusable(false);
		setContentAreaFilled(false);
		setBounds(722,570, icon.getIconWidth(), icon.getIconHeight());
		addMouseListener(this);
	}
	public void mouseEntered(MouseEvent e) {
		setIcon(CREATE_BACK_ENTER);//흰색으로 바뀜
		setCursor(new Cursor(Cursor.HAND_CURSOR));// 커서가 손가락 모양으로
	}

	@Override
	public void mouseExited(MouseEvent e) {
		setIcon(CREATE_BACK_IN);// 다시 원상태로
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// 커서가 기본으로
	}

	@Override
	public void mousePressed(MouseEvent e) {
		Lobby_Background.CreateSetvisible();
	}

}
