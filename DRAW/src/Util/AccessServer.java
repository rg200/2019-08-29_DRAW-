package Util;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import Default.Default_Frame;

public class AccessServer {
	// ������ ���� ���� Ŭ����
	
	public static void AccessUserInfo() {
		try {
			Default_Frame.clientSocket = new Socket(InetAddress.getByName("127.0.0.1"), 9000);
			Default_Frame.outData = new DataOutputStream(Default_Frame.clientSocket.getOutputStream());
			Default_Frame.inData = new DataInputStream(Default_Frame.clientSocket.getInputStream());
			System.out.println("��Ʈ��ũ ���� ����");
		} catch (UnknownHostException e) {
			System.err.println("�ּҰ� �߸� �Ǿ����ϴ�..");
		} catch (IOException e) {
			System.err.println("Couldn't get I/O for the connection to the host ");
		}
	}
	
	public static void AccessRoomChat() {
		try {
			Default_Frame.Chat = new Socket(InetAddress.getByName("127.0.0.1"), 9001);
			Default_Frame.outChat = new DataOutputStream(Default_Frame.Chat.getOutputStream());
			Default_Frame.inChat = new DataInputStream(Default_Frame.Chat.getInputStream());
			System.out.println("��Ʈ��ũ ���� ����");
		} catch (UnknownHostException e) {
			System.err.println("�ּҰ� �߸� �Ǿ����ϴ�..");
		} catch (IOException e) {
			System.err.println("Couldn't get I/O for the connection to the host ");
		}
		
		try {
			Default_Frame.RoomInfo = new Socket(InetAddress.getByName("127.0.0.1"), 9002);
			Default_Frame.outRoomInfo = new DataOutputStream(Default_Frame.RoomInfo.getOutputStream());
			Default_Frame.inRoomInfo = new DataInputStream(Default_Frame.RoomInfo.getInputStream());
			System.out.println("��Ʈ��ũ ���� ����");
		} catch (UnknownHostException e) {
			System.err.println("�ּҰ� �߸� �Ǿ����ϴ�..");
		} catch (IOException e) {
			System.err.println("Couldn't get I/O for the connection to the host ");
		}
	}
}
