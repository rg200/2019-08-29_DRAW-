package Lobby_Screen;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Default.Default_ScrollBar_UI;

public class Play_List extends JPanel {
	// 방목록이 표시되는 패널을 나타넴 (영역이라고 생각하면 편함)
	private JScrollPane List_Scroll = new JScrollPane(this);
	public Play_List() {
		setLayout(new FlowLayout(FlowLayout.LEFT)); 
		setOpaque(false);
		List_Scroll = new JScrollPane(this);
		List_Scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		List_Scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		setBounds(57, 260, 1110, 3480);
		setPreferredSize(new Dimension(1110,3480));
		List_Scroll.getVerticalScrollBar().setUI(new Default_ScrollBar_UI());// 스크롤 ui 
		List_Scroll.setPreferredSize(new Dimension(1110,480));
	}
}
