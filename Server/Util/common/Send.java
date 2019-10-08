package common;

import java.io.DataOutputStream;
import java.io.IOException;

import lobby.Room;

public class Send {       
// 데이터를 전송
	
	public static void send(DataOutputStream outData,String Data) {
		try {
			outData.writeUTF(Data);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public static void sendAll(Room room) {
//	룸 클래스 미구현으로 인한 대기 상태	
	}
	
	public static void whisper() {
//	내부 기능 미구현으로 인한 대기 상태
	}
}
