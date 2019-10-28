package lobby;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import character.GameCharacter;
import room.Room;

public class Channel {		
// Send ��ü������ ���Ƿ� ������ ����� ���ɼ� ����
	private static Map<Integer, Map<Integer, Room>> Channels = Collections.synchronizedMap(new HashMap<>());
//	ä���� ��Ƶδ� Map
	
	private Map<Integer, Room>Rooms = Collections.synchronizedMap(new HashMap<>()); 
//	�� ������ ����ų� �޾ƿ��� Room Map
	
	Room room;
	
	public Channel(GameCharacter character,int channelNumber){
		if(this.Channels.containsKey(channelNumber)) {
	//	������ ������ Channels�� ����ִ��� Ȯ��
			Rooms = this.Channels.get(channelNumber);
			Rooms.get(0).addUser(character);
			System.out.println("ä�ο� ����~");
	// 	��� ���� �ʴٸ� 0����(�κ�)�� ������ �߰�
		}else {
	//	��� �ִٸ�
			room = new Room("lobby", character);
			Rooms.put(0, room);
			this.Channels.put(channelNumber, Rooms);
			System.out.println("ä���� �߰�~");
	//	0�� ���� ����� Channels�� ����
		}
	}
	
	public static Map<Integer, Room> getRooms(int channel) {
		return Channels.get(channel);
	}
	
	public static Room getRoom(int channel, int room) {
		return Channels.get(channel).get(room);
	}
}