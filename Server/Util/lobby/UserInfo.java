package lobby;

import java.io.DataInputStream;
import java.io.IOException;

import character.GameCharacter;
import common.Receive;
import common.Send;
import login.Login;

public class UserInfo implements Runnable {
	GameCharacter user;
	public UserInfo(GameCharacter user) {
		this.user = user;
	}
	
	public void run() {
		while(!Thread.currentThread().isInterrupted()) {
			try {
				String UserInfoData = Receive.ReceiveData(new DataInputStream(user.getUserInfo().getInputStream()));
				if(UserInfoData.equals("Logout")) {
					Send.sendData(user.getChatOut(), UserInfoData);
					Send.sendData(user.getRoomOut(), UserInfoData);
					break;
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			new Login(user.getUserInfo());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
