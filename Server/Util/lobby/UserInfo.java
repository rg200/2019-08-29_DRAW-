package lobby;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import character.GameCharacter;
import common.Disconnect_User;
import common.Receive;
import common.Send;
import login.Login;
import DB.*;
import DB.DAO.STDAO;

public class UserInfo implements Runnable {
	private GameCharacter user;
	private int channel;
	private DataOutputStream outUserInfo;
	private DataInputStream inUserInfo;
	
	public UserInfo(GameCharacter user) throws IOException {
		this.user = user;
		this.channel = user.getChannelNumber();
		outUserInfo = user.getUserOut();
		inUserInfo = user.getUserIn();
	}
	
	public void run() {
		while(true) {
			try {
				String UserInfoData = Receive.ReceiveData(inUserInfo);
				if(UserInfoData.equals("Logout")) {
					
					Disconnect_User.Disconnect(user,UserInfoData);
					STDAO.getInstance().update(user.getNickName(), "TB_STATE", 0, 0);
					break;
				}
				else if(UserInfoData.equals("UserInfo")) {
					
					int roomNum = Channel.getRoom(channel, user.getRoomNumber()).getRoomSize();
					
					for(int i = 0; i < roomNum; i++) {			
						Send.sendData(outUserInfo, Channel.getRoom(channel,user.getRoomNumber()).getUserName(i));
					}
					Send.sendData(outUserInfo, "End");
				}
				else if(UserInfoData.equals("Friend")) {
					
				}
			} catch (IOException e) {
				
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
