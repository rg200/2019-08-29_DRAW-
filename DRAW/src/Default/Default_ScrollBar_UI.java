package Default;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicScrollBarUI;


public class Default_ScrollBar_UI extends BasicScrollBarUI {
	/*
	 * (non-Javadoc) ScrollBar �� �����Ҷ��� ������ ����, thumbRect�� trackRect �� ���� �ʵ�� api ��
	 * �����ϸ� �׸��� �Բ� ��������� �ڼ��ϰ� ���´�.
	 * 
	 * @see javax.swing.plaf.basic.BasicScrollBarUI#configureScrollBarColors()
	 */
	protected void configureScrollBarColors() {
		thumbRect.width = 5;
		trackRect.width = 5;
 
		thumbColor = new Color(159,77,74);
		thumbDarkShadowColor = new Color(159,77,74);
		thumbHighlightColor = new Color(159,77,74);
		thumbLightShadowColor = new Color(159,77,74);
		trackColor = new Color(220,170,117);
		trackHighlightColor = new Color(220,170,117);

//        AWTUtilitiesWrapper.setComponentShape((Window)thumbRect, shape);
	}

	/*
	 * (non-Javadoc) ScrollBar ��ܿ� ȭ��ǥ ����� ��ư ���� ����
	 * 
	 * @see javax.swing.plaf.basic.BasicScrollBarUI#createDecreaseButton(int)
	 */
	protected JButton createDecreaseButton(int orientation) {
		JButton button = new BasicArrowButton(orientation);
		button.setBackground(new Color(220,170,117));
		button.setForeground(new Color(220,170,117));
		return button;
	}

	/*
	 * (non-Javadoc) ScrollBar �ϴܿ� ȭ��ǥ ����� ��ư ���� ����
	 * 
	 * @see javax.swing.plaf.basic.BasicScrollBarUI#createIncreaseButton(int)
	 */
	protected JButton createIncreaseButton(int orientation) {
		JButton button = new BasicArrowButton(orientation);
		button.setBackground(new Color(220,170,117));
		button.setForeground(new Color(220,170,117));
		return button;
	}

	@Override
	protected Dimension getMaximumThumbSize() {
		// TODO Auto-generated method stub
		return new Dimension(10, 20);
	}
}

