package Util;

import Default.Default_Socket;
import Lobby_Screen.Lobby_Background;

public class UserInfo {
	
	public static void getUserInfo() {
		// 유저 정보를 받아오는 메서드
		SendServer.SendData(Default_Socket.getOutData(), "UserInfo");
		
		String userName = ReceiveServer.ReceiveData(Default_Socket.getInData());
		while(!userName.equals("End")){
			Lobby_Background.AddUserlistButton(userName);
			userName = ReceiveServer.ReceiveData(Default_Socket.getInData());
		}
	}
}
