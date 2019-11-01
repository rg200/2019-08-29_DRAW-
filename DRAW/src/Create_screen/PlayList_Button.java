package Create_screen;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import Default.Default_Button_Event;
import Main_Screen.Main_Background;

public class PlayList_Button extends Default_Button_Event{
	// 방 버튼
	private ImageIcon PLAY_LIST_BUTTON = new ImageIcon(Main_Background.class.getResource("/Image/LOBBY_SCREEN/LOBBY_PLAYLIST_BUTTON.png"));
	public PlayList_Button(String st) {
		setIcon(PLAY_LIST_BUTTON);
		setBorderPainted(false);
		setFocusable(false);
		setContentAreaFilled(false);
		
		setText(st);
	    setHorizontalTextPosition(JButton.CENTER);
	    setFont(new Font("굴림체", Font.BOLD, 45));
	}

}
