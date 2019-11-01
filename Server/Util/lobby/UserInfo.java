package lobby;

import java.io.IOException;
import character.GameCharacter;
import common.Disconnect_Socket;
import common.Option;
import common.Receive;
import common.Send;
import login.Login;

public class UserInfo implements Runnable {
	GameCharacter user;
	public UserInfo(GameCharacter user) {
		this.user = user;
	}
	
	public void run() {
		while(true) {
			try {

				String UserInfoData = Receive.ReceiveData(user.getUserIn());
				if(UserInfoData.equals("Logout")) {
					Send.sendData(user.getChatOut(), UserInfoData);
					Send.sendData(user.getRoomOut(), UserInfoData);
					
					Disconnect_Socket.Disconnect(user.getChat());
					Disconnect_Socket.Disconnect(user.getRoomInfo());

					
					Option.Stop = false;
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
