package character;

import java.net.Socket;

public class Character{	
	// 시스템 적인 부분에서 사용되는 character
	
	private String nickName;	// 유저의 닉네임
	private Socket userInfo; 	// 로그인, 유저정보등 통신 소켓
	private Socket chat;		// 채팅용 통신 소켓
	private Socket roomInfo;	// 방 정보 최신화용 통신 소켓
	
	private int channelNumber;		// 채널
	private int roomNumber;		// 방번호
	
	public Character(String nickName,Socket userInfo, int channelNumber){
		this.nickName = nickName;
		this.userInfo = userInfo;
		this.channelNumber = channelNumber;
		this.roomNumber = 0;
		// 최초 유저는 방번호 0인 로비에 접속하게 된다.
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
