package lobby;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Chat implements Runnable {

	private Socket chat = null;
//	소켓이 필요할 수 있어서 일단 받아옴
	private DataInputStream inChat = null;
// 	Receive에 필요함
	private DataOutputStream outChat = null;

	public Chat(Socket chat) throws IOException {
		// inData, outData 정의하는데 발생하는 예외
		this.chat = chat;
		//클라이언트의 유저 정보 Socket을 받아옴
		this.inChat = new DataInputStream(chat.getInputStream());
		this.outChat = new DataOutputStream(chat.getOutputStream());
		common.Send.send(outChat, "접속하신걸 환영합니다.");
	}

	public void run() {
		System.out.println("채팅 쓰레드가 열렸다~");
	}
}
