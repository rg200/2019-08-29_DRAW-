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

import Default.Default_Frame;
import Login_Screen.Login_Background;
import Main_Screen.Main_Background;
import Room_Screen.Room_Background;

public class Lobby_Background extends JPanel {
	private static String newline = "\n";
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
		setSize(Default_Frame.SCREEN_WIDTH, Default_Frame.SCREEN_HEIGHT);// 크기 고정
		setLayout(null); 
		LBB = new Lobby_Back_Button(LOBBY_BACK, DF);
		LJB = new Lobby_Join_Button(LOBBY_IN, DF);
		LAB = new Lobby_AddFriends_Button(ADDFREIDNS, DF);
		AB = new AddFriends_Background(DF);
		LC = new Lobby_Chat();
		PL = new Play_List();
		add(LJB);	// join 버튼 추가 
		add(LBB);	// back 버튼 
		add(LC);	
		add(LAB);
		add(AB);
		add(PL);
		AB.setVisible(false);
		
	}
	


	public void paintComponent(Graphics g) {
		g.drawImage(Lob_Background, 0, 0, this.getWidth(), this.getHeight(), this);
	}


}
