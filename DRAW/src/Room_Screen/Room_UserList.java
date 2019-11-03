package Room_Screen;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Room_UserList extends JPanel {
	// 방안의 유저들이 있는 패널을 그리는 클래스 
	private Room_User_Button RUB;
	
	public Room_UserList() {
		setLayout(new FlowLayout(FlowLayout.LEFT));
		setOpaque(false);
		setBounds(57, 260, 1110, 480);
		RUB = new Room_User_Button();
		add(RUB);
		setVisible(true);
	}

}
