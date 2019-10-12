package common;

import java.io.DataInputStream;
import java.io.IOException;

public class Receive {		
// 데이터를 입력받음
	
	public static String ReceiveData(DataInputStream inData)  {
		try {
			return inData.readUTF();
		} catch (IOException e) {
			
			e.printStackTrace();
			return "Error";
		//	데이터를 전송 받는 단계에서 예외가 발생하였을 경우 Error 반환
		}
	}
}
