package Select_Screen;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import Default.Default_Frame;
import Login_Screen.Login_Background;
import Main_Screen.Main_Background;
import Setting_Screen.Setting_Background;
import Signup_Screen.Signup_Background;

public class Select_Background extends JPanel {

	private Image Sel_Background = new ImageIcon(Main_Background.class.getResource("/Image/SELECT_SCREEN/SELECT_BACKGROUND.png")).getImage();
	private ImageIcon LOGIN_ENTER = new ImageIcon(Main_Background.class.getResource("/Image/SELECT_SCREEN/LOGIN_ENTER.png"));
	private ImageIcon LOGIN_IN = new ImageIcon(Main_Background.class.getResource("/Image/SELECT_SCREEN/LOGIN_IN.png"));
	private ImageIcon SETTING_ENTER = new ImageIcon(Main_Background.class.getResource("/Image/SELECT_SCREEN/SETTING_ENTER.png"));
	private ImageIcon SETTING_IN = new ImageIcon(Main_Background.class.getResource("/Image/SELECT_SCREEN/SETTING_IN.png"));
	private ImageIcon SIGNUP_ENTER = new ImageIcon(Main_Background.class.getResource("/Image/SELECT_SCREEN/SIGNUP_ENTER.png"));
	private ImageIcon SIGNUP_IN = new ImageIcon(Main_Background.class.getResource("/Image/SELECT_SCREEN/SIGNUP_IN.png"));


	private Default_Frame DF;
	private Select_Login_Button SLB;
	private Select_Setting_Button SSB;
	private Select_Signup_Button SSiB;

	public Select_Background(Default_Frame DF) {
		this.DF = DF;
		
		setSize(Default_Frame.SCREEN_WIDTH, Default_Frame.SCREEN_HEIGHT);// 크기 고정
		setLayout(null);
		SLB = new Select_Login_Button(LOGIN_IN, DF);
		SSB = new Select_Setting_Button(SETTING_IN, DF);
		SSiB = new Select_Signup_Button(SIGNUP_IN, DF);
		add(SLB);
		add(SSB);
		add(SSiB);		
		setVisible(true);
		
	}
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		g.drawImage(Sel_Background, 0, 0, this.getWidth(),this.getHeight(),this);
		
		
	}


}
