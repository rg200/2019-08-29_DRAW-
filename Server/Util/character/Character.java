package character;

import java.net.Socket;

public class Character{	
	// �ý��� ���� �κп��� ���Ǵ� character
	
	private String nickName;	// ������ �г���
	private Socket userInfo; 	// �α���, ���������� ��� ����
	private Socket chat;		// ä�ÿ� ��� ����
	private Socket roomInfo;	// �� ���� �ֽ�ȭ�� ��� ����
	
	private int channelNumber;		// ä��
	private int roomNumber;		// ���ȣ
	
	public Character(String nickName,Socket userInfo, int channelNumber){
		this.nickName = nickName;
		this.userInfo = userInfo;
		this.channelNumber = channelNumber;
		this.roomNumber = 0;
		// ���� ������ ���ȣ 0�� �κ� �����ϰ� �ȴ�.
	}
	
	public String getNickName() {
		return nickName;
	}

	public Socket getUserInfo() {
		return userInfo;
	}

	public Socket getChat() {
		return chat;
	}

	public void setChat(Socket chat) {
		this.chat = chat;
	}

	public Socket getRoomInfo() {
		return roomInfo;
	}

	public void setRoomInfo(Socket roomInfo) {
		this.roomInfo = roomInfo;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	
	public int getChannelNumber() {
		return channelNumber;
	}

	public void setChannelNumber(int channelNumber) {
		this.channelNumber = channelNumber;
	}
}
