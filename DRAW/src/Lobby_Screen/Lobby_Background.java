package Lobby_Screen;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Default.Default_Frame;
import Login_Screen.Login_Background;
import Main_Screen.Main_Background;
import Room_Screen.Room_Background;

public class Lobby_Background extends JPanel implements ActionListener{
	private static String newline = "\n";
	private Image Lob_Background = new ImageIcon(Main_Background.class.getResource("/Image/LOBBY_SCREEN/LOBBY_SCREEN.png")).getImage();
	private ImageIcon LOBBY_BACK = new ImageIcon(Main_Background.class.getResource("/Image/LOBBY_SCREEN/LOBBY_BACK.png"));
	private ImageIcon LOBBY_IN = new ImageIcon(Main_Background.class.getResource("/Image/LOBBY_SCREEN/LOBBY_JOIN.png"));
	private JButton LOBBY_BUTTON = new JButton(LOBBY_IN);
	private JTextField Chat_TextField = new JTextField();
	private JTextArea Chat_TextArea = new JTextArea();
	private JScrollPane Chat_TextArea_Scroll = new JScrollPane(Chat_TextArea);
	
	private Default_Frame DF;
	private Lobby_Back_Button LBB;
	private Lobby_Join_Button LJB;
	
	
	public Lobby_Background(Default_Frame DF) {
		this.DF = DF;
		setSize(Default_Frame.SCREEN_WIDTH, Default_Frame.SCREEN_HEIGHT);// 크기 고정
		setLayout(null); 
		LBB = new Lobby_Back_Button(LOBBY_BACK, DF);
		LJB = new Lobby_Join_Button(LOBBY_IN, DF);
		add(LJB);	
		add(LBB);	
		add(Chat_TextField);
		add(Chat_TextArea_Scroll);
		
		Chat_TextArea_Scroll.setVisible(true);	
		Chat_TextArea_Scroll.setBounds(50, 814, 1126, 128);
		Chat_TextArea_Scroll.getViewport().setOpaque(false);//textarea랑 scroll 둘다 투명으로 해줘야지 적용됨 
		Chat_TextArea_Scroll.getViewport().setBorder(null);
		Chat_TextArea.setLineWrap(true);//자동 줄바꾸기
		Chat_TextArea_Scroll.setOpaque(false);
		Chat_TextArea_Scroll.setBorder(null);
		Chat_TextArea_Scroll.getVerticalScrollBar().setUI(new ScrollBarUI());//ui 바꾸기위해 넣음
		Chat_TextArea.setOpaque(false);
		Chat_TextArea.setBorder(null);
		Chat_TextArea.setFont(new Font("굴림",Font.BOLD,20));
		Chat_TextArea.setEditable(false);//편집 불가능하게 함 
		Chat_TextField.setBounds(48, 945, 1128, 65);
		Chat_TextField.setBorder(null);
		Chat_TextField.setFont(new Font("굴림",Font.BOLD,50));
		Chat_TextField.setOpaque(false);
		Chat_TextField.requestFocus();
		Chat_TextField.addActionListener(this);
		
		
		
	}
	public void actionPerformed(ActionEvent evt) {
	    String text = Chat_TextField.getText();
	    Chat_TextArea.append(text + newline);
	    Chat_TextField.selectAll();
	    Chat_TextArea.setCaretPosition(Chat_TextArea.getDocument().getLength());
	}

	public void paintComponent(Graphics g) {

		g.drawImage(Lob_Background, 0, 0, this.getWidth(), this.getHeight(), this);
		super.paintComponents(g);

	}

}
