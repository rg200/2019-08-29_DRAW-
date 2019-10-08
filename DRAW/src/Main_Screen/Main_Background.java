package Main_Screen;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import Default_Frame.Default_Frame;
import Select_Screen.Select_Background;

public class Main_Background extends JPanel {
	private Image M_Background = new ImageIcon(Main_Background.class.getResource("/Image/Background/MAINBACKGROUND.png")).getImage();
	private ImageIcon PRESS_ENTER_WHITE = new ImageIcon(Main_Background.class.getResource("/Image/Background/PRESS_WHITE.png"));
	private ImageIcon PRESS_ENTER_BLACK = new ImageIcon(Main_Background.class.getResource("/Image/Background/PRESS_BLACK.png"));
	private JButton PRESS = new JButton(PRESS_ENTER_BLACK);
	private Default_Frame DF;
	
	

	public Main_Background(Default_Frame DF) {
		
		this.DF = DF;	
		setPreferredSize(new Dimension(Default_Frame.SCREEN_WIDTH, Default_Frame.SCREEN_HEIGHT));
		setLayout(null);
		add(PRESS);
		
		PRESS.setBorderPainted(false);
		PRESS.setFocusable(false);
		PRESS.setContentAreaFilled(false);
		PRESS.setBounds(470,450, PRESS_ENTER_BLACK.getIconWidth(), PRESS_ENTER_BLACK.getIconHeight());
		setVisible(true);
		
	

		DF.revalidate();

		DF.repaint();
		PRESS.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				PRESS.setIcon(PRESS_ENTER_WHITE);//흰색으로 바뀜
				PRESS.setCursor(new Cursor(Cursor.HAND_CURSOR));// 커서가 손가락 모양으로
			}

			@Override
			public void mouseExited(MouseEvent e) {
				PRESS.setIcon(PRESS_ENTER_BLACK);// 다시 원상태로
				PRESS.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// 커서가 기본으로
			}

			@Override
			public void mousePressed(MouseEvent e) {
				DF.getContentPane().removeAll();
				DF.add(new Select_Background(DF));//Select_Background 패널 불러옴 
				DF.repaint();
			
			}
		});

	}
	public void paintComponent(Graphics g) {	
		super.paintComponents(g);		
		g.drawImage(M_Background, 0, 0, this.getWidth(),this.getHeight(),this);
		
	}

	

}
