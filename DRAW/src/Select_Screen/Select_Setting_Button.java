package Select_Screen;

import java.awt.Cursor;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import Default.Default_Button_Event;
import Default.Default_Frame;
import Main_Screen.Main_Background;
import Setting_Screen.Setting_Background;

public class Select_Setting_Button extends Default_Button_Event{
	private ImageIcon SETTING_ENTER = new ImageIcon(Main_Background.class.getResource("/Image/SELECT_SCREEN/SETTING_ENTER.png"));
	private ImageIcon SETTING_IN = new ImageIcon(Main_Background.class.getResource("/Image/SELECT_SCREEN/SETTING_IN.png"));
	private Default_Frame DF;
	
	public Select_Setting_Button(ImageIcon icon, Default_Frame DF) {
		this.DF = DF;
		setIcon(icon);
		setBorderPainted(false);
		setFocusable(false);
		setContentAreaFilled(false);
		setBounds(1068,541, SETTING_IN.getIconWidth(), SETTING_IN.getIconHeight());
		addMouseListener(this);
		setVisible(true);
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		setIcon(SETTING_ENTER);//흰색으로 바뀜
		setCursor(new Cursor(Cursor.HAND_CURSOR));// 커서가 손가락 모양으로
	}

	@Override
	public void mouseExited(MouseEvent e) {
		setIcon(SETTING_IN);// 다시 원상태로
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// 커서가 기본으로
	}

	@Override
	public void mousePressed(MouseEvent e) {
		DF.getContentPane().removeAll();
		DF.add(new Setting_Background(DF));//Select_Background 패널 불러옴 
		DF.revalidate();
	}
}
