package common;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import login.Login;


public class Access {             
// Client 가 Server에 최초로 접속
	
	private ServerSocket Info;
	private Socket userInfo; 
	
	public Access() {
		
			try {
				Info = new ServerSocket(9000);      
			// 	서버와 클라이언트간 유저 정보 Port : 9000 
				
				while(true) {
			//	Server의 Main 쓰레드는 무한 반복을 하여 클라이언트의 접속을 기다림 
					
					userInfo = Info.accept(); 
					new Thread(new Login(userInfo));
				//	클라이언트가 접속하면 서버에서의 클라이언트 쓰레드를 생성해줌
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		
	}
	
}
