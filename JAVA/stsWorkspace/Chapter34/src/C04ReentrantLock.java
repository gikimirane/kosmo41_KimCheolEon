import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

//Syncronized 를 대신하기 위해 나중에 나왔기 때문에, 얘가 더 좋음
// 그런데 정직하게 1000 을 찍고 다시 내려오는게 아니라, 둘이 동작하면서 오르락 내리락 함

class Counter04 {
	int count = 0;
	ReentrantLock criticObj = new ReentrantLock();

	public void increment() {
		criticObj.lock();

		try {
			count++;
		} finally {
			criticObj.unlock();
		} // 반드시 락을 풀어야 하기 때문에 finally에 unlock을 실음
	}

	public void decrement() {
		criticObj.lock();

		try {
			count--;
		} finally {
			criticObj.unlock();
		}
	}

	public int getCount() {
		return count;
	}
}

public class C04ReentrantLock {

	public static Counter04 cnt = new Counter04();

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		Runnable task1 = () -> {
			for (int i = 0; i < 1000; i++) {
				cnt.increment();
				System.out.println(cnt.getCount());
			}
		};

		Runnable task2 = () -> {
			for (int i = 0; i < 1000; i++) {
				cnt.decrement();
				System.out.println(cnt.getCount());
			}
		};

		ExecutorService exr = Executors.newFixedThreadPool(2);
		exr.submit(task1);
		exr.submit(task2);
		exr.shutdown();
		exr.awaitTermination(100, TimeUnit.SECONDS);

		System.out.println(cnt.getCount());
	}
}
