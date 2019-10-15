package Main_Screen;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import Default.Default_Button_Event;
import Default.Default_Frame;
import Select_Screen.Select_Background;

public class Press_Button extends Default_Button_Event {

	private ImageIcon PRESS_ENTER_WHITE = new ImageIcon(Main_Background.class.getResource("/Image/Background/PRESS_WHITE.png"));
	private ImageIcon PRESS_ENTER_BLACK = new ImageIcon(Main_Background.class.getResource("/Image/Background/PRESS_BLACK.png"));
	private Default_Frame DF;

	public Press_Button(ImageIcon icon, Default_Frame DF) {
		this.DF = DF;
		setIcon(icon);
		setBorderPainted(false);
		setFocusable(false);
		setContentAreaFilled(false);
		setBounds(470, 450, icon.getIconWidth(), icon.getIconHeight());
		addMouseListener(this);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		setIcon(PRESS_ENTER_WHITE);// ������� �ٲ�
		setCursor(new Cursor(Cursor.HAND_CURSOR));// Ŀ���� �հ��� �������
	}

	@Override
	public void mouseExited(MouseEvent e) {
		setIcon(PRESS_ENTER_BLACK);// �ٽ� �����·�
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// Ŀ���� �⺻����
	}

	@Override
	public void mousePressed(MouseEvent e) {
		DF.getContentPane().removeAll();
		DF.add(new Select_Background(DF));// Select_Background �г� �ҷ���
		DF.revalidate();

	}
	public void mouseMoved(MouseEvent e) {
		setIcon(PRESS_ENTER_BLACK);
	}

}
