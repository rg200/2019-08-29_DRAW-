package Lobby_Screen;
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
import Room_Screen.Room_Background;

public class Lobby_Background extends JPanel{
	private Image Lob_Background = new ImageIcon(Main_Background.class.getResource("/Image/LOBBY_SCREEN/LOBBY_SCREEN.png")).getImage();
	private ImageIcon LOBBY_BACK = new ImageIcon(Main_Background.class.getResource("/Image/LOBBY_SCREEN/LOBBY_BACK.png"));
	private ImageIcon LOBBY_BACK_ENTER = new ImageIcon(Main_Background.class.getResource("/Image/LOBBY_SCREEN/LOBBY_BACK_ENTER.png"));
	private ImageIcon LOBBY_IN = new ImageIcon(Main_Background.class.getResource("/Image/LOBBY_SCREEN/LOBBY_JOIN.png"));
	private ImageIcon LOBBY_ENTER = new ImageIcon(Main_Background.class.getResource("/Image/LOBBY_SCREEN/LOBBY_JOIN_ENTER.png"));
	private JButton LOBBY_BACKBUTTON = new JButton(LOBBY_BACK);
	private JButton LOBBY_BUTTON = new JButton(LOBBY_IN);
	private Default_Frame DF;
	
	public Lobby_Background(Default_Frame DF) {
		this.DF = DF;
		setSize(Default_Frame.SCREEN_WIDTH, Default_Frame.SCREEN_HEIGHT);// 크기 고정
		setLayout(null); 
		
		add(LOBBY_BUTTON);	
		add(LOBBY_BACKBUTTON);	
		LOBBY_BACKBUTTON.setBorderPainted(false);
		LOBBY_BACKBUTTON.setFocusable(false);
		LOBBY_BACKBUTTON.setContentAreaFilled(false);
		LOBBY_BACKBUTTON.setBounds(1235,925, LOBBY_BACK.getIconWidth(), LOBBY_BACK.getIconHeight());
		
		LOBBY_BUTTON.setBorderPainted(false);
		LOBBY_BUTTON.setFocusable(false);
		LOBBY_BUTTON.setContentAreaFilled(false);
		LOBBY_BUTTON.setBounds(1235,810, LOBBY_BACK.getIconWidth(), LOBBY_BACK.getIconHeight());
		
		LOBBY_BUTTON.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				LOBBY_BUTTON.setIcon(LOBBY_ENTER);//흰색으로 바뀜
				LOBBY_BUTTON.setCursor(new Cursor(Cursor.HAND_CURSOR));// 커서가 손가락 모양으로
			}

			@Override
			public void mouseExited(MouseEvent e) {
				LOBBY_BUTTON.setIcon(LOBBY_IN);// 다시 원상태로
				LOBBY_BUTTON.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// 커서가 기본으로
			}

			@Override
			public void mousePressed(MouseEvent e) {
				DF.getContentPane().removeAll();
				DF.add(new Room_Background(DF));//Select_Background 패널 불러옴 
				DF.repaint();
			}
		});
		
		LOBBY_BACKBUTTON.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				LOBBY_BACKBUTTON.setIcon(LOBBY_BACK_ENTER);//흰색으로 바뀜
				LOBBY_BACKBUTTON.setCursor(new Cursor(Cursor.HAND_CURSOR));// 커서가 손가락 모양으로
			}

			@Override
			public void mouseExited(MouseEvent e) {
				LOBBY_BACKBUTTON.setIcon(LOBBY_BACK);// 다시 원상태로
				LOBBY_BACKBUTTON.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// 커서가 기본으로
			}

			@Override
			public void mousePressed(MouseEvent e) {
				DF.getContentPane().removeAll();
				DF.add(new Login_Background(DF));//Select_Background 패널 불러옴 
				DF.repaint();
			}
		});
	}
	

	public void paintComponent(Graphics g) {

		g.drawImage(Lob_Background, 0, 0, this.getWidth(), this.getHeight(), this);
		super.paintComponents(g);

	}

}
