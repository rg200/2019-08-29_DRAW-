package Lobby_Screen;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import AddFriends_screen.AddFriends_Background;
import Create_screen.Create_Background;
import Create_screen.PlayList_Button;
import Create_screen.User_List;
import Default.Default_Frame;
import Default.Default_ScrollBar_UI;
import Login_Screen.Login_Background;
import Main_Screen.Main_Background;
import Room_Screen.Room_Background;

public class Lobby_Background extends JPanel {
	// 로비 화면을 그려주는 패널 
	public static boolean Select = false;
	public static boolean Select1 = false;
	private Image Lob_Background = new ImageIcon(Main_Background.class.getResource("/Image/LOBBY_SCREEN/LOBBY_SCREEN.png")).getImage();
	private ImageIcon LOBBY_BACK = new ImageIcon(Main_Background.class.getResource("/Image/LOBBY_SCREEN/LOBBY_BACK.png"));
	private ImageIcon LOBBY_IN = new ImageIcon(Main_Background.class.getResource("/Image/LOBBY_SCREEN/LOBBY_JOIN.png"));
	private ImageIcon ADDFREIDNS = new ImageIcon(Main_Background.class.getResource("/Image/LOBBY_SCREEN/LOBBY_ADDFRIENDS.png"));
	private ImageIcon REFRESH_IN = new ImageIcon(Main_Background.class.getResource("/Image/LOBBY_SCREEN/LOBBY_REFRESH_BUTTON.png"));
	private ImageIcon CREATE = new ImageIcon(Main_Background.class.getResource("/Image/LOBBY_SCREEN/LOBBY_CREATE_BUTTON.png"));
	
	private Default_Frame DF;
	private Lobby_Back_Button LBB;  
	private Lobby_Join_Button LJB;
	private Lobby_Chat LC;
	private Lobby_AddFriends_Button LAB;
	private static AddFriends_Background AB;
	public static Play_List PL;
	private Lobby_Refresh_Button LRB;
	private Lobby_Create_Buttonn LCB;
	private static Create_Background CB;
	private static PlayerList_screen PLS;
	
	public Lobby_Background(Default_Frame DF) {
		this.DF = DF;
		setSize(Default_Frame.SCREEN_WIDTH, Default_Frame.SCREEN_HEIGHT);
		setLayout(null); 
		LBB = new Lobby_Back_Button(LOBBY_BACK, DF);
		LJB = new Lobby_Join_Button(LOBBY_IN, DF);
		PL = new Play_List();
		LAB = new Lobby_AddFriends_Button(ADDFREIDNS, this);
		LRB = new Lobby_Refresh_Button(REFRESH_IN, DF);
		LCB = new Lobby_Create_Buttonn(CREATE, this);
		AB = new AddFriends_Background(DF);
		CB = new Create_Background(DF);
		LC = new Lobby_Chat();		
		PLS = new PlayerList_screen();
		
		add(LJB);	
		add(LBB);		
		add(LAB);
		add(AB);
		add(CB);
		add(LRB);
		add(LCB);
		add(PLS);
		add(PL);
		add(LC);
		
		CB.setVisible(false);
		AB.setVisible(false);
		Util.UserInfo.getUserInfo();
		
	}
	
	public static void AddfriendsSetvisible() {
		// 친구추가 화면의 출력 상태를 바꿔주는 메소드
		Select = !Select;
		AB.setVisible(Select);
	}
	public static void CreateSetvisible() {
		// 방생성 화면의 출력 상태를 바꿔주는 메소드 
		Select1 = !Select1;
		CB.setVisible(Select1);
	}

	public static void AddUserlistButton(String userName) {
		PLS.add(new User_List(userName));
	}
	
	public static void AddPlaylistButton(String roomName, int roomNum, Default_Frame DF) {
		// 방 목록을 만들어 주는 메소드 
		PL.add(new PlayList_Button(roomName,roomNum,DF));
		PL.revalidate();
	}
	public void paintComponent(Graphics g) {
		g.drawImage(Lob_Background, 0, 0, this.getWidth(), this.getHeight(), this);
	}

}
