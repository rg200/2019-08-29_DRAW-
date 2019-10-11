package Login_Screen;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Default_Frame.Default_Frame;
import Lobby_Screen.Lobby_Background;
import Main_Screen.Main_Background;
import Select_Screen.Select_Background;

public class Login_Background extends JPanel {
	private Image Log_Background = new ImageIcon(
			Main_Background.class.getResource("/Image/LOGIN_SCREEN/LOGIN_SCREEN.png")).getImage();
	private ImageIcon LOGIN_BACK = new ImageIcon(
			Main_Background.class.getResource("/Image/LOGIN_SCREEN/LOGIN_BACK.png"));
	private ImageIcon LOGIN_BACK_ENTER = new ImageIcon(
			Main_Background.class.getResource("/Image/LOGIN_SCREEN/LOGIN_BACK_ENTER.png"));
	private ImageIcon LOGIN_IN = new ImageIcon(Main_Background.class.getResource("/Image/LOGIN_SCREEN/LOGIN_IN.png"));
	private ImageIcon LOGIN_ENTER = new ImageIcon(
			Main_Background.class.getResource("/Image/LOGIN_SCREEN/LOGIN_ENTER.png"));
	private JButton LOGIN_BACKBUTTON = new JButton(LOGIN_BACK);
	private JButton LOGIN_BUTTON = new JButton(LOGIN_IN);
	private Default_Frame DF;
	private JTextField ID_TextField = new JTextField();
	private JTextField PW_TextField = new JTextField();

	// 네트워크 부분 시작
	private  Socket clientSocket = null;// 클라이언트 소켓
	private  DataInputStream inData = null;// 데이터 인풋
	private  DataOutputStream outData = null; // 데이터 아웃풋
	// 네트워크 부분 끝

	public Login_Background(Default_Frame DF) {
		this.DF = DF;
		setSize(Default_Frame.SCREEN_WIDTH, Default_Frame.SCREEN_HEIGHT);// 크기 고정
		setLayout(null);

		add(LOGIN_BUTTON);
		add(LOGIN_BACKBUTTON);
		add(ID_TextField);
		add(PW_TextField);
		ID_TextField.setBounds(880, 380, 400, 100);
		ID_TextField.setBorder(null);
		ID_TextField.setFont(new Font("Stencil", Font.HANGING_BASELINE, 50));
		ID_TextField.setOpaque(false);
		PW_TextField.setBounds(880, 615, 400, 100);
		PW_TextField.setBorder(null);
		PW_TextField.setFont(new Font("Stencil", Font.HANGING_BASELINE, 50));
		PW_TextField.setOpaque(false);
		LOGIN_BACKBUTTON.setBorderPainted(false);
		LOGIN_BACKBUTTON.setFocusable(false);
		LOGIN_BACKBUTTON.setContentAreaFilled(false);
		LOGIN_BACKBUTTON.setBounds(35, 340, LOGIN_BACK.getIconWidth(), LOGIN_BACK.getIconHeight());

		LOGIN_BUTTON.setBorderPainted(false);
		LOGIN_BUTTON.setFocusable(false);
		LOGIN_BUTTON.setContentAreaFilled(false);
		LOGIN_BUTTON.setBounds(1158, 710, LOGIN_BACK.getIconWidth(), LOGIN_BACK.getIconHeight());
		setVisible(true);

		// 네트워크 부분 시작

		// 기본 포트 넘버
		int portNumber = 9000;
		// 기본 호스트(자기 자신)
		String host = "localhost";

		try {
			clientSocket = new Socket(host, portNumber);
			outData = new DataOutputStream(clientSocket.getOutputStream());
			inData = new DataInputStream(clientSocket.getInputStream());
			System.out.println("접속 성공");
		} catch (UnknownHostException e) {
			System.err.println("호스트를 찾을 수 없습니다." + host);
		} catch (IOException e) {
			System.err.println("Couldn't get I/O for the connection to the host " + host);
		}

		// 네트워크 부분 끝

		LOGIN_BUTTON.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				LOGIN_BUTTON.setIcon(LOGIN_ENTER);// 흰색으로 바뀜
				LOGIN_BUTTON.setCursor(new Cursor(Cursor.HAND_CURSOR));// 커서가 손가락 모양으로
			}

			@Override
			public void mouseExited(MouseEvent e) {
				LOGIN_BUTTON.setIcon(LOGIN_IN);// 다시 원상태로
				LOGIN_BUTTON.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// 커서가 기본으로
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// 네트워크 부분

				try {
					outData.writeUTF(ID_TextField.getText() + ":" + PW_TextField.getText());
					System.out.println("ID PASS 전송");
					String awnser = inData.readUTF();
					if (awnser.equals("LoginAccept")) {
						DF.getContentPane().removeAll();
						DF.add(new Lobby_Background(DF, clientSocket));// Lobby_Background 패널 불러옴
						DF.repaint();
					} else
						// 정혁쿤 : 로그인 실패했다는 빨간줄 필요한곳
						System.out.println("로그인 실패 : 다시 시도하십시오.");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		LOGIN_BACKBUTTON.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				LOGIN_BACKBUTTON.setIcon(LOGIN_BACK_ENTER);// 흰색으로 바뀜
				LOGIN_BACKBUTTON.setCursor(new Cursor(Cursor.HAND_CURSOR));// 커서가 손가락 모양으로
			}

			@Override
			public void mouseExited(MouseEvent e) {
				LOGIN_BACKBUTTON.setIcon(LOGIN_BACK);// 다시 원상태로
				LOGIN_BACKBUTTON.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// 커서가 기본으로
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// 네트워크 부분
				try {
					outData.writeUTF("System:Logout");
					inData.close();
					outData.close();
					clientSocket.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} // 뒤로 가기 누를 시 종료.

				DF.getContentPane().removeAll();
				DF.add(new Select_Background(DF));// Select_Background 패널 불러옴
				DF.repaint();
			}
		});

	}

	public void paintComponent(Graphics g) {

		g.drawImage(Log_Background, 0, 0, this.getWidth(), this.getHeight(), this);
		super.paintComponents(g);

	}

}
