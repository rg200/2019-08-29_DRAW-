package Room_Screen;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import Default.Default_Frame;
import Gameboard_Screen.GameBaord_Background;
import Lobby_Screen.Lobby_Background;
import Main_Screen.Main_Background;

public class Room_Background extends JPanel{
	private Image Rom_Background = new ImageIcon(Main_Background.class.getResource("/Image/ROOM_SCREEN/ROOM_SCREEN.png")).getImage();
	private ImageIcon ROOM_BACK = new ImageIcon(Main_Background.class.getResource("/Image/ROOM_SCREEN/ROOM_BACK.png"));
	private ImageIcon ROOM_IN = new ImageIcon(Main_Background.class.getResource("/Image/ROOM_SCREEN/ROOM_START.png"));
	
	private Default_Frame DF;
	private Room_Back_Button RBB;
	private Romm_Start_Button RSB;
	
	public Room_Background(Default_Frame DF) {
		this.DF = DF;
		setSize(Default_Frame.SCREEN_WIDTH, Default_Frame.SCREEN_HEIGHT);// 크기 고정
		setLayout(null); 
		RBB= new Room_Back_Button(ROOM_BACK, DF);
		RSB= new Romm_Start_Button(ROOM_IN, DF);
		add(RSB);	
		add(RBB);	
		


	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(Rom_Background, 0, 0, this.getWidth(), this.getHeight(), this);

	}

}
