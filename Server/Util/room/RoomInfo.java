package room;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import character.GameCharacter;
import common.Option;
import common.Receive;
import common.Send;
import lobby.Channel;

public class RoomInfo implements Runnable {
//	소켓이 필요할 수 있어서 일단 받아옴
	private DataInputStream request;
// 	Receive에 필요함
	private DataOutputStream response;
	private GameCharacter user;
	private int channel;
	
	public RoomInfo(GameCharacter user) {
		//클라이언트의 유저 정보 Socket을 받아옴
		try {
			this.user = user;
			this.channel = user.getChannelNumber();
			this.request = user.getRoomIn();
			this.response = user.getRoomOut();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void run() {
		
		roomUpdate(channel);
		//	최초 유저의 로비에 방목록을 뿌려줌
		
		while(Option.Stop) {
			System.out.println("반복중");
			switch(Receive.ReceiveData(request)) {
		//	클라이언트로부터 방 생성 및 방 접속 신호를 받아옴
			case "Create":
				createRoom();
				break;
			case "Join":
				joinRoom(Receive.ReceiveInt(request));
				break;
			case "back":
				removeRoom();
				break;
			case "reload":
				roomUpdate(channel);
				break;
			}
		}
	}
	
	public void createRoom() {
	//	방 생성
		String roomName = Receive.ReceiveData(request);
		Channel.getRoom(channel,user.getRoomNumber()).removeUser(user);
		Channel.getRooms(channel).put(Room.roomNum++, new Room(roomName, user));
	}
	
	public void joinRoom(int roomNum) {
	//	방 접속
		Channel.getRoom(channel,user.getRoomNumber()).removeUser(user);
		Channel.getRoom(channel,roomNum).addUser(user);
	}
	
	public void roomUpdate(int channel) {
	//	방 새로고침
		
		int roomNum = Channel.getRooms(channel).size();

		for(int i = 1; i < roomNum; i++) {
			
			Send.sendData(response, Channel.getRoom(channel,i).getRoomNumber());
			Send.sendData(response, Channel.getRoom(channel,i).getRoomName());
		}
	}
	
	public void removeRoom() {
		if(!Channel.getRoom(channel,user.getRoomNumber()).getRoomName().equals("lobby") && Channel.getRoom(channel,user.getRoomNumber()).backUser(user) == 0) {
			Channel.getRooms(channel).remove(user.getRoomNumber());
		}
	}
}