package login;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import character.GameCharacter;
import common.Receive;
import lobby.Channel;
public class Login implements Runnable {           
// 사용자가 접속하여 로그인
	private ServerSocket ChatServer; // 채팅 서버 소켓
	private ServerSocket RoomInfoServer; // 룸 정보 서버 소켓
	
	private Socket userInfo; // 처음엔 로그인 -> 유저&친구정보 소켓
	private Socket Chat; // 채팅 소켓
	private Socket RoomInfo; // 룸정보 소켓
	
	private String Login_Receive_Data; // 로그인할 때 받아오는 데이터 저장하는 스트링
	private String ID = "hjp"; //시험용 아이디
	private String PASS = "1234"; // 시험용 패스워드
	
//	소켓이 필요할 수 있어서 일단 받아옴
	private DataInputStream inData;
// 	Receive에 필요함
	private DataOutputStream outData;
//	Send에 필요함
	public Login(Socket userInfo) throws IOException {
								//inData, outData 정의하는데 발생하는 예외 
		this.userInfo = userInfo;
	// 	클라이언트의 유저 정보 Socket을 받아옴
		this.inData = new DataInputStream(userInfo.getInputStream());
		this.outData = new DataOutputStream(userInfo.getOutputStream());
	}

	public void run() {
		// TODO 자동 생성된 메소드 스텁
		while(true) {
			Login_Receive_Data = Receive.ReceiveData(inData);
			if(Login_Receive_Data.startsWith("System"))
				break; // 로그인화면에서 뒤로가기 신호가 왔을 때
			else {
			String[] words = Login_Receive_Data.split(":"); // 아이디:패스워드로 오는 문장 처리
			System.out.println(words[0]+words[1]); //확인용 나중에 지움
			if(words[0].equals(ID) && words[1].equals(PASS)) { // 비교
				System.out.println("유저 로그인 성공");
				common.Send.send(outData, "LoginAccept");
				
				// 로그인 성공시 유저 정보를 담는 캐릭터 객체 & 채널객체 생성 
				GameCharacter user = new GameCharacter(words[0], userInfo, 0); 
				Channel ch = new Channel(user, 0);
				
				//채널은 원래 유저가 선택해야 하지만, 지금 채널선택이 없어서 디폴트로 0 을 가져온다.
				
			}
			else
				common.Send.send(outData, "LoginFailed");
			}
		}
		try {
			inData.close();
		    outData.close();
		    userInfo.close();
		} catch (IOException e) {
			// TODO 자동 생성된 catch 블록
			e.printStackTrace();
		}
	}
}
