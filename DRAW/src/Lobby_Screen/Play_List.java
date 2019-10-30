package Lobby_Screen;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class Play_List extends JPanel implements ActionListener {
	
	public Play_List() {
		setLayout(new FlowLayout(FlowLayout.LEFT)); 
		setOpaque(false);
		setBounds(57, 260, 1110, 480);
		
	}
	
	public void actionPerformed(ActionEvent evt) {
		
	}

}
