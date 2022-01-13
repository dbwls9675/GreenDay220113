package Chapter13_ThreadEx02;
//ex2) Runnable �������̽��� �̿��Ͽ� 1�� ������ ����ϴ� Ÿ�̸� ������ �����
import java.awt.*;
import javax.swing.*;

class TimerRunnable implements Runnable {
	private JLabel timerLabel2;

	public TimerRunnable(JLabel timerLabel2) {
		this.timerLabel2 = timerLabel2;
	}

	@Override
	public void run() {
		int n = 0;
		while (true) {
			timerLabel2.setText(Integer.toString(n)); 
			n++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {

				return;
			}
		}

	}
}

public class RunnableTimerEx extends JFrame {
	public RunnableTimerEx() {
		setTitle("Runnable�� ������ Ÿ�̸� ������ ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());// ���ʿ��� ���������� ��ġ

		JLabel timerLabel2 = new JLabel();
		timerLabel2.setFont(new Font("Gothic", Font.ITALIC, 80));

		c.add(timerLabel2);

		TimerRunnable runnable = new TimerRunnable(timerLabel2);
		Thread th = new Thread(runnable);

		setSize(250, 150);
		th.start();
	}

	public static void main(String[] args) {
		new RunnableTimerEx().setVisible(true);
	}

}
