package Lobby_Screen;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Default.Default_Frame;
import Default.Default_ScrollBar_UI;
import Util.SendServer;
import Util.ReceiveServer;

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
		Chat_TextArea_Scroll.getViewport().setOpaque(false);// textarea�� scroll �Ѵ� �������� ������� �����
		Chat_TextArea_Scroll.getViewport().setBorder(null);
		Chat_TextArea.setLineWrap(true);// �ڵ� �ٹٲٱ�
		Chat_TextArea_Scroll.setOpaque(false);
		Chat_TextArea_Scroll.setBorder(null);
		Chat_TextArea_Scroll.getVerticalScrollBar().setUI(new Default_ScrollBar_UI());// ui �ٲٱ����� ����
		Chat_TextArea.setOpaque(false);
		Chat_TextArea.setBorder(null);
		Chat_TextArea.setFont(new Font("����", Font.BOLD, 18));
		Chat_TextArea.setEditable(false);// ���� �Ұ����ϰ� ��
		Chat_TextField.setBounds(0, 130, 1130, 65);
		Chat_TextField.setBorder(null);
		Chat_TextField.setFont(new Font("����", Font.BOLD, 50));
		Chat_TextField.setOpaque(false);
		Chat_TextField.requestFocus();
		Chat_TextField.addActionListener(this);
		
		
	

	}
	
	public class ReceiveThread implements Runnable{
		public void run(){
			while(true) {
				String text = null;
				text = ReceiveServer.ReceiveData(Default_Frame.inChat);
				if(text != null) {
					Chat_TextArea.append(text + newline);
					Chat_TextArea.setCaretPosition(Chat_TextArea.getDocument().getLength());
				}
			}
		}
		
	}
	public void on() {
		new Thread(new ReceiveThread()).start();
	}
	public void actionPerformed(ActionEvent evt) {
		String text = Chat_TextField.getText();
		SendServer.SendData(Default_Frame.outChat, text);
		//Chat_TextArea.append(text + newline); //area �ʵ忡 ���� ���� �� 
		Chat_TextField.selectAll();
		//Chat_TextArea.setCaretPosition(Chat_TextArea.getDocument().getLength());// ���� �޾� ���̴� �� 
		Chat_TextField.setText("");
	}
}
