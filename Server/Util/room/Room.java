package room;

import java.util.ArrayList;

import character.GameCharacter;
import lobby.Channel;

public class Room  {
	// 방 클래스
	public static int roomNum = 1;
	private ArrayList<GameCharacter> clients = new ArrayList<GameCharacter>();
//	방 안에 있는 유저정보
	private int roomNumber;
	private String roomName;
	
	public Room(String roomName, GameCharacter client) {

		roomNumber = roomNum-1;
		this.roomName = roomName;
		clients.add(client);
		client.setRoomNumber(roomNumber);
	}
	
	public void addUser(GameCharacter client) {
//	방에 유저 접속
		clients.add(client);
		client.setRoomNumber(roomNumber);
	}
	
	public int removeUser(GameCharacter client) {
		clients.remove(client);
		Channel.getRoom(client.getChannelNumber(), 0).addUser(client);
		return clients.size();
	}
	
	public int getRoomSize() {
		return clients.size();
	}
	
	public String getRoomName() {
		return String.format("%s", roomName);
	//	방 제목을 받아옴
	}
	public ArrayList<GameCharacter> getArrayList() {
		return clients;
	}
}