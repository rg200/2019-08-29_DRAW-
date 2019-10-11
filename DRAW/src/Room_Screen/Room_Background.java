package Room_Screen;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import Default_Frame.Default_Frame;
import Gameboard_Screen.GameBaord_Background;
import Lobby_Screen.Lobby_Background;
import Main_Screen.Main_Background;

public class Room_Background extends JPanel{
	private Image Rom_Background = new ImageIcon(Main_Background.class.getResource("/Image/ROOM_SCREEN/ROOM_SCREEN.png")).getImage();
	private ImageIcon ROOM_BACK = new ImageIcon(Main_Background.class.getResource("/Image/ROOM_SCREEN/ROOM_BACK.png"));
	private ImageIcon ROOM_BACK_ENTER = new ImageIcon(Main_Background.class.getResource("/Image/ROOM_SCREEN/ROOM_BACK_ENTER.png"));
	private ImageIcon ROOM_IN = new ImageIcon(Main_Background.class.getResource("/Image/ROOM_SCREEN/ROOM_START.png"));
	private ImageIcon ROOM_ENTER = new ImageIcon(Main_Background.class.getResource("/Image/ROOM_SCREEN/ROOM_START_ENTER.png"));
	private JButton ROOM_BACKBUTTON = new JButton(ROOM_BACK);
	private JButton ROOM_BUTTON = new JButton(ROOM_IN);
	private Default_Frame DF;
	
	//��Ʈ��ũ 
	private  Socket clientSocket = null;// Ŭ���̾�Ʈ ����
	
	public Room_Background(Default_Frame DF) {
		this.DF = DF;
		setSize(Default_Frame.SCREEN_WIDTH, Default_Frame.SCREEN_HEIGHT);// ũ�� ����
		setLayout(null); 
		
		add(ROOM_BUTTON);	
		add(ROOM_BACKBUTTON);	
		ROOM_BACKBUTTON.setBorderPainted(false);
		ROOM_BACKBUTTON.setFocusable(false);
		ROOM_BACKBUTTON.setContentAreaFilled(false);
		ROOM_BACKBUTTON.setBounds(1235,925, ROOM_BACK.getIconWidth(), ROOM_BACK.getIconHeight());
		
		ROOM_BUTTON.setBorderPainted(false);
		ROOM_BUTTON.setFocusable(false);
		ROOM_BUTTON.setContentAreaFilled(false);
		ROOM_BUTTON.setBounds(1235,810, ROOM_BACK.getIconWidth(), ROOM_BACK.getIconHeight());
		
		ROOM_BUTTON.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				ROOM_BUTTON.setIcon(ROOM_ENTER);//������� �ٲ�
				ROOM_BUTTON.setCursor(new Cursor(Cursor.HAND_CURSOR));// Ŀ���� �հ��� �������
			}

			@Override
			public void mouseExited(MouseEvent e) {
				ROOM_BUTTON.setIcon(ROOM_IN);// �ٽ� �����·�
				ROOM_BUTTON.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// Ŀ���� �⺻����
			}

			@Override
			public void mousePressed(MouseEvent e) {
				DF.getContentPane().removeAll();
				DF.add(new GameBaord_Background(DF));//Select_Background �г� �ҷ��� 
				DF.repaint();
			}
		});
		
		ROOM_BACKBUTTON.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				ROOM_BACKBUTTON.setIcon(ROOM_BACK_ENTER);//������� �ٲ�
				ROOM_BACKBUTTON.setCursor(new Cursor(Cursor.HAND_CURSOR));// Ŀ���� �հ��� �������
			}

			@Override
			public void mouseExited(MouseEvent e) {
				ROOM_BACKBUTTON.setIcon(ROOM_BACK);// �ٽ� �����·�
				ROOM_BACKBUTTON.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// Ŀ���� �⺻����
			}

			@Override
			public void mousePressed(MouseEvent e) {
				DF.getContentPane().removeAll();
				DF.add(new Lobby_Background(DF,clientSocket));//Select_Background �г� �ҷ��� 
				DF.repaint();
			}
		});
		
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(Rom_Background, 0, 0, this.getWidth(), this.getHeight(), this);
		super.paintComponents(g);

	}

}
