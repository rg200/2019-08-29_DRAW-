package Login_Screen;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Default.Default_Frame;
import Default.Default_Socket;
import Lobby_Screen.Lobby_Background;
import Lobby_Screen.Lobby_RoomInfo;
import Main_Screen.Main_Background;
import Util.AccessServer;

public class Login_Background extends JPanel implements KeyListener{
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
		PW_TextField.addKeyListener(this);
		setVisible(true);
		
		// 네트워크
		AccessServer.AccessUserInfo();
		// 네트워크 끝

		
	}
	public void keyPressed(KeyEvent e) { 
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			try {
				Default_Socket.getOutData().writeUTF(Login_Background.ID_TextField.getText() + ":" + Login_Background.PW_TextField.getText());
				Login_Background.ID_TextField.setText("");// id 값 초기화
				Login_Background.PW_TextField.setText("");// pw 값 
				System.out.println("ID PASS 일치");
				String awnser = Default_Socket.getInData().readUTF();
				if (awnser.equals("LoginAccept")) { // 로그인 성공
					DF.getContentPane().removeAll();
					DF.add(new Lobby_Background(DF));
					DF.revalidate();
					
					AccessServer.AccessRoomChat();
					Util.ChatThread CT = new Util.ChatThread();
					Lobby_RoomInfo LR = new Lobby_RoomInfo(DF);
				} else
					// 로그인 실패
					System.out.println("로그인 실패");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	
	public void paintComponent(Graphics g) {

		g.drawImage(Log_Background, 0, 0, this.getWidth(), this.getHeight(), this);

	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
