import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

//http://tomining.tistory.com/10
//참고

public class C03CallableAndFuture {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		
		Callable<Integer> task = () -> {
			int sum = 0;
			for(int i = 0; i < 10; i++) {
				sum += i;
			}
			return sum;
		};
		
		ExecutorService exr = Executors.newSingleThreadExecutor();
		Future<Integer> fur = exr.submit(task);
		
		Integer r = fur.get();	// 쓰레드의 반환 값 획득
		System.out.println("result : " + r);
		exr.shutdown();

	}

}
