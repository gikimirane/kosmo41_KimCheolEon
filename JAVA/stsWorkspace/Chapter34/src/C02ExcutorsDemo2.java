import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class C02ExcutorsDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Runnable task1 = () -> {
			String name = Thread.currentThread().getName();
			System.out.println(name + " : " + (5+7));
		};
		
		Runnable task2 = () -> {
			String name = Thread.currentThread().getName();
			System.out.println(name + " : " + (7-5));			
		};
		
		//쓰레드 풀 생성 고정 - 현재 2개만 쓰시오
		ExecutorService exr = Executors.newFixedThreadPool(2);
		exr.submit(task1);
		exr.submit(task2);
		exr.submit(() -> {
			String name = Thread.currentThread().getName();
			System.out.println(name + " : " + (5*7));
		});
	}
}
