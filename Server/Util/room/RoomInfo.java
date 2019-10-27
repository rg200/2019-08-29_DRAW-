package room;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Iterator;
import java.util.Set;

import character.GameCharacter;
import common.Receive;
import common.Send;
import lobby.Channel;

public class RoomInfo implements Runnable {
	private Socket roomInfo;
//	소켓이 필요할 수 있어서 일단 받아옴
	private DataInputStream request;
// 	Receive에 필요함
	private DataOutputStream response;
	private GameCharacter user;
	private int channel;
	
	public RoomInfo(GameCharacter user, int channel) {
		//클라이언트의 유저 정보 Socket을 받아옴
		try {
			this.user = user;
			this.roomInfo = user.getRoomInfo();
			this.channel = channel;
			this.request = new DataInputStream(roomInfo.getInputStream());
			this.response = new DataOutputStream(roomInfo.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void run() {

		roomUpdate();
	//	최초 유저의 로비에 방목록을 뿌려줌
		
		switch(Receive.ReceiveData(request)) {
	//	클라이언트로부터 방 생성 및 방 접속 신호를 받아옴
		case "Create":
			createRoom();
			break;
		case "Join":
			joinRoom(Receive.ReceiveInt(request));
			break;
		case "reload":
			roomUpdate();
			break;
		}

	}
	
	public void createRoom() {
	//	방 생성
		String roomName = Receive.ReceiveData(request);
		Channel.getRoom(channel).put(Room.roomNum++, new Room(roomName, user));
	}
	
	public void joinRoom(int roomNum) {
	//	방 접속
		Channel.getRoom(channel).get(roomNum).addUser(user);
	}
	
	public void roomUpdate() {
	//	방 새로고침
		
		Set<Integer> room = Channel.getRoom(channel).keySet();
		Iterator<Integer> roomNum = room.iterator();
		System.out.println(roomNum);
		while(roomNum.hasNext()) {
			if(roomNum.next().equals(0)) {
				Send.sendInt(response, Room.roomNum-1);
			}else {
				Send.sendData(response, Channel.getRoom(channel).get(roomNum).getRoomName());
			}
		}
	}
}