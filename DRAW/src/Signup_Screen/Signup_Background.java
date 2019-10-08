package Signup_Screen;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import Default_Frame.Default_Frame;
import Main_Screen.Main_Background;
import Select_Screen.Select_Background;

public class Signup_Background extends JPanel{
	private Image Sig_Background = new ImageIcon(Main_Background.class.getResource("/Image/SIGNUP_SCREEN/SIGNUP_SCREEN.png")).getImage();
	private ImageIcon SIGNUP_BACK = new ImageIcon(Main_Background.class.getResource("/Image/SIGNUP_SCREEN/SIGNUP_BACK.png"));
	private ImageIcon SIGNUP_BACK_ENTER = new ImageIcon(Main_Background.class.getResource("/Image/SIGNUP_SCREEN/SIGNUP_BACK_ENTER.png"));
	private ImageIcon SIGNUP_IN = new ImageIcon(Main_Background.class.getResource("/Image/SIGNUP_SCREEN/SIGNUP_IN.png"));
	private ImageIcon SIGNUP_ENTER = new ImageIcon(Main_Background.class.getResource("/Image/SIGNUP_SCREEN/SIGNUP_ENTER.png"));
	private JButton SIGNUP_BACKBUTTON = new JButton(SIGNUP_BACK);
	private JButton SIGNUP_BUTTON = new JButton(SIGNUP_IN);
	private Default_Frame DF;
	
	public Signup_Background(Default_Frame DF) {

		this.DF = DF;
		setSize(Default_Frame.SCREEN_WIDTH, Default_Frame.SCREEN_HEIGHT);// 크기 고정
		setLayout(null); 
		
		add(SIGNUP_BUTTON);	
		add(SIGNUP_BACKBUTTON);	
		SIGNUP_BACKBUTTON.setBorderPainted(false);
		SIGNUP_BACKBUTTON.setFocusable(false);
		SIGNUP_BACKBUTTON.setContentAreaFilled(false);
		SIGNUP_BACKBUTTON.setBounds(35,340, SIGNUP_BACK.getIconWidth(), SIGNUP_BACK.getIconHeight());
		
		SIGNUP_BUTTON.setBorderPainted(false);
		SIGNUP_BUTTON.setFocusable(false);
		SIGNUP_BUTTON.setContentAreaFilled(false);
		SIGNUP_BUTTON.setBounds(1158,710, SIGNUP_BACK.getIconWidth(), SIGNUP_BACK.getIconHeight());
		
		SIGNUP_BUTTON.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				SIGNUP_BUTTON.setIcon(SIGNUP_ENTER);//흰색으로 바뀜
				SIGNUP_BUTTON.setCursor(new Cursor(Cursor.HAND_CURSOR));// 커서가 손가락 모양으로
			}

			@Override
			public void mouseExited(MouseEvent e) {
				SIGNUP_BUTTON.setIcon(SIGNUP_IN);// 다시 원상태로
				SIGNUP_BUTTON.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// 커서가 기본으로
			}

			@Override
			public void mousePressed(MouseEvent e) {
				
			}
		});
		
		SIGNUP_BACKBUTTON.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				SIGNUP_BACKBUTTON.setIcon(SIGNUP_BACK_ENTER);//흰색으로 바뀜
				SIGNUP_BACKBUTTON.setCursor(new Cursor(Cursor.HAND_CURSOR));// 커서가 손가락 모양으로
			}

			@Override
			public void mouseExited(MouseEvent e) {
				SIGNUP_BACKBUTTON.setIcon(SIGNUP_BACK);// 다시 원상태로
				SIGNUP_BACKBUTTON.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// 커서가 기본으로
			}

			@Override
			public void mousePressed(MouseEvent e) {
				DF.getContentPane().removeAll();
				DF.add(new Select_Background(DF));//Select_Background 패널 불러옴 
				DF.repaint();
			}
		});
		
	}
	
	public void paintComponent(Graphics g) {

		g.drawImage(Sig_Background, 0, 0, this.getWidth(), this.getHeight(), this);
		super.paintComponents(g);

	}

}
