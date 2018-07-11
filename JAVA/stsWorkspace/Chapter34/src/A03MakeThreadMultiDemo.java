
public class A03MakeThreadMultiDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Runnable task1 = () -> { //20 미만 짝수 출력, 딜레이 1초
			try {
				for(int i = 0; i < 20; i++) {
					if(i % 2 == 0) {
						System.out.print(i + " ");
						Thread.sleep(1000);
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		};
		
		Runnable task2 = () -> { // 20미만 홀수 출력, 딜레이 0.5 초
			try {
				for(int i = 0; i < 20; i++) {
					if(i % 2 == 1) {
						System.out.print(i + " ");
						Thread.sleep(500);
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		};
		
		Thread t1 = new Thread(task1);
		Thread t2 = new Thread(task2);
		
		t1.start();
		t2.start();

	}

}
