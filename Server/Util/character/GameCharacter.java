package character;

import java.net.Socket;
import java.util.ArrayList;

import common.Card;

public class GameCharacter extends Character{
	// 게임 캐릭터 클래스
	
	private String Job;	//	직업
	private int Hp;//	체력
	private ArrayList<Card> Card = new ArrayList<Card>();//	소지하고 있는 카드	
	
	public GameCharacter(String nickName, Socket userInfo,Socket chat, Socket roomInfo,int channel) {
		super(nickName, userInfo, chat, roomInfo, channel);
	}
	
	public String getJob() {
		return Job;
	}
	public void setJob(String job) {
		Job = job;
	}
	public int getHp() {
		return Hp;
	}
	public void setHp(int hp) {
		Hp = hp;
	}
	public ArrayList<Card> getCard() {
		return Card;
	}
	public void setCard(ArrayList<Card> card) {
		Card = card;
	}
	
}