package common;

import java.io.DataOutputStream;
import java.io.IOException;

import room.Room;

public class Send {       
// �����͸� ����
	
	public static void sendData(DataOutputStream outData,String data) {
		try {
			outData.writeUTF(data);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public static void sendInt(DataOutputStream outData,int data) {
		try {
			outData.writeInt(data);
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
