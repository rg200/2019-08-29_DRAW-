package Util;

import java.awt.Color;

import javax.swing.JTextArea;

import Default.Default_Socket;


public class ChatThread implements Runnable {
	private static JTextArea Chat_TextArea;
	private String text;
	private Color green = Color.GREEN;
	public ChatThread() {
		new Thread(this).start();
		this.text = null;
	}
	
	public static void SetTextArea(JTextArea TA) {
		Chat_TextArea = TA;
	}
	
	
	public void run() {
		while(!Thread.currentThread().isInterrupted()) {

			
			text = ReceiveServer.ReceiveData(Default_Socket.getInChat());
			if(text.equals("Logout")) {
				break;
			}
			else if(text.startsWith("SYSW ")) {
				text = text.substring(5); //SYSW 를 지우기 위해서 사용
			}
			Chat_TextArea.append(text + "\n");
			Chat_TextArea.setCaretPosition(Chat_TextArea.getDocument().getLength());
			
			
		}
		
	}

}
