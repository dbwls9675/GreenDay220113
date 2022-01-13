package Chapter13_ThreadEx;
//ThreadEx01 - 초시계 만들기

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
		// thread에 실행 메소드 재정의 - start()에 의해서 실행 됨.
		System.out.println("나의 쓰레드>>> " + this.getName());
		int ssec = 0;
		int sec = 0;
		while (true) {
			try {
				if (ssec % 60 == 0)
					sec++;
				ssec %= 60;
				// System.out.println("Timer>>> " + sec + ":" + ssec++);
				timJLabel.setText("Timer>>> " + sec + ":" + ssec++);
				Thread.sleep(1000 / 6); // 1000=1초 100=0.1초, 1초씩 println이 찍힘
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
		setTitle("Thread를 이용한 시계");
		setSize(300, 200);

		JLabel timerLabel = new JLabel(">>> 0초");
		contentPan.setLayout(new GridBagLayout());
		contentPan.add(timerLabel);

		// 버튼 추가
		JButton stopBtn = new JButton("Stop");
		JButton playBtn = new JButton("Play");
		contentPan.add(stopBtn);
		contentPan.add(playBtn);

		// Thread생성하고 실행하기 - 업캐스팅
		TimerThread th = new TimerThread(timerLabel);
		// run()을 실행하기 위해서 start() 호출
		th.start();

		System.out.println("메인 >>> " + this.getName());

		// 버튼 이벤트
		stopBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 타이머가 일시 중지하도록 Thread 객체에 요청한다.

			}
		});

		playBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 타이머가 재실행 하도록 Thread 객체에 요청한다.

			}
		});
	}

	public static void main(String[] args) {
		new ThreadTilmerEx().setVisible(true);

	}

}
