package Lobby_Screen;

import Default.Default_Frame;
import Util.ReceiveServer;

public class Lobby_RoomInfo implements Runnable{
//	방 정보를 받아옴
	public Lobby_RoomInfo() {
		new Thread(this).start();
	}
	
	@Override
	public void run() {

		while(true) {
			String st = ReceiveServer.ReceiveData(Default_Frame.inRoomInfo);
			if(st.equals("Logout")) 
				break;
			else 
				Lobby_Background.AddPlaylistButton(st);
			
		}
	}
}
