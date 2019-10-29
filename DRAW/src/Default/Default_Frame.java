package Default;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import javax.swing.JFrame;

import Main_Screen.Main_Background;


public class Default_Frame extends JFrame {
	
	//네트워크
	public static Socket clientSocket = null;// 기본 접속 정보 => 유저정보 소켓
	public static DataInputStream inData = null;// 기본 접속 정보 => 유저정보 수신
	public static DataOutputStream outData = null; // 기본 접속 정보 => 유저정보 송신
	public static Socket Chat = null;//	채팅 소켓
	public static DataInputStream inChat= null; // 채팅 수신
	public static DataOutputStream outChat= null; // 채팅 송신
	public static Socket RoomInfo= null;//	방정보 소켓
	public static DataInputStream inRoomInfo= null;// 	방정보 수신
	public static DataOutputStream outRoomInfo= null;// 방정보 송신
	
	public static final int SCREEN_WIDTH = 1680;
	public static final int SCREEN_HEIGHT = 1050;
	
	public Default_Frame() {
		
		add(new Main_Background(this));
		setSize(Default_Frame.SCREEN_WIDTH, Default_Frame.SCREEN_HEIGHT);// ũ�� ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Draw!");
		setResizable(false);// ũ�� ���� �Ұ�
		setLocationRelativeTo(null);// ���۽� ������ �߾� ��ġ	
		setVisible(true);
	}
	public static void main(String[] args) {
		new Default_Frame();
	}

}