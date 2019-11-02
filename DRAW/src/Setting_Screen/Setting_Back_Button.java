package Setting_Screen;

import java.awt.Cursor;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import Default.Default_Button_Event;
import Default.Default_Frame;
import Main_Screen.Main_Background;
import Select_Screen.Select_Background;

public class Setting_Back_Button extends Default_Button_Event{
	// 셋팅화면에서 셀렉 화면으로 가게 하는 버튼 
	private ImageIcon SETTING_BACK = new ImageIcon(Main_Background.class.getResource("/Image/SETTING_SCREEN/SETTING_BACK.png"));
	private ImageIcon SETTING_BACK_ENTER = new ImageIcon(Main_Background.class.getResource("/Image/SETTING_SCREEN/SETTING_BACK_ENTER.png"));
	private Default_Frame DF;
	
	public Setting_Back_Button(ImageIcon icon, Default_Frame DF) {
		this.DF = DF;
		setIcon(icon);
		setBorderPainted(false);
		setFocusable(false);
		setContentAreaFilled(false);
		setBounds(34,326, icon.getIconWidth(), icon.getIconHeight());
		addMouseListener(this);
		setVisible(true);
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		setIcon(SETTING_BACK_ENTER);//흰색으로 바뀜
		setCursor(new Cursor(Cursor.HAND_CURSOR));// 커서가 손가락 모양으로
	}

	@Override
	public void mouseExited(MouseEvent e) {
		setIcon(SETTING_BACK);// 다시 원상태로
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// 커서가 기본으로
	}

	@Override
	public void mousePressed(MouseEvent e) {
		DF.getContentPane().removeAll();
		DF.add(new Select_Background(DF));//Select_Background 패널 불러옴 
		DF.revalidate();
	}
}
