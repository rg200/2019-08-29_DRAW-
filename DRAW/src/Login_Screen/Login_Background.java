package Login_Screen;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Default.Default_Frame;
import Lobby_Screen.Lobby_Background;
import Main_Screen.Main_Background;
import Select_Screen.Select_Background;
import Util.AccessServer;

public class Login_Background extends JPanel{
	// 로그인 화면을 나타내는 클래스
	private Image Log_Background = new ImageIcon(Main_Background.class.getResource("/Image/LOGIN_SCREEN/LOGIN_SCREEN.png")).getImage();
	private ImageIcon LOGIN_BACK = new ImageIcon(Main_Background.class.getResource("/Image/LOGIN_SCREEN/LOGIN_BACK.png"));
	private ImageIcon LOGIN_BACK_ENTER = new ImageIcon(Main_Background.class.getResource("/Image/LOGIN_SCREEN/LOGIN_BACK_ENTER.png"));
	private ImageIcon LOGIN_IN = new ImageIcon(Main_Background.class.getResource("/Image/LOGIN_SCREEN/LOGIN_IN.png"));
	private ImageIcon LOGIN_ENTER = new ImageIcon(Main_Background.class.getResource("/Image/LOGIN_SCREEN/LOGIN_ENTER.png"));
	private Default_Frame DF;
	public static JTextField ID_TextField = new JTextField(); // 아이디 받아오기 위해 수정 private -> public static
	public static JPasswordField PW_TextField = new JPasswordField(); // 패스워드 받아오기 위해 수정 private -> public static
	private Login_Back_Button LBB;
	private Login_Button LB;
	
	public Login_Background(Default_Frame DF) {
		this.DF = DF;
		setSize(Default_Frame.SCREEN_WIDTH, Default_Frame.SCREEN_HEIGHT);
		setLayout(null); 
		LBB = new Login_Back_Button(LOGIN_BACK, DF);
		LB = new Login_Button(LOGIN_IN, DF);
		add(LB);	
		add(LBB);
		add(ID_TextField);
		add(PW_TextField);
		ID_TextField.setBounds(880, 380, 400, 100); // 아이디적는 텍스트 필드 생성
		ID_TextField.setBorder(null); // 택스트 필드 투명화
		ID_TextField.setFont(new Font("Stencil",Font.HANGING_BASELINE,50)); // 폰트 지정 
		ID_TextField.setOpaque(false);
		PW_TextField.setBounds(880, 615, 400, 100);
		PW_TextField.setBorder(null);
		PW_TextField.setFont(new Font("Stencil",Font.HANGING_BASELINE,50));
		PW_TextField.setOpaque(false);
		
		setVisible(true);
		
		// 네트워크
		AccessServer.AccessUserInfo();
		// 네트워크 끝

		
	}
	
	public void paintComponent(Graphics g) {

		g.drawImage(Log_Background, 0, 0, this.getWidth(), this.getHeight(), this);

	}

}
