package Chapter13_ThreadEx02;
//ex6) flag�� �̿��� ������ ���� ����
import java.awt.Color;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

class RandomThread extends Thread {
	private Container contentPane;
	private boolean flag = false;// �������� ���� ����� ǥ���ϴ� �÷���, true : ��������

	public RandomThread(Container contentPane) {
		this.contentPane = contentPane;
	}

	void finish() {// ������ ���� ����� flag�� ǥ��
		flag = true;
	}

	@Override
	public void run() {
		while (true) {
			int x = ((int) (Math.random() * contentPane.getWidth()));
			int y = ((int) (Math.random() * contentPane.getHeight()));
			JLabel label = new JLabel("Java");// �� ���̺� ����
			label.setSize(80, 30);
			label.setLocation(x, y);
			contentPane.add(label);
			contentPane.repaint();

			try {
				Thread.sleep(300);// 0.3�� ���� ���� ��.
				if (flag == true) {
					contentPane.removeAll();
					label.setSize(80, 30);
					label.setLocation(100, 100);
					label.setForeground(Color.red);
					contentPane.add(label);
					contentPane.repaint();
					return;// ������ ����
				}
			} catch (InterruptedException e) {
				return;
			}

		}
	}
}

public class ThreadFinishFlagEx extends JFrame {
	private RandomThread th;// ������ ���۷���

	public ThreadFinishFlagEx() {
		setTitle("ThreadFinishFlagEx ����");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);

		c.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				th.finish(); // RandomThread ������ ���� ���
			}
		});

		setSize(300, 200);

		th = new RandomThread(c);// ������ ����
		th.start();// ������ ���۽�Ŵ
	}

	public static void main(String[] args) {
		new ThreadFinishFlagEx().setVisible(true);

	}

}
