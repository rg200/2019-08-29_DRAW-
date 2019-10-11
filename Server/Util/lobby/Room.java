package lobby;

import java.util.ArrayList;

import character.GameCharacter;

public class Room  {
	// 방 클래스 아직 미구현
	private ArrayList<GameCharacter> clients = new ArrayList<GameCharacter>();
//	방에서의 유저 목록
	public Room(GameCharacter client) {
//	방 생성시 유저 추가
		clients.add(client);
	}
	
	public void addUser(GameCharacter client) {
//	이미 있는 방일 경우 유저 추가 
		clients.add(client);
	}
}
