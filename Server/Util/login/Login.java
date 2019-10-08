package login;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import common.Receive;
public class Login implements Runnable {           
// ����ڰ� �����Ͽ� �α���
	private String Login_Receive_Data;
	private String ID = "hjp";
	private String PASS = "1234";
	private Socket userInfo;
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
			String[] words = Login_Receive_Data.split(":");
			System.out.println(words[0]+words[1]);
			if(words[0].equals(ID) && words[1].equals(PASS)) {
				System.out.println("���� �α��� ����");
				common.Send.send(outData, "LoginAccept");
				
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
