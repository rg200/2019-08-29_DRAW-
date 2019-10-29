package Util;

import java.io.DataOutputStream;
import java.io.IOException;

public class SendServer {
	public static void SendData(DataOutputStream out, String data) {
		try {
			out.writeUTF(data);
		} catch (IOException e) {
			// TODO 자동 생성된 catch 블록
			e.printStackTrace();
		}
	}
	
	public static void SendData(DataOutputStream out, int data) {
		try {
			out.writeInt(data);
		} catch (IOException e) {
			// TODO 자동 생성된 catch 블록
			e.printStackTrace();
		}
	}
}
