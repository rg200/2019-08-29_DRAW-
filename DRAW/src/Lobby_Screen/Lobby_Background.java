package Lobby_Screen;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import Default.Default_Frame;
import Default.Default_ScrollBar_UI;
import Login_Screen.Login_Background;
import Main_Screen.Main_Background;
import Room_Screen.Room_Background;

public class Lobby_Background extends JPanel {
	private Image Lob_Background = new ImageIcon(Main_Background.class.getResource("/Image/LOBBY_SCREEN/LOBBY_SCREEN.png")).getImage();
	private ImageIcon LOBBY_BACK = new ImageIcon(Main_Background.class.getResource("/Image/LOBBY_SCREEN/LOBBY_BACK.png"));
	private ImageIcon LOBBY_IN = new ImageIcon(Main_Background.class.getResource("/Image/LOBBY_SCREEN/LOBBY_JOIN.png"));
	private ImageIcon ADDFREIDNS = new ImageIcon(Main_Background.class.getResource("/Image/LOBBY_SCREEN/LOBBY_ADDFRIENDS.png"));
	
	private Default_Frame DF;
	private Lobby_Back_Button LBB;  
	private Lobby_Join_Button LJB;
	private Lobby_Chat LC;
	private Lobby_AddFriends_Button LAB;
	private AddFriends_Background AB;
	private Play_List PL;
	
	public Lobby_Background(Default_Frame DF) {
		this.DF = DF;
		setSize(Default_Frame.SCREEN_WIDTH, Default_Frame.SCREEN_HEIGHT);// ũ�� ����
		setLayout(null); 
		LBB = new Lobby_Back_Button(LOBBY_BACK, DF);
		LJB = new Lobby_Join_Button(LOBBY_IN, DF);
		LAB = new Lobby_AddFriends_Button(ADDFREIDNS, this);
		AB = new AddFriends_Background(DF);
		LC = new Lobby_Chat();
		PL = new Play_List();
		add(LJB);	// join ��ư �߰� 
		add(LBB);	// back ��ư 
		add(LC);	
		add(LAB);
		add(AB);
		add(PL);
		AB.setVisible(false);
		
		// 네트워크 시작
				String host = "localhost";

				try {
					Default_Frame.Chat = new Socket(host, 9001);
					Default_Frame.outChat = new DataOutputStream(Default_Frame.Chat.getOutputStream());
					Default_Frame.inChat = new DataInputStream(Default_Frame.Chat.getInputStream());
					System.out.println("채팅 연결 성공");

					Default_Frame.RoomInfo = new Socket(host, 9002);
					Default_Frame.outRoomInfo = new DataOutputStream(Default_Frame.RoomInfo.getOutputStream());
					Default_Frame.inRoomInfo = new DataInputStream(Default_Frame.RoomInfo.getInputStream());
					System.out.println("방정보 연결 성공");
				} catch (UnknownHostException e) {
					System.err.println("호스트 못찾음." + host);
				} catch (IOException e) {
					System.err.println("Couldn't get I/O for the connection to the host " + host);
				}

		//네트워크 끝
	}
	
	public void setAB() {
		AB.setVisible(true);
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(Lob_Background, 0, 0, this.getWidth(), this.getHeight(), this);
	}

}
