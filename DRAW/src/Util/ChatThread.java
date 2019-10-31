package Util;

import javax.swing.JTextArea;

import Default.Default_Frame;


public class ChatThread implements Runnable {
	private static JTextArea Chat_TextArea;
	
	public ChatThread() {
		new Thread(this).start();
	}
	
	public static void SetTextArea(JTextArea TA) {
		Chat_TextArea = TA;
	}
	
	
	public void run() {
		while(!Thread.currentThread().isInterrupted()) {
			System.out.println(Thread.currentThread().isInterrupted());
			String text = null;
			text = ReceiveServer.ReceiveData(Default_Frame.inChat);
			System.out.println(text);
			if(text.equals("Logout")) {
				return;
			}
			System.out.println("꺼꺼짐");
			Chat_TextArea.append(text + "\n");
			Chat_TextArea.setCaretPosition(Chat_TextArea.getDocument().getLength());
			
			
		}
		
	}

}
