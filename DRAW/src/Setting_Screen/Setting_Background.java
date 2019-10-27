package Setting_Screen;

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
import Main_Screen.Main_Background;
import Select_Screen.Select_Background;

public class Setting_Background extends JPanel {
	
	private Image Set_Background = new ImageIcon(Main_Background.class.getResource("/Image/SETTING_SCREEN/SETTING_SCREEN.png")).getImage();
	private ImageIcon SETTING_BACK = new ImageIcon(Main_Background.class.getResource("/Image/SETTING_SCREEN/SETTING_BACK.png"));
	private ImageIcon SETTING_BACK_ENTER = new ImageIcon(Main_Background.class.getResource("/Image/SETTING_SCREEN/SETTING_BACK_ENTER.png"));
	private Default_Frame DF;
	private Setting_Back_Button SBB;
	
	public Setting_Background(Default_Frame DF) {
		this.DF = DF;
		setSize(Default_Frame.SCREEN_WIDTH, Default_Frame.SCREEN_HEIGHT);// 크기 고정
		setLayout(null); 
		SBB = new Setting_Back_Button(SETTING_BACK, DF);
		add(SBB);
		setVisible(true);

	}

	public void paintComponent(Graphics g) {
		g.drawImage(Set_Background, 0, 0, getWidth(), getHeight(), this);
		

	}

}
