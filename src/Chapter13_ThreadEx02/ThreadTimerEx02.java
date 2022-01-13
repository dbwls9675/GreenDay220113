package Chapter13_ThreadEx02;
//ex1) Thread를 상속받아 1초 단위의 타이머 만들기
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

class TimerThread extends Thread {
	private JLabel tl;

	public TimerThread(JLabel tl) {
		this.tl = tl;
	}

	@Override
	public void run() {
		int n = 0;
		while (true) {
			tl.setText(Integer.toString(n));
			n++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {

				return;
			}
		}
	}
}

public class ThreadTimerEx02 extends JFrame {
	public ThreadTimerEx02() {
		setTitle("Thread를 상속받은 타이머 스레드 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		JLabel tl = new JLabel();
		tl.setFont(new Font("Gothic", Font.ITALIC, 80));
		c.add(tl);

		TimerThread th = new TimerThread(tl);
		setSize(300,170);
		th.start();
	}

	public static void main(String[] args) {
		new ThreadTimerEx02().setVisible(true);

	}

}
