package common;

import java.io.DataInputStream;
import java.io.IOException;

public class Receive {		
// �����͸� �Է¹���
	
	public static String ReceiveData(DataInputStream inData)  {
		try {
			return inData.readUTF();
		} catch (IOException e) {
			
			e.printStackTrace();
			return "Error";
		//	�����͸� ���� �޴� �ܰ迡�� ���ܰ� �߻��Ͽ��� ��� Error ��ȯ
		}
	}
}
