package common;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import login.Login;


public class Access {             
// Client �� Server�� ���ʷ� ����
	
	private ServerSocket Info;
	private Socket userInfo; 
	
	public Access() {
		
			try {
				Info = new ServerSocket(9000);      
			// 	������ Ŭ���̾�Ʈ�� ���� ���� Port : 9000 
				
				while(true) {
			//	Server�� Main ������� ���� �ݺ��� �Ͽ� Ŭ���̾�Ʈ�� ������ ��ٸ� 
					
					userInfo = Info.accept(); 
					new Thread(new Login(userInfo));
				//	Ŭ���̾�Ʈ�� �����ϸ� ���������� Ŭ���̾�Ʈ �����带 ��������
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		
	}
	
}
