package Lobby_Screen;

import Default.Default_Frame;
import Util.ReceiveServer;

public class Lobby_RoomInfo implements Runnable{
//	�� ������ �޾ƿ��� ������
	public Lobby_RoomInfo() {
		new Thread(this).start();
	}
	
	@Override
	public void run() {

		while(!Thread.currentThread().isInterrupted()) {
			String st = ReceiveServer.ReceiveData(Default_Frame.inRoomInfo);
			/*if(st.equals("Logout")) {
				Thread.currentThread().interrupt();
			}*/
			System.out.println("�޾ƿ�");
			Lobby_Background.AddPlaylistButton(st);
			
		}
		//System.out.println("shutDouwn");
	}
}
