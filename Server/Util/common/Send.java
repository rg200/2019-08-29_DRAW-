package common;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import character.GameCharacter;
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

	public static  void sendAll(String data, ArrayList<GameCharacter> clients) {
//	평소 전달	
		for (GameCharacter gameCharacter : clients) {
			try {
				sendData(new DataOutputStream(gameCharacter.getChat().getOutputStream()),data);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void whisper() {
//	귓속말 기능
	}
}
