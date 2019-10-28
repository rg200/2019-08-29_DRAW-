package room;

import java.util.ArrayList;

import character.GameCharacter;

public class Room  {
	// 방 클래스 아직 미구현
	public static int roomNum = 1;
	private ArrayList<GameCharacter> clients = new ArrayList<GameCharacter>();
//	방에서의 유저 목록
	
	private String roomName;
	
	public Room(String roomName, GameCharacter client) {
//	방 생성시 유저 추가
		this.roomName = roomName;
		clients.add(client);
	}
	
	public void addUser(GameCharacter client) {
//	이미 있는 방일 경우 유저 추가 
		clients.add(client);
	}
	
	public void removeUser(GameCharacter client) {
		clients.remove(client);
	}
	
	public int getRoomSize() {
		return clients.size();
	}
	
	public String getRoomName() {
		return String.format("%s", roomName);
	//	방제목 불러오는 메서드
	}
}