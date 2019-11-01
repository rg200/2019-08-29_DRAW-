package Login_Screen;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.Socket;

import javax.swing.ImageIcon;

import Default.Default_Button_Event;
import Default.Default_Frame;
import Lobby_Screen.Lobby_Background;
import Lobby_Screen.Lobby_RoomInfo;
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
		setIcon(LOGIN_ENTER);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	@Override
	public void mouseExited(MouseEvent e) {
		setIcon(LOGIN_IN);
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		try {
			Default_Frame.outData.writeUTF(Login_Background.ID_TextField.getText() + ":" + Login_Background.PW_TextField.getText());
			Login_Background.ID_TextField.setText("");
			Login_Background.PW_TextField.setText("");
			System.out.println("ID PASS 일치");
			String awnser = Default_Frame.inData.readUTF();
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