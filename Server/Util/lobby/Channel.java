package lobby;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import character.GameCharacter;

public class Channel {		
// Send 객체때문에 임의로 만들어둠 변경될 가능성 있음
	private static Map<Integer, Map> Channels = Collections.synchronizedMap(new HashMap<>());
//	채널을 담아두는 Map
	
	private Map<Integer, Room>Rooms = Collections.synchronizedMap(new HashMap<>()); 
//	방 정보를 만들거나 받아오는 Room Map
	
	Room room;
	
	public Channel(GameCharacter character,int channelNumber){
		if(this.Channels.containsKey(channelNumber)) {
	//	유저가 선택한 Channels이 비어있는지 확인
			Rooms = this.Channels.get(channelNumber);
			Rooms.get(0).addUser(character);
			System.out.println("채널에 퐁당~");
	// 	비어 있지 않다면 0번방(로비)에 유저를 추가
		}else {
	//	비어 있다면
			room = new Room(character);
			Rooms.put(0, room);
			this.Channels.put(channelNumber, Rooms);
			System.out.println("채널을 추가~");
	//	0번 방을 만들어 Channels에 저장
		}
	}
	
}
