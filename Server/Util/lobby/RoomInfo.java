package lobby;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class RoomInfo implements Runnable {
	private Socket roomInfo;
//	������ �ʿ��� �� �־ �ϴ� �޾ƿ�
	private DataInputStream request;
// 	Receive�� �ʿ���
	private DataOutputStream response;

	public RoomInfo(Socket roomInfo) {
		//Ŭ���̾�Ʈ�� ���� ���� Socket�� �޾ƿ�
		
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
		System.out.println("�� ���� �����尡 ���ȴ�~");
	}
}
