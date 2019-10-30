package Create_screen;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import Default.Default_Button_Event;
import Main_Screen.Main_Background;

public class PlayList_Button extends Default_Button_Event{
	// 방 목록을 표시해주는 버튼 클래스 이다. 이 버튼은 Lobby 패키지의 Play_List 에서 생성된다. 
	private ImageIcon PLAY_LIST_BUTTON = new ImageIcon(Main_Background.class.getResource("/Image/LOBBY_SCREEN/LOBBY_PLAYLIST_BUTTON.png"));
	public PlayList_Button() {
		setIcon(PLAY_LIST_BUTTON);
		setBorderPainted(false);
		setFocusable(false);
		setContentAreaFilled(false);
	}
	
}
