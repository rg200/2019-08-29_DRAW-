package common;

import java.io.DataOutputStream;
import java.io.IOException;

import lobby.Room;

public class Send {       
// �����͸� ����
	
	public static void send(DataOutputStream outData,String Data) {
		try {
			outData.writeUTF(Data);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public static void sendAll(Room room) {
//	�� Ŭ���� �̱������� ���� ��� ����	
	}
	
	public static void whisper() {
//	���� ��� �̱������� ���� ��� ����
	}
}
