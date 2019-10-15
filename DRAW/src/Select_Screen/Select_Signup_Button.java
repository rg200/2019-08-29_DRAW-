package Select_Screen;

import java.awt.Cursor;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import Default.Default_Button_Event;
import Default.Default_Frame;
import Main_Screen.Main_Background;
import Signup_Screen.Signup_Background;

public class Select_Signup_Button extends Default_Button_Event{

	private ImageIcon SIGNUP_ENTER = new ImageIcon(Main_Background.class.getResource("/Image/SELECT_SCREEN/SIGNUP_ENTER.png"));
	private ImageIcon SIGNUP_IN = new ImageIcon(Main_Background.class.getResource("/Image/SELECT_SCREEN/SIGNUP_IN.png"));
	private Default_Frame DF;
	
	
	public Select_Signup_Button(ImageIcon icon, Default_Frame DF) {
		this.DF = DF;
		setIcon(icon);
		setBorderPainted(false);
		setFocusable(false);
		setContentAreaFilled(false);
		setBounds(1191,383, SIGNUP_IN.getIconWidth(), SIGNUP_IN.getIconHeight());
		addMouseListener(this);
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		setIcon(SIGNUP_ENTER);//������� �ٲ�
		setCursor(new Cursor(Cursor.HAND_CURSOR));// Ŀ���� �հ��� �������
	}

	@Override
	public void mouseExited(MouseEvent e) {
		setIcon(SIGNUP_IN);// �ٽ� �����·�
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// Ŀ���� �⺻����
	}

	@Override
	public void mousePressed(MouseEvent e) {
		DF.getContentPane().removeAll();
		DF.add(new Signup_Background(DF));
		DF.revalidate();
	}
}
