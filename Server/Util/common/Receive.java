package common;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.SocketException;

public class Receive {		
// 데이터를 받아오는 클래스
	
	public static String ReceiveData(DataInputStream inData)  {
		try {
			System.out.println("받음");
			return inData.readUTF();
			
		} catch (IOException e) {
			System.out.println("발생");
		
			return "Error";
		//	통신이 갑자기 꺼질 경우 return
		} 
	}
	
	public static int ReceiveInt(DataInputStream inData) {
		try {
			return inData.readInt();
		} catch (IOException e) {

			return -1;
		//	통신이 갑자기 꺼질 경우 return
		}
	}
}
