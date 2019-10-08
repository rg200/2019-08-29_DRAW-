package lobby;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import character.GameCharacter;

public class Channel {		
// Send 객체때문에 임의로 만들어둠 변경될 가능성 있음
	private static Map<Integer, Map> Channel = Collections.synchronizedMap(new HashMap<>());
//	채널을 담아두는 Map
	
	private Map<Integer, Room>Room = Collections.synchronizedMap(new HashMap<>()); 
//	방 정보를 만들거나 받아오는 Room Map
	
	Room room;
	
	public Channel(GameCharacter character,int channel){
		if(this.Channel.containsKey(channel)) {
	//	유저가 선택한 Channel이 비어있는지 확인
			Room = this.Channel.get(channel);
			Room.get(0).addUser(character);
	// 	비어 있지 않다면 0번방(로비)에 유저를 추가
		}else {
	//	비어 있다면
			room = new Room(character);
			Room.put(0, room);
			this.Channel.put(channel, Room);
	//	0번 방을 만들어 Channel에 저장
		}
	}
	
}
