package Lobby_Screen;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Default.Default_Frame;
import Default.Default_ScrollBar_UI;

public class Lobby_Chat extends JPanel implements ActionListener {
	private static String newline = "\n";
	private JTextField Chat_TextField = new JTextField();
	private JTextArea Chat_TextArea = new JTextArea();
	private JScrollPane Chat_TextArea_Scroll = new JScrollPane(Chat_TextArea);

	public Lobby_Chat() {
		setLayout(null); 
		setOpaque(false);
		setBounds(50, 790, 1131, 200);
		add(Chat_TextField);
		add(Chat_TextArea_Scroll);
		Chat_TextArea_Scroll.setVisible(true);
		Chat_TextArea_Scroll.setBounds(3, 0, 1130, 125);
		Chat_TextArea_Scroll.getViewport().setOpaque(false);// textarea랑 scroll 둘다 투명으로 해줘야지 적용됨
		Chat_TextArea_Scroll.getViewport().setBorder(null);
		Chat_TextArea.setLineWrap(true);// 자동 줄바꾸기
		Chat_TextArea_Scroll.setOpaque(false);
		Chat_TextArea_Scroll.setBorder(null);
		Chat_TextArea_Scroll.getVerticalScrollBar().setUI(new Default_ScrollBar_UI());// ui 바꾸기위해 넣음
		Chat_TextArea.setOpaque(false);
		Chat_TextArea.setBorder(null);
		Chat_TextArea.setFont(new Font("굴림", Font.BOLD, 18));
		Chat_TextArea.setEditable(false);// 편집 불가능하게 함
		Chat_TextField.setBounds(0, 130, 1130, 65);
		Chat_TextField.setBorder(null);
		Chat_TextField.setFont(new Font("굴림", Font.BOLD, 50));
		Chat_TextField.setOpaque(false);
		Chat_TextField.requestFocus();
		Chat_TextField.addActionListener(this);


	}

	public void actionPerformed(ActionEvent evt) {
		String text = Chat_TextField.getText();
		Chat_TextArea.append(text + newline); //area 필드에 내용 들어가는 것 
		Chat_TextField.selectAll();
		Chat_TextArea.setCaretPosition(Chat_TextArea.getDocument().getLength());// 값을 받아 들이는 곳 
		Chat_TextField.setText("");
	}
}
