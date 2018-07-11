
// 쓰레드를 생성하는 방법

public class A02MakeThreadDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Runnable task = () -> { // 쓰레드가 실행하게 할 내용
			
			try {// 타임 딜레이 부여 3초
				Thread.sleep(3000);
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			int n1 = 10;
			int n2 = 20;
			String name = Thread.currentThread().getName();
			System.out.println(name + " : " + (n1 + n2));
		};
		
		Thread t = new Thread(task);
		t.start(); // 쓰레드 생성 및 실행
		System.out.println("End " + Thread.currentThread().getName());
	}
	//모든 쓰레드가 일을 마쳐야 프로그램 종료
	
	// 1단계  : Runnable을 구현한 인스턴스 생성
	// 2단계  : 쓰레드 인스턴스 생성
	// 3단계  : start 메소드 호출

}
