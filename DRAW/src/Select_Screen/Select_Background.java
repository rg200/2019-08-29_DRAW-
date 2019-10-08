package Select_Screen;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import Default_Frame.Default_Frame;
import Login_Screen.Login_Background;
import Main_Screen.Main_Background;
import Setting_Screen.Setting_Background;
import Signup_Screen.Signup_Background;

public class Select_Background extends JPanel {

	private Image Sel_Background = new ImageIcon(Main_Background.class.getResource("/Image/SELECT_SCREEN/SELECT_BACKGROUND.png")).getImage();
	private ImageIcon LOGIN_ENTER = new ImageIcon(Main_Background.class.getResource("/Image/SELECT_SCREEN/LOGIN_ENTER.png"));
	private ImageIcon LOGIN_IN = new ImageIcon(Main_Background.class.getResource("/Image/SELECT_SCREEN/LOGIN_IN.png"));
	private ImageIcon SETTING_ENTER = new ImageIcon(Main_Background.class.getResource("/Image/SELECT_SCREEN/SETTING_ENTER.png"));
	private ImageIcon SETTING_IN = new ImageIcon(Main_Background.class.getResource("/Image/SELECT_SCREEN/SETTING_IN.png"));
	private ImageIcon SIGNUP_ENTER = new ImageIcon(Main_Background.class.getResource("/Image/SELECT_SCREEN/SIGNUP_ENTER.png"));
	private ImageIcon SIGNUP_IN = new ImageIcon(Main_Background.class.getResource("/Image/SELECT_SCREEN/SIGNUP_IN.png"));
	
	private JButton LOGIN_INBUTTON = new JButton(LOGIN_IN);
	private JButton SETTING_INBUTTON = new JButton(SETTING_IN);
	private JButton SIGNUP_INBUTTON = new JButton(SIGNUP_IN);

	private Default_Frame DF;

	public Select_Background(Default_Frame DF) {
		this.DF = DF;
		
		setSize(Default_Frame.SCREEN_WIDTH, Default_Frame.SCREEN_HEIGHT);// 크기 고정
		setLayout(null); 
		add(LOGIN_INBUTTON);
		add(SETTING_INBUTTON);
		add(SIGNUP_INBUTTON);
		LOGIN_INBUTTON.setBorderPainted(false);
		LOGIN_INBUTTON.setFocusable(false);
		LOGIN_INBUTTON.setContentAreaFilled(false);
		SETTING_INBUTTON.setBorderPainted(false);
		SETTING_INBUTTON.setFocusable(false);
		SETTING_INBUTTON.setContentAreaFilled(false);
		SIGNUP_INBUTTON.setBorderPainted(false);
		SIGNUP_INBUTTON.setFocusable(false);
		SIGNUP_INBUTTON.setContentAreaFilled(false);
		LOGIN_INBUTTON.setBounds(1066,223, LOGIN_IN.getIconWidth(), LOGIN_IN.getIconHeight());
		SIGNUP_INBUTTON.setBounds(1196,393, SIGNUP_IN.getIconWidth(), SIGNUP_IN.getIconHeight());
		SETTING_INBUTTON.setBounds(1072,558, SETTING_IN.getIconWidth(), SETTING_IN.getIconHeight());
		
		LOGIN_INBUTTON.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				LOGIN_INBUTTON.setIcon(LOGIN_ENTER);//흰색으로 바뀜
				LOGIN_INBUTTON.setCursor(new Cursor(Cursor.HAND_CURSOR));// 커서가 손가락 모양으로
			}

			@Override
			public void mouseExited(MouseEvent e) {
				LOGIN_INBUTTON.setIcon(LOGIN_IN);// 다시 원상태로
				LOGIN_INBUTTON.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// 커서가 기본으로
			}

			@Override
			public void mousePressed(MouseEvent e) {
				DF.getContentPane().removeAll();
				DF.add(new Login_Background(DF));
				DF.repaint();
			}
		});
		
		SIGNUP_INBUTTON.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				SIGNUP_INBUTTON.setIcon(SIGNUP_ENTER);//흰색으로 바뀜
				SIGNUP_INBUTTON.setCursor(new Cursor(Cursor.HAND_CURSOR));// 커서가 손가락 모양으로
			}

			@Override
			public void mouseExited(MouseEvent e) {
				SIGNUP_INBUTTON.setIcon(SIGNUP_IN);// 다시 원상태로
				SIGNUP_INBUTTON.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// 커서가 기본으로
			}

			@Override
			public void mousePressed(MouseEvent e) {
				DF.getContentPane().removeAll();
				DF.add(new Signup_Background(DF));
				DF.repaint();
			}
		});
		
		SETTING_INBUTTON.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				SETTING_INBUTTON.setIcon(SETTING_ENTER);//흰색으로 바뀜
				SETTING_INBUTTON.setCursor(new Cursor(Cursor.HAND_CURSOR));// 커서가 손가락 모양으로
			}

			@Override
			public void mouseExited(MouseEvent e) {
				SETTING_INBUTTON.setIcon(SETTING_IN);// 다시 원상태로
				SETTING_INBUTTON.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// 커서가 기본으로
			}

			@Override
			public void mousePressed(MouseEvent e) {
				DF.getContentPane().removeAll();
				DF.add(new Setting_Background(DF));//Select_Background 패널 불러옴 
				DF.repaint();
			}
		});
		
	}
	public void paintComponent(Graphics g) {
		
		g.drawImage(Sel_Background, 0, 0, this.getWidth(),this.getHeight(),this);
		super.paintComponents(g);
		
	}


}
