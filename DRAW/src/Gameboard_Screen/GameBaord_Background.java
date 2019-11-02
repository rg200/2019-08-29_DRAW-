package Gameboard_Screen;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import Default.Default_Frame;
import Main_Screen.Main_Background;

public class GameBaord_Background extends JPanel{
	// 게임 화면을 나타내는 패널 
	private Image GameBaord_Background = new ImageIcon(Main_Background.class.getResource("/Image/GAMEBOARD_SCREEN/GAMEBOARD_SCREEN.png")).getImage();
	private Default_Frame DF;
	
	public GameBaord_Background(Default_Frame DF) {
		this.DF = DF;
		setSize(Default_Frame.SCREEN_WIDTH, Default_Frame.SCREEN_HEIGHT);// Å©±â °íÁ¤
		setLayout(null); 
		
		
	}
	public void paintComponent(Graphics g) {
		g.drawImage(GameBaord_Background, 0, 0, this.getWidth(), this.getHeight(), this);

	}

}
