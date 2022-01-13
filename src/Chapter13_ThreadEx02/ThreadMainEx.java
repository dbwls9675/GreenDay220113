package Chapter13_ThreadEx02;

//ex4) main() 메소드에서 현재 실행 중인 스레드 정보를 출력하라
public class ThreadMainEx {

	public static void main(String[] args) {
		long id = Thread.currentThread().getId();// 스레드 ID얻기
		String name = Thread.currentThread().getName();// 스레드 이름 얻기
		int priority = Thread.currentThread().getPriority();// 스레드 우선순위 값 얻기
		Thread.State s = Thread.currentThread().getState();// 스레드 상태 값 얻기

		System.out.println("현재 스레드 이름 = " + name);
		System.out.println("현재 스레드 ID = " + id);
		System.out.println("현재 스레드 우선순위값 = " + priority);
		System.out.println("현재 스레드 상태 = " + s);

	}

}
