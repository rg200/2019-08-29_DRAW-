package common;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import login.Login;


public class Access {             
// Client �� Server�� ���ʷ� ����
	private ServerSocket ChatServer; // ä�� ���� ����
	private ServerSocket RoomInfoServer; // �� ���� ���� ����
	private ServerSocket Info;
	private Socket userInfo; 
	private Socket Chat;
	private Socket RoomInfo;
	public Access() {
		
			try {
				Info = new ServerSocket(9000);
				ChatServer = new ServerSocket(9001);
				RoomInfoServer = new ServerSocket(9002);
			// 	������ Ŭ���̾�Ʈ�� ���� ���� Port : 9000 
				
				while(true) {
			//	Server�� Main ������� ���� �ݺ��� �Ͽ� Ŭ���̾�Ʈ�� ������ ��ٸ� 
					userInfo = Info.accept();
					new Thread(new Login(userInfo)).start();
					Chat = ChatServer.accept();
					new Thread(new lobby.Chat(Chat)).start();
					RoomInfo = RoomInfoServer.accept();
					new Thread(new lobby.RoomInfo(RoomInfo)).start();
				//	Ŭ���̾�Ʈ�� �����ϸ� ���������� Ŭ���̾�Ʈ �����带 ��������
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		
	}
	
}
