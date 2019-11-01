package room;

import java.util.ArrayList;

import character.GameCharacter;
import lobby.Channel;

public class Room  {
	// 방 클래스
	public static int roomNum = 1;
	private ArrayList<GameCharacter> users = new ArrayList<GameCharacter>();
//	방 안에 있는 유저정보
	private int roomNumber;
	private String roomName;
	
	public Room(String roomName, GameCharacter user) {

		roomNumber = roomNum-1;
		this.roomName = roomName;
		users.add(user);
		user.setRoomNumber(roomNumber);
	}
	
	public void addUser(GameCharacter user) {
//	방에 유저 접속
		users.add(user);
		user.setRoomNumber(roomNumber);
	}
	
	public void removeUser(GameCharacter user) {
			Channel.getRoom(user.getChannelNumber(), user.getRoomNumber()).getArrayList().remove(user);
		}
	
	public int backUser(GameCharacter user) {
		removeUser(user);
		Channel.getRoom(user.getChannelNumber(), 0).addUser(user);
		user.setRoomNumber(0);
		
		return users.size();
	}
	
	public int getRoomSize() {
		return users.size();
	}
	
	public int getRoomNumber() {
		return roomNumber;
	}
	
	public String getRoomName() {
		return String.format("%s", roomName);
	//	방 제목을 받아옴
	}
	public ArrayList<GameCharacter> getArrayList() {
		return users;
	}
}