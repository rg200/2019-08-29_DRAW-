package Signup_Screen;

import java.awt.Cursor;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import Default.Default_Button_Event;
import Default.Default_Frame;
import Main_Screen.Main_Background;
import Select_Screen.Select_Background;

public class Signup_Back_Button extends Default_Button_Event{
	private ImageIcon SIGNUP_BACK = new ImageIcon(Main_Background.class.getResource("/Image/SIGNUP_SCREEN/SIGNUP_BACK.png"));
	private ImageIcon SIGNUP_BACK_ENTER = new ImageIcon(Main_Background.class.getResource("/Image/SIGNUP_SCREEN/SIGNUP_BACK_ENTER.png"));
	private Default_Frame DF;
	
	public  Signup_Back_Button(ImageIcon icon, Default_Frame DF) {
		this.DF = DF;
		setIcon(icon);
		setBorderPainted(false);
		setFocusable(false);
		setContentAreaFilled(false);
		setBounds(34,326, icon.getIconWidth(), icon.getIconHeight());
		addMouseListener(this);
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		setIcon(SIGNUP_BACK_ENTER);//������� �ٲ�
		setCursor(new Cursor(Cursor.HAND_CURSOR));// Ŀ���� �հ��� �������
	}

	@Override
	public void mouseExited(MouseEvent e) {
		setIcon(SIGNUP_BACK);// �ٽ� �����·�
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// Ŀ���� �⺻����
	}

	@Override
	public void mousePressed(MouseEvent e) {
		DF.getContentPane().removeAll();
		DF.add(new Select_Background(DF));//Select_Background �г� �ҷ��� 
		DF.revalidate();
	}
}
