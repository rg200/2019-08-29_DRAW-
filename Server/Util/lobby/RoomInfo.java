package lobby;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class RoomInfo implements Runnable {
	private Socket roomInfo;
//	소켓이 필요할 수 있어서 일단 받아옴
	private DataInputStream request;
// 	Receive에 필요함
	private DataOutputStream response;

	public RoomInfo(Socket roomInfo) {
		//클라이언트의 유저 정보 Socket을 받아옴
		
		try {
			this.roomInfo = roomInfo;
			this.request = new DataInputStream(roomInfo.getInputStream());
			this.response = new DataOutputStream(roomInfo.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void run() {
		System.out.println("룸 인포 쓰레드가 열렸다~");
	}
}