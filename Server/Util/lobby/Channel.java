package lobby;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import character.GameCharacter;

public class Channel {		
// Send ��ü������ ���Ƿ� ������ ����� ���ɼ� ����
	private static Map<Integer, Map> Channel = Collections.synchronizedMap(new HashMap<>());
//	ä���� ��Ƶδ� Map
	
	private Map<Integer, Room>Room = Collections.synchronizedMap(new HashMap<>()); 
//	�� ������ ����ų� �޾ƿ��� Room Map
	
	Room room;
	
	public Channel(GameCharacter character,int channel){
		if(this.Channel.containsKey(channel)) {
	//	������ ������ Channel�� ����ִ��� Ȯ��
			Room = this.Channel.get(channel);
			Room.get(0).addUser(character);
	// 	��� ���� �ʴٸ� 0����(�κ�)�� ������ �߰�
		}else {
	//	��� �ִٸ�
			room = new Room(character);
			Room.put(0, room);
			this.Channel.put(channel, Room);
	//	0�� ���� ����� Channel�� ����
		}
	}
	
}
