package common;

import java.io.DataOutputStream;
import java.io.IOException;

import room.Room;

public class Send {       
// 전송
	
	public static void sendData(DataOutputStream outData,String data) {
		try {
			outData.writeUTF(data);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public static void sendData(DataOutputStream outData,int data) {
		try {
			outData.writeInt(data);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public static void sendAll(Room room) {
//	평소 전달	
	}
	
	public static void whisper() {
//	귓속말 기능
	}
}
