package Main_Screen;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import Default.Default_Frame;
import Select_Screen.Select_Background;

public class Main_Background extends JPanel {
	private Image M_Background = new ImageIcon(Main_Background.class.getResource("/Image/Background/MAINBACKGROUND.png")).getImage();
	private ImageIcon PRESS_ENTER_BLACK = new ImageIcon(Main_Background.class.getResource("/Image/Background/PRESS_BLACK.png"));
	private Default_Frame DF;
	private Press_Button Press;

	public Main_Background(Default_Frame DF) {
		
		this.DF = DF;
		Press = new Press_Button(PRESS_ENTER_BLACK, DF);
		add(Press);
		setSize(Default_Frame.SCREEN_WIDTH, Default_Frame.SCREEN_HEIGHT);// 크기 고정
		setLayout(null);	
		setVisible(true);
		

	}

	public void paintComponent(Graphics g) {	
		g.drawImage(M_Background, 0, 0, this.getWidth(),this.getHeight(),this);	
	}

}
