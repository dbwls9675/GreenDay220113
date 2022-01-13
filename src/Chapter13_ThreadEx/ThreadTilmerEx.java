package Chapter13_ThreadEx;
//ThreadEx01 - �ʽð� �����

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class TimerThread extends Thread {
	JLabel timJLabel;

	public TimerThread(JLabel timerLabel) {
		this.timJLabel = timerLabel;
	}

	public void run() {
		// thread�� ���� �޼ҵ� ������ - start()�� ���ؼ� ���� ��.
		System.out.println("���� ������>>> " + this.getName());
		int ssec = 0;
		int sec = 0;
		while (true) {
			try {
				if (ssec % 60 == 0)
					sec++;
				ssec %= 60;
				// System.out.println("Timer>>> " + sec + ":" + ssec++);
				timJLabel.setText("Timer>>> " + sec + ":" + ssec++);
				Thread.sleep(1000 / 6); // 1000=1�� 100=0.1��, 1�ʾ� println�� ����
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class ThreadTilmerEx extends JFrame {
	JPanel contentPan = new JPanel();

	public ThreadTilmerEx() {
		contentPan.setBackground(Color.white);
		this.setContentPane(contentPan);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Thread�� �̿��� �ð�");
		setSize(300, 200);

		JLabel timerLabel = new JLabel(">>> 0��");
		contentPan.setLayout(new GridBagLayout());
		contentPan.add(timerLabel);

		// ��ư �߰�
		JButton stopBtn = new JButton("Stop");
		JButton playBtn = new JButton("Play");
		contentPan.add(stopBtn);
		contentPan.add(playBtn);

		// Thread�����ϰ� �����ϱ� - ��ĳ����
		TimerThread th = new TimerThread(timerLabel);
		// run()�� �����ϱ� ���ؼ� start() ȣ��
		th.start();

		System.out.println("���� >>> " + this.getName());

		// ��ư �̺�Ʈ
		stopBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Ÿ�̸Ӱ� �Ͻ� �����ϵ��� Thread ��ü�� ��û�Ѵ�.

			}
		});

		playBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Ÿ�̸Ӱ� ����� �ϵ��� Thread ��ü�� ��û�Ѵ�.

			}
		});
	}

	public static void main(String[] args) {
		new ThreadTilmerEx().setVisible(true);

	}

}
