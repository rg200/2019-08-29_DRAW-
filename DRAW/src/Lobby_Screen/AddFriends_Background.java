package Lobby_Screen;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Default.Default_Frame;
import Main_Screen.Main_Background;

public class AddFriends_Background extends JPanel{
	private Image FreindsAdd_Background = new ImageIcon(Main_Background.class.getResource("/Image/LOBBY_SCREEN/FRIENDS/FRIENDS_SCREEN.png")).getImage();
	private Default_Frame DF;
	
	
	public AddFriends_Background(Default_Frame DF) {
		this.DF = DF;
		setOpaque(false);
		setLayout(null);
		setBounds(100,200,1137, 485);
		
	}
	public void paintComponent(Graphics g) {
	
		g.drawImage(FreindsAdd_Background, 0, 0, this.getWidth(), this.getHeight(), this);		

	}
}
