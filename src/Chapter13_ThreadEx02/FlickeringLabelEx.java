package Chapter13_ThreadEx02;
//ex3) �����̴� ���ڿ��� ���� ���̺� ����� 
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

class FlickeringLabel extends JLabel implements Runnable {
	private long delay;

	public FlickeringLabel(String text, long delay) {
		super(text);
		this.delay = delay;
		setOpaque(true);//boolean
		Thread th = new Thread(this);
		th.start();
	}

	@Override
	public void run() {
		int n = 0;
		while (true) {
			if (n == 0) {
				setBackground(Color.yellow);
			} else {
				setBackground(Color.green);
			}
			if (n == 0) {
				n = 1;
			} else {
				n = 0;
			}
			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				return;
			}
		}

	}
}

public class FlickeringLabelEx extends JFrame {
	public FlickeringLabelEx() {
		setTitle("Flickering LabelEx ����");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container c = getContentPane();//�гΰ� container�� ��ӹ��� ��� ������Ʈ�� ���԰���
		c.setLayout(new FlowLayout());//���ʿ��� ���������� ����

		// �����̴� ���̺� ����
		FlickeringLabel fLabel = new FlickeringLabel("����", 500);

		// �������� �ʴ� ���̹� ����
		JLabel label = new JLabel("�ȱ���");

		// �����̴� ���̺� ����
		FlickeringLabel fLabel2 = new FlickeringLabel("���⵵ ����", 300);
		c.add(fLabel);
		c.add(label);
		c.add(fLabel2);

		setSize(300, 150);

	}

	public static void main(String[] args) {
		new FlickeringLabelEx().setVisible(true);

	}

}
