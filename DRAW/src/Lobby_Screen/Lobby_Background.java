package Lobby_Screen;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

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
	private JTextField Chat_TextField = new JTextField();
	private JTextArea Chat_TextArea = new JTextArea();
	private JScrollPane Chat_TextArea_Scroll = new JScrollPane(Chat_TextArea);
	
	// ��Ʈ��ũ
		private  Socket clientSocket = null;// Ŭ���̾�Ʈ ����
		private  DataInputStream inData = null;// ������ ��ǲ
		private  DataOutputStream outData = null; // ������ �ƿ�ǲ
		private Socket Chat = null;//	ä�� ����
		private DataInputStream inChat= null;//Receive�� �ʿ���
		private DataOutputStream outChat= null;
		private Socket RoomInfo= null;//	�� ���� ����
		private DataInputStream inRoomInfo= null;// 	��û�� ���� �ʿ���
		private DataOutputStream outRoomInfo= null;//������ �� �ʿ�
		
	public Lobby_Background(Default_Frame DF,Socket clientSocket) {
		this.DF = DF;
		setSize(Default_Frame.SCREEN_WIDTH, Default_Frame.SCREEN_HEIGHT);// ũ�� ����
		setLayout(null); 
		
		add(LOBBY_BUTTON);	
		add(LOBBY_BACKBUTTON);	
		add(Chat_TextField);
		add(Chat_TextArea_Scroll);
		Chat_TextArea_Scroll.setVisible(true);

		
		Chat_TextArea_Scroll.setBounds(50, 814, 1126, 128);
		Chat_TextArea_Scroll.getViewport().setOpaque(false);
		Chat_TextArea_Scroll.getViewport().setBorder(null);
		Chat_TextArea.setLineWrap(true);//�ڵ� �ٹٲٱ�
		Chat_TextArea_Scroll.setOpaque(false);
		Chat_TextArea_Scroll.setBorder(null);
		//Chat_TextArea_Scroll.getVerticalScrollBar().setBackground(Color.pink);
		Chat_TextArea_Scroll.getVerticalScrollBar().setUI(new ScrollBarUI());

		Chat_TextArea.setOpaque(false);
		Chat_TextArea.setBorder(null);
		Chat_TextArea.setFont(new Font("����",Font.BOLD,30));
		
		//Chat_TextArea.setBounds(48, 700, 1128, 130);
		/*Chat_TextArea.setColumns(1);
		Chat_TextArea.setRows(10);
		
		Chat_TextArea.setWrapStyleWord(true);
		Chat_TextArea.setCaretPosition(Chat_TextArea.getDocument().getLength());
		
		
		*/
		Chat_TextField.setBounds(48, 945, 1128, 65);
		Chat_TextField.setBorder(null);
		Chat_TextField.setFont(new Font("����",Font.BOLD,50));
		Chat_TextField.setOpaque(false);
		LOBBY_BACKBUTTON.setBorderPainted(false);
		LOBBY_BACKBUTTON.setFocusable(false);
		LOBBY_BACKBUTTON.setContentAreaFilled(false);
		LOBBY_BACKBUTTON.setBounds(1235,925, LOBBY_BACK.getIconWidth(), LOBBY_BACK.getIconHeight());
		
		LOBBY_BUTTON.setBorderPainted(false);
		LOBBY_BUTTON.setFocusable(false);
		LOBBY_BUTTON.setContentAreaFilled(false);
		LOBBY_BUTTON.setBounds(1235,810, LOBBY_BACK.getIconWidth(), LOBBY_BACK.getIconHeight());
		
		// ��Ʈ��ũ �κ� ����
		// �⺻ ȣ��Ʈ(�ڱ� �ڽ�)
		String host = "localhost";

		try {
			Chat = new Socket(host, 9001);
			outChat = new DataOutputStream(Chat.getOutputStream());
			inData = new DataInputStream(Chat.getInputStream());
			System.out.println("ä�ü��� ���� ����");

			RoomInfo = new Socket(host, 9002);
			outRoomInfo = new DataOutputStream(RoomInfo.getOutputStream());
			inRoomInfo = new DataInputStream(RoomInfo.getInputStream());
			System.out.println("���������� ���� ����");
		} catch (UnknownHostException e) {
			System.err.println("ȣ��Ʈ�� ã�� �� �����ϴ�." + host);
		} catch (IOException e) {
			System.err.println("Couldn't get I/O for the connection to the host " + host);
		}

		// ��Ʈ��ũ �κ� ��

			
		
		LOBBY_BUTTON.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				LOBBY_BUTTON.setIcon(LOBBY_ENTER);//������� �ٲ�
				LOBBY_BUTTON.setCursor(new Cursor(Cursor.HAND_CURSOR));// Ŀ���� �հ��� �������
			}

			@Override
			public void mouseExited(MouseEvent e) {
				LOBBY_BUTTON.setIcon(LOBBY_IN);// �ٽ� �����·�
				LOBBY_BUTTON.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// Ŀ���� �⺻����
			}

			@Override
			public void mousePressed(MouseEvent e) {
				DF.getContentPane().removeAll();
				DF.add(new Room_Background(DF));//Select_Background �г� �ҷ��� 
				DF.repaint();
			}
		});
		
		LOBBY_BACKBUTTON.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				LOBBY_BACKBUTTON.setIcon(LOBBY_BACK_ENTER);//������� �ٲ�
				LOBBY_BACKBUTTON.setCursor(new Cursor(Cursor.HAND_CURSOR));// Ŀ���� �հ��� �������
			}

			@Override
			public void mouseExited(MouseEvent e) {
				LOBBY_BACKBUTTON.setIcon(LOBBY_BACK);// �ٽ� �����·�
				LOBBY_BACKBUTTON.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// Ŀ���� �⺻����
			}

			@Override
			public void mousePressed(MouseEvent e) {
				DF.getContentPane().removeAll();
				DF.add(new Login_Background(DF));//Select_Background �г� �ҷ��� 
				DF.repaint();
			}
		});
	}
	

	public void paintComponent(Graphics g) {

		g.drawImage(Lob_Background, 0, 0, this.getWidth(), this.getHeight(), this);
		super.paintComponents(g);

	}

}