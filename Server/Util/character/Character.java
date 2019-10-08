package character;

import java.net.Socket;

public class Character{	
	// �ý��� ���� �κп��� ���Ǵ� character
	
	private String nickName;	// ������ �г���
	private Socket userInfo; 	// �α���, ���������� ��� ����
	private Socket chat;		// ä�ÿ� ��� ����
	private Socket roomInfo;	// �� ���� �ֽ�ȭ�� ��� ����
	
	private int channel;		// ä��
	private int roomNumber;		// ���ȣ
	
	public Character(String nickName,Socket userInfo, int channel){
		this.nickName = nickName;
		this.userInfo = userInfo;
		this.channel = channel;
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
	
	public int getChannel() {
		return channel;
	}

	public void setChannel(int channel) {
		this.channel = channel;
	}
}
