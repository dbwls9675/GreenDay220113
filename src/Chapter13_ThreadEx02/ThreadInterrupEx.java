package Chapter13_ThreadEx02;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

class TimerRunnable2 implements Runnable{
	private JLabel timerLabel;
	public TimerRunnable2(JLabel timerJLabel) {
		this.timerLabel = timerJLabel;
	}
	@Override
	public void run() {
		int n = 0;
		while(true) {
			timerLabel.setText(Integer.toString(n));
			n++;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				return;//예외가 발생하면 스레드 종료
			}
		}
		
	}
}

public class ThreadInterrupEx extends JFrame {
	private Thread th;

	public ThreadInterrupEx() {
		setTitle("hreadInterrupEx 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		JLabel timerLable = new JLabel();//초 텍스트
		timerLable.setFont(new Font("Gothic", Font.ITALIC, 80));

		TimerRunnable2 runnable = new TimerRunnable2(timerLable);
		th = new Thread(runnable);
		c.add(timerLable);

		// 버튼을 생성하고 Action 리스너 등록
		JButton btn = new JButton("kill Timer");
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				th.interrupt();// 타이머 스레드 강제 종료
				JButton btn = (JButton) e.getSource();
				btn.setEnabled(false);// 버튼 비활성화
			}
		});
		c.add(btn);
		setSize(300, 170);

		th.start();// 스레드 동작시킴
	}

	public static void main(String[] args) {
		new ThreadInterrupEx().setVisible(true);

	}

}
