package login;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import DB.DAO; //db접근객체추가함 <준근>

import common.Receive;
public class Login implements Runnable {           
// 사용자가 접속하여 로그인
	private String Login_Receive_Data;
//아이디 패스워드 삭제함<준근>
	private Socket userInfo;
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
			String[] words = Login_Receive_Data.split(":");
			System.out.println(words[0]+words[1]);
			if(DAO.getInstance().searchMember(words[0], words[1])) {//DAO는 DB접근 객체인데 클래스안에 static 클래스를 만들어서 하나의 인스턴트로만 접근 가능하게 함<준근>
				System.out.println("유저 로그인 성공");
				common.Send.send(outData, "LoginAccept");
				
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
