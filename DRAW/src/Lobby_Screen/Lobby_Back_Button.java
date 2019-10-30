package Lobby_Screen;

import java.awt.Cursor;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import Default.Default_Button_Event;
import Default.Default_Frame;
import Login_Screen.Login_Background;
import Main_Screen.Main_Background;

public class Lobby_Back_Button extends Default_Button_Event{

	private ImageIcon LOBBY_BACK = new ImageIcon(Main_Background.class.getResource("/Image/LOBBY_SCREEN/LOBBY_BACK.png"));
	private ImageIcon LOBBY_BACK_ENTER = new ImageIcon(Main_Background.class.getResource("/Image/LOBBY_SCREEN/LOBBY_BACK_ENTER.png"));
	private Default_Frame DF;
	
	public Lobby_Back_Button(ImageIcon icon, Default_Frame DF) {
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
		setIcon(LOBBY_BACK_ENTER);//흰색으로 바뀜
		setCursor(new Cursor(Cursor.HAND_CURSOR));// 커서가 손가락 모양으로
	}

	@Override
	public void mouseExited(MouseEvent e) {
		setIcon(LOBBY_BACK);// 다시 원상태로
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// 커서가 기본으로
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		DF.getContentPane().removeAll();
		DF.add(new Login_Background(DF));//Select_Background 패널 불러옴 
		DF.revalidate();
	}
}
