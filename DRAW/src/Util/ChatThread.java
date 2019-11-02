package Util;

import javax.swing.JTextArea;

import Default.Default_Frame;
import Default.Default_Socket;


public class ChatThread implements Runnable {
	private static JTextArea Chat_TextArea;
	private String text;
	
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
			Chat_TextArea.append(text + "\n");
			Chat_TextArea.setCaretPosition(Chat_TextArea.getDocument().getLength());
			
			
		}
		
	}

}
