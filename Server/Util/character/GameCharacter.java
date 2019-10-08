package character;

import java.net.Socket;
import java.util.ArrayList;

import common.Card;

public class GameCharacter extends Character{
	// 인게임에서 사용할 Charter
	
	private String Job;	
//	게임에서 사용할 직업 
	private int Hp;
//	캐릭터의 Hp
	private ArrayList<Card> Card = new ArrayList<Card>();
//	캐릭이 가지고 있는 Card	
	
	public GameCharacter(String nickName, Socket userInfo,int channel) {
		super(nickName, userInfo, channel);
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