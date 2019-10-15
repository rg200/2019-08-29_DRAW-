package Signup_Screen;
import java.awt.Cursor;
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

public class Signup_Background extends JPanel{
	private Image Sig_Background = new ImageIcon(Main_Background.class.getResource("/Image/SIGNUP_SCREEN/SIGNUP_SCREEN.png")).getImage();
	private ImageIcon SIGNUP_BACK = new ImageIcon(Main_Background.class.getResource("/Image/SIGNUP_SCREEN/SIGNUP_BACK.png"));
	private ImageIcon SIGNUP_BACK_ENTER = new ImageIcon(Main_Background.class.getResource("/Image/SIGNUP_SCREEN/SIGNUP_BACK_ENTER.png"));
	private ImageIcon SIGNUP_IN = new ImageIcon(Main_Background.class.getResource("/Image/SIGNUP_SCREEN/SIGNUP_IN.png"));
	private ImageIcon SIGNUP_ENTER = new ImageIcon(Main_Background.class.getResource("/Image/SIGNUP_SCREEN/SIGNUP_ENTER.png"));
	private JButton SIGNUP_BACKBUTTON = new JButton(SIGNUP_BACK);
	private JButton SIGNUP_BUTTON = new JButton(SIGNUP_IN);
	private Default_Frame DF;
	private Signup_Back_Button SBB;
	private Signup_Button SB;
	
	public Signup_Background(Default_Frame DF) {

		this.DF = DF;
		setSize(Default_Frame.SCREEN_WIDTH, Default_Frame.SCREEN_HEIGHT);// 크기 고정
		setLayout(null);
		SBB = new Signup_Back_Button(SIGNUP_BACK,DF);
		SB = new Signup_Button(SIGNUP_IN, DF);
		add(SIGNUP_BUTTON);	
		add(SBB);

		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		g.drawImage(Sig_Background, 0, 0, this.getWidth(), this.getHeight(), this);
		

	}

}
