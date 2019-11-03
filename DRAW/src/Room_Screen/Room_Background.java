package Room_Screen;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import Default.Default_Frame;
import Main_Screen.Main_Background;

public class Room_Background extends JPanel{
	private Image Rom_Background = new ImageIcon(Main_Background.class.getResource("/Image/ROOM_SCREEN/ROOM_SCREEN.png")).getImage();
	private ImageIcon ROOM_BACK = new ImageIcon(Main_Background.class.getResource("/Image/ROOM_SCREEN/ROOM_BACK.png"));
	private ImageIcon ROOM_IN = new ImageIcon(Main_Background.class.getResource("/Image/ROOM_SCREEN/ROOM_START.png"));
	private Room_Chat RC;
	private Default_Frame DF;
	private Room_Back_Button RBB;
	private Room_Start_Button RSB;
	private Room_UserList RUL;
	
	public Room_Background(Default_Frame DF) {
		this.DF = DF;
		RC = new Room_Chat();
		RUL = new Room_UserList();
		setSize(Default_Frame.SCREEN_WIDTH, Default_Frame.SCREEN_HEIGHT);// ũ�� ����
		setLayout(null); 
		RBB= new Room_Back_Button(ROOM_BACK, DF);
		RSB= new Room_Start_Button(ROOM_IN, DF);
		add(RC);
		add(RSB);	
		add(RBB);	
		add(RUL);
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(Rom_Background, 0, 0, this.getWidth(), this.getHeight(), this);

	}

}
