package Chapter13_ThreadEx02;
//ex3) 깜박이는 문자열을 가진 레이블 만들기 
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
		setTitle("Flickering LabelEx 예제");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container c = getContentPane();//패널과 container를 상속받은 모든 컴포넌트를 삽입가능
		c.setLayout(new FlowLayout());//왼쪽에서 오른쪽으로 정렬

		// 깜빡이는 레이블 생성
		FlickeringLabel fLabel = new FlickeringLabel("깜빡", 500);

		// 깜빡이지 않는 레이벌 생성
		JLabel label = new JLabel("안깜빡");

		// 깜빡이는 레이블 생성
		FlickeringLabel fLabel2 = new FlickeringLabel("여기도 깜빡", 300);
		c.add(fLabel);
		c.add(label);
		c.add(fLabel2);

		setSize(300, 150);

	}

	public static void main(String[] args) {
		new FlickeringLabelEx().setVisible(true);

	}

}
