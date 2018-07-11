import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class C01ExcutorsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Runnable task = () -> {
			int n1 = 10;
			int n2 = 20;
			String name = Thread.currentThread().getName();
			System.out.println(name + " : " + (n1 + n2));
		};
		
		ExecutorService exr = Executors.newSingleThreadExecutor();
		exr.submit(task);	//쓰레드 풀에 작업 전달
		
		System.out.println("End " + Thread.currentThread().getName());
		exr.shutdown();		//쓰레드 풀과 그 안의 쓰레드 소멸
	}

}
