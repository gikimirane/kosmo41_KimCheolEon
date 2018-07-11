import java.io.*;
import java.util.*;

public class ThreadMain {

	// 생성자 !!
	public ThreadMain() {

	}

	// 관습적인 네이밍 init
	public void init() {
		System.out.println("숫자를 입력해주세요 : ");
		Scanner s = new Scanner(System.in);
		String s_num = s.nextLine();

		int n_num = Integer.parseInt(s_num);

		try {
			Thread tsub = new ThreadSub(n_num);
			tsub.start();

		} catch (Exception e) {
			System.out.println("예외 : " + e);
		}
		System.out.println("이름을 입력해주세요");
		String s_name = s.nextLine();
	}

	// Main !!
	public static void main(String[] args) {

		// 객체 생성
		ThreadMain tm = new ThreadMain();
		tm.init();
	}

	/////////////////////////////////////////////////////////////////
	// 내부 클래스에 합체

	// public
	// static - 클래스로 분리시켰기 때문에 메인에서 부르지 않으므로 static 을 할 필요가 없어졌음
	class ThreadSub extends Thread {
		int nNum;

		public ThreadSub(int num) {
			this.nNum = num;
		}

		// run() 메소드 재정의
		@Override
		public void run() {
			int i = 0;

			while (i < nNum) {
				try {
					Thread.sleep(1000);
					i = i + 1;
					System.out.println("Thread : " + i);

				} catch (Exception e) {
					System.out.println("예외 : " + e);
				}

			}
		}
	}
	/////////////////////////////////////////////////////////////////
}
