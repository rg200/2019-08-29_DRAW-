package room;

import java.util.ArrayList;

import character.GameCharacter;

public class Room  {
	// �� Ŭ���� ���� �̱���
	public static int roomNum = 1;
	private ArrayList<GameCharacter> clients = new ArrayList<GameCharacter>();
//	�濡���� ���� ���
	
	private String roomName;
	
	public Room(String roomName, GameCharacter client) {
//	�� ������ ���� �߰�
		this.roomName = roomName;
		clients.add(client);
	}
	
	public void addUser(GameCharacter client) {
//	�̹� �ִ� ���� ��� ���� �߰� 
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
	//	������ �ҷ����� �޼���
	}
	public ArrayList<GameCharacter> getArrayList() {
		return clients;
	}
}