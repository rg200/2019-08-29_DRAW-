package Login_Screen;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.Socket;

import javax.swing.ImageIcon;

import Default.Default_Button_Event;
import Default.Default_Frame;
import Lobby_Screen.Lobby_Background;
import Main_Screen.Main_Background;
import Util.AccessServer;

public class Login_Button extends Default_Button_Event {
	
	private ImageIcon LOGIN_IN = new ImageIcon(Main_Background.class.getResource("/Image/LOGIN_SCREEN/LOGIN_IN.png"));
	private ImageIcon LOGIN_ENTER = new ImageIcon(Main_Background.class.getResource("/Image/LOGIN_SCREEN/LOGIN_ENTER.png"));
	private Default_Frame DF;
	
	public Login_Button(ImageIcon icon, Default_Frame DF) {
		this.DF = DF;
		setIcon(icon);
		setBorderPainted(false);
		setFocusable(false);
		setContentAreaFilled(false);

		setBounds(1158,710, icon.getIconWidth(), icon.getIconHeight());
		addMouseListener(this);
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		setIcon(LOGIN_ENTER);//占쏙옙占쏙옙占쏙옙占� 占쌕뀐옙
		setCursor(new Cursor(Cursor.HAND_CURSOR));// 커占쏙옙占쏙옙 占쌌곤옙占쏙옙 占쏙옙占쏙옙占쏙옙占�
	}

	@Override
	public void mouseExited(MouseEvent e) {
		setIcon(LOGIN_IN);// 占쌕쏙옙 占쏙옙占쏙옙占승뤄옙
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// 커占쏙옙占쏙옙 占썩본占쏙옙占쏙옙
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		try {
			Default_Frame.outData.writeUTF(Login_Background.ID_TextField.getText() + ":" + Login_Background.PW_TextField.getText());
			System.out.println("ID PASS 일치");
			String awnser = Default_Frame.inData.readUTF();
			if (awnser.equals("LoginAccept")) { // 로그인 성공
				AccessServer.AccessRoomChat();
				DF.getContentPane().removeAll();
				DF.add(new Lobby_Background(DF));
				DF.revalidate();
			} else
				// 로그인 실패
				System.out.println("로그인 실패");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
}