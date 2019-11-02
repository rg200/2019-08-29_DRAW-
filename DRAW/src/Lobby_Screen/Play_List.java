package Lobby_Screen;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class Play_List extends JPanel {
	// 방목록이 표시되는 패널을 나타넴 (영역이라고 생각하면 편함)
	public Play_List() {
		setLayout(new FlowLayout(FlowLayout.LEFT)); 
		setOpaque(false);
		setBounds(57, 260, 1110, 480);	
	}
}
