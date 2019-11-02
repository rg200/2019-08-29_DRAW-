package lobby;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

import character.*;
import common.Option;
import common.Receive;
import common.Send;
import room.Room;

public class Chat implements Runnable {
	private GameCharacter user;
	private Socket chat;
	private Room user_room;
	private ArrayList<GameCharacter> user_room_cli;
	private DataInputStream inChat;
	private DataOutputStream outChat;
	private String ChatText;
	
	public Chat(GameCharacter user){
		
		this.user= user;
		this.chat = user.getChat();
		//클라이언트의 유저 정보 Socket을 받아옴
		try {
			this.inChat = new DataInputStream(chat.getInputStream());
			this.outChat = new DataOutputStream(chat.getOutputStream());
		} catch (IOException e) {
			// TODO 자동 생성된 catch 블록
			e.printStackTrace();
		}
	}

	public void run() {
		common.Send.sendData(outChat, "접속하신걸 환영합니다.");
		while(Option.Stop) {
			ChatText = Receive.ReceiveData(inChat);

			if(ChatText.startsWith("/w"));
			else if(!ChatText.equals("Error")) {
				ChatText = user.getNickName() +" : "+ ChatText;
				user_room = Channel.getRoom(user.getChannelNumber(), user.getRoomNumber()); // 채널과 방번호로 룸 클래스 받아옴
				user_room_cli = user_room.getArrayList(); // 받아온 룸 클래스로 접속자 어레이 리스트를 받아옴 
				//System.out.println(ChatText);
				Send.sendAll(ChatText,user_room_cli);
			}
		}
	}
}