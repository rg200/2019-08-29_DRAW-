package login;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import character.GameCharacter;
import common.Receive;
import lobby.Channel;
public class Login implements Runnable {           
// ����ڰ� �����Ͽ� �α���
	private ServerSocket ChatServer; // ä�� ���� ����
	private ServerSocket RoomInfoServer; // �� ���� ���� ����
	
	private Socket userInfo; // ó���� �α��� -> ����&ģ������ ����
	private Socket Chat; // ä�� ����
	private Socket RoomInfo; // ������ ����
	
	private String Login_Receive_Data; // �α����� �� �޾ƿ��� ������ �����ϴ� ��Ʈ��
	private String ID = "hjp"; //����� ���̵�
	private String PASS = "1234"; // ����� �н�����
	
//	������ �ʿ��� �� �־ �ϴ� �޾ƿ�
	private DataInputStream inData;
// 	Receive�� �ʿ���
	private DataOutputStream outData;
//	Send�� �ʿ���
	public Login(Socket userInfo) throws IOException {
								//inData, outData �����ϴµ� �߻��ϴ� ���� 
		this.userInfo = userInfo;
	// 	Ŭ���̾�Ʈ�� ���� ���� Socket�� �޾ƿ�
		this.inData = new DataInputStream(userInfo.getInputStream());
		this.outData = new DataOutputStream(userInfo.getOutputStream());
	}

	public void run() {
		// TODO �ڵ� ������ �޼ҵ� ����
		while(true) {
			Login_Receive_Data = Receive.ReceiveData(inData);
			if(Login_Receive_Data.startsWith("System"))
				break; // �α���ȭ�鿡�� �ڷΰ��� ��ȣ�� ���� ��
			else {
			String[] words = Login_Receive_Data.split(":"); // ���̵�:�н������ ���� ���� ó��
			System.out.println(words[0]+words[1]); //Ȯ�ο� ���߿� ����
			if(words[0].equals(ID) && words[1].equals(PASS)) { // ��
				System.out.println("���� �α��� ����");
				common.Send.send(outData, "LoginAccept");
				
				// �α��� ������ ���� ������ ��� ĳ���� ��ü & ä�ΰ�ü ���� 
				GameCharacter user = new GameCharacter(words[0], userInfo, 0); 
				Channel ch = new Channel(user, 0);
				
				//ä���� ���� ������ �����ؾ� ������, ���� ä�μ����� ��� ����Ʈ�� 0 �� �����´�.
				
			}
			else
				common.Send.send(outData, "LoginFailed");
			}
		}
		try {
			inData.close();
		    outData.close();
		    userInfo.close();
		} catch (IOException e) {
			// TODO �ڵ� ������ catch ���
			e.printStackTrace();
		}
	}
}
