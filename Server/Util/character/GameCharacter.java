package character;

import java.net.Socket;
import java.util.ArrayList;

import common.Card;

public class GameCharacter extends Character{
	// �ΰ��ӿ��� ����� Charter
	
	private String Job;	
//	���ӿ��� ����� ���� 
	private int Hp;
//	ĳ������ Hp
	private ArrayList<Card> Card = new ArrayList<Card>();
//	ĳ���� ������ �ִ� Card	
	
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