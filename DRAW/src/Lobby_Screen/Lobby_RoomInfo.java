package Lobby_Screen;

import Default.Default_Frame;
import Util.ReceiveServer;

public class Lobby_RoomInfo implements Runnable{
//	방 정보를 받아오는 쓰레드
	public Lobby_RoomInfo() {
		new Thread(this).start();
	}
	
	@Override
	public void run() {

		while(!Thread.currentThread().isInterrupted()) {
			String st = ReceiveServer.ReceiveData(Default_Frame.inRoomInfo);
			System.out.println("받아옴");
			Lobby_Background.AddPlaylistButton(st);
		}
	}
}
