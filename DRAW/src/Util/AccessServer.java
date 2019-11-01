package Util;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import Default.Default_Frame;

public class AccessServer {
	//  �꽌踰꾩뿉 �젒�냽�븯湲� �쐞�빐 �궗�슜
	
	public static void AccessUserInfo() {
		try {
			Default_Frame.clientSocket = new Socket(InetAddress.getByName("127.0.0.1"), 9000);
			Default_Frame.outData = new DataOutputStream(Default_Frame.clientSocket.getOutputStream());
			Default_Frame.inData = new DataInputStream(Default_Frame.clientSocket.getInputStream());
		} catch (UnknownHostException e) {

			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Couldn't get I/O for the connection to the host ");
		}
	}
	
	public static void AccessRoomChat() {
		try {
			Default_Frame.Chat = new Socket(InetAddress.getByName("127.0.0.1"), 9001);
			Default_Frame.outChat = new DataOutputStream(Default_Frame.Chat.getOutputStream());
			Default_Frame.inChat = new DataInputStream(Default_Frame.Chat.getInputStream());
			System.out.println("실행됨");
		} catch (UnknownHostException e) {
			System.out.println("여기 실행됨");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Couldn't get I/O for the connection to the host ");
		}
		
		try {
			Default_Frame.RoomInfo = new Socket(InetAddress.getByName("127.0.0.1"), 9002);
			Default_Frame.outRoomInfo = new DataOutputStream(Default_Frame.RoomInfo.getOutputStream());
			Default_Frame.inRoomInfo = new DataInputStream(Default_Frame.RoomInfo.getInputStream());
			System.out.println("실행됨");
		} catch (UnknownHostException e) {
			System.out.println("여기 실행됨");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Couldn't get I/O for the connection to the host ");
		}
	}
}
