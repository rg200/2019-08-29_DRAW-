package lobby;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Chat implements Runnable {

	private Socket chat = null;
//	������ �ʿ��� �� �־ �ϴ� �޾ƿ�
	private DataInputStream inChat = null;
// 	Receive�� �ʿ���
	private DataOutputStream outChat = null;

	public Chat(Socket chat) throws IOException {
		// inData, outData �����ϴµ� �߻��ϴ� ����
		this.chat = chat;
		//Ŭ���̾�Ʈ�� ���� ���� Socket�� �޾ƿ�
		this.inChat = new DataInputStream(chat.getInputStream());
		this.outChat = new DataOutputStream(chat.getOutputStream());
		common.Send.send(outChat, "�����ϽŰ� ȯ���մϴ�.");
	}

	public void run() {
		System.out.println("ä�� �����尡 ���ȴ�~");
	}
}
