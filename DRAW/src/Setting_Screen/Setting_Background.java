package Setting_Screen;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import Default_Frame.Default_Frame;
import Main_Screen.Main_Background;
import Select_Screen.Select_Background;

public class Setting_Background extends JPanel {
	
	private Image Set_Background = new ImageIcon(Main_Background.class.getResource("/Image/SETTING_SCREEN/SETTING_SCREEN.png")).getImage();
	private ImageIcon SETTING_BACK = new ImageIcon(Main_Background.class.getResource("/Image/SETTING_SCREEN/SETTING_BACK.png"));
	private ImageIcon SETTING_BACK_ENTER = new ImageIcon(Main_Background.class.getResource("/Image/SETTING_SCREEN/SETTING_BACK_ENTER.png"));
	private JButton SETTING_BACKBUTTON = new JButton(SETTING_BACK);
	private Default_Frame DF;
	
	public Setting_Background(Default_Frame DF) {

		this.DF = DF;
		setSize(Default_Frame.SCREEN_WIDTH, Default_Frame.SCREEN_HEIGHT);// ũ�� ����
		setLayout(null); 
		
		add(SETTING_BACKBUTTON);
		SETTING_BACKBUTTON.setBorderPainted(false);
		SETTING_BACKBUTTON.setFocusable(false);
		SETTING_BACKBUTTON.setContentAreaFilled(false);
		SETTING_BACKBUTTON.setBounds(35,340, SETTING_BACK.getIconWidth(), SETTING_BACK.getIconHeight());
		
		SETTING_BACKBUTTON.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				SETTING_BACKBUTTON.setIcon(SETTING_BACK_ENTER);//������� �ٲ�
				SETTING_BACKBUTTON.setCursor(new Cursor(Cursor.HAND_CURSOR));// Ŀ���� �հ��� �������
			}

			@Override
			public void mouseExited(MouseEvent e) {
				SETTING_BACKBUTTON.setIcon(SETTING_BACK);// �ٽ� �����·�
				SETTING_BACKBUTTON.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// Ŀ���� �⺻����
			}

			@Override
			public void mousePressed(MouseEvent e) {
				DF.getContentPane().removeAll();
				DF.add(new Select_Background(DF));//Select_Background �г� �ҷ��� 
				DF.repaint();
			}
		});
	}

	public void paintComponent(Graphics g) {

		g.drawImage(Set_Background, 0, 0, this.getWidth(), this.getHeight(), this);
		super.paintComponents(g);

	}

}
