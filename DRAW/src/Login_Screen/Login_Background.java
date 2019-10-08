package Login_Screen;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Default_Frame.Default_Frame;
import Lobby_Screen.Lobby_Background;
import Main_Screen.Main_Background;
import Select_Screen.Select_Background;

public class Login_Background extends JPanel{
	private Image Log_Background = new ImageIcon(Main_Background.class.getResource("/Image/LOGIN_SCREEN/LOGIN_SCREEN.png")).getImage();
	private ImageIcon LOGIN_BACK = new ImageIcon(Main_Background.class.getResource("/Image/LOGIN_SCREEN/LOGIN_BACK.png"));
	private ImageIcon LOGIN_BACK_ENTER = new ImageIcon(Main_Background.class.getResource("/Image/LOGIN_SCREEN/LOGIN_BACK_ENTER.png"));
	private ImageIcon LOGIN_IN = new ImageIcon(Main_Background.class.getResource("/Image/LOGIN_SCREEN/LOGIN_IN.png"));
	private ImageIcon LOGIN_ENTER = new ImageIcon(Main_Background.class.getResource("/Image/LOGIN_SCREEN/LOGIN_ENTER.png"));
	private JButton LOGIN_BACKBUTTON = new JButton(LOGIN_BACK);
	private JButton LOGIN_BUTTON = new JButton(LOGIN_IN);
	private Default_Frame DF;
	private JTextField ID_TextField = new JTextField();
	private JTextField PW_TextField = new JTextField();
	
	public Login_Background(Default_Frame DF) {
		this.DF = DF;
		setSize(Default_Frame.SCREEN_WIDTH, Default_Frame.SCREEN_HEIGHT);// 크기 고정
		setLayout(null); 
		
		add(LOGIN_BUTTON);	
		add(LOGIN_BACKBUTTON);
		add(ID_TextField);
		add(PW_TextField);
		ID_TextField.setBounds(880, 380, 400, 100);
		ID_TextField.setBorder(null);
		ID_TextField.setFont(new Font("Stencil",Font.HANGING_BASELINE,50));
		ID_TextField.setOpaque(false);
		PW_TextField.setBounds(880, 615, 400, 100);
		PW_TextField.setBorder(null);
		PW_TextField.setFont(new Font("Stencil",Font.HANGING_BASELINE,50));
		PW_TextField.setOpaque(false);
		LOGIN_BACKBUTTON.setBorderPainted(false);
		LOGIN_BACKBUTTON.setFocusable(false);
		LOGIN_BACKBUTTON.setContentAreaFilled(false);
		LOGIN_BACKBUTTON.setBounds(35,340, LOGIN_BACK.getIconWidth(), LOGIN_BACK.getIconHeight());
		
		LOGIN_BUTTON.setBorderPainted(false);
		LOGIN_BUTTON.setFocusable(false);
		LOGIN_BUTTON.setContentAreaFilled(false);
		LOGIN_BUTTON.setBounds(1158,710, LOGIN_BACK.getIconWidth(), LOGIN_BACK.getIconHeight());
		setVisible(true);
		
		LOGIN_BUTTON.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				LOGIN_BUTTON.setIcon(LOGIN_ENTER);//흰색으로 바뀜
				LOGIN_BUTTON.setCursor(new Cursor(Cursor.HAND_CURSOR));// 커서가 손가락 모양으로
			}

			@Override
			public void mouseExited(MouseEvent e) {
				LOGIN_BUTTON.setIcon(LOGIN_IN);// 다시 원상태로
				LOGIN_BUTTON.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// 커서가 기본으로
			}

			@Override
			public void mousePressed(MouseEvent e) {
				DF.getContentPane().removeAll();
				DF.add(new Lobby_Background(DF));//Select_Background 패널 불러옴 
				DF.repaint();
				
			}
		});
		
		LOGIN_BACKBUTTON.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				LOGIN_BACKBUTTON.setIcon(LOGIN_BACK_ENTER);//흰색으로 바뀜
				LOGIN_BACKBUTTON.setCursor(new Cursor(Cursor.HAND_CURSOR));// 커서가 손가락 모양으로
			}

			@Override
			public void mouseExited(MouseEvent e) {
				LOGIN_BACKBUTTON.setIcon(LOGIN_BACK);// 다시 원상태로
				LOGIN_BACKBUTTON.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// 커서가 기본으로
			}

			@Override
			public void mousePressed(MouseEvent e) {
				DF.getContentPane().removeAll();
				DF.add(new Select_Background(DF));//Select_Background 패널 불러옴 
				DF.repaint();
			}
		});
		
	}
	
	public void paintComponent(Graphics g) {

		g.drawImage(Log_Background, 0, 0, this.getWidth(), this.getHeight(), this);
		super.paintComponents(g);

	}

}
