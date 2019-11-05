package common;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import character.GameCharacter;

public class Disconnect_User{
	
	public static void Disconnect(GameCharacter user,String Logout) throws IOException {
		Send.sendData(user.getChatOut(), Logout);
		Send.sendData(user.getRoomOut(), -1);
		Send.sendData(user.getRoomOut(), Logout);
		
		DisconnectSocket(user.getChat());
		DisconnectSocket(user.getRoomInfo());
		Option.Stop = false;
	}
	
	public static void DisconnectSocket(Socket socket) {
		try {
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("소켓을 닫을 수 없음");
		}
	}
	
	public static void DisconnectStream(DataInputStream inStream) {
		try {
			inStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("InputStream을 닫을 수 없음");
		}
	}
	
	public static void DisconnectStream(DataOutputStream outStream) {
		try {
			outStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("OutputStream을 닫을 수 없음");
		}
	}
}
