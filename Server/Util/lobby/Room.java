package lobby;

import java.util.ArrayList;

import character.GameCharacter;

public class Room  {
	// �� Ŭ���� ���� �̱���
	private ArrayList<GameCharacter> clients = new ArrayList<GameCharacter>();
//	�濡���� ���� ���
	public Room(GameCharacter client) {
//	�� ������ ���� �߰�
		clients.add(client);
	}
	
	public void addUser(GameCharacter client) {
//	�̹� �ִ� ���� ��� ���� �߰� 
		clients.add(client);
	}
}
