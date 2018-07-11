import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class D01SyncArrayList {

	//신버전
	public static List<Integer> lst = 
			Collections.synchronizedList(new ArrayList<Integer>());
	
	//구버전
//	public static List<Integer> lst = new ArrayList<Integer>();
	
	//신버전 - 싱크로나이즈리스트를 쓰고 스레드에 리스트 싣고 돌림
	//구버전 - 리스트를 스레드에 넣고 그걸 싱크로나이즈 해서 돌림
	
	// 근데 이상하게도 신버전이 예상한 바와 다르게 나오고 구버전이 우리가 예상한대로 뜸
	// 이터레이터 반복자를 의심중임
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		for(int i = 0; i < 16; i++) {
			lst.add(i);
		}
		System.out.println(lst);
		
		//신버전
		Runnable task = () -> {
			ListIterator<Integer> itr = lst.listIterator();
			
			while(itr.hasNext()) {
				itr.set(itr.next() + 1);
				System.out.print(itr.next() + " ,");
			}
			System.out.println();
		};
		
		//구버전
//		Runnable task = () -> {
//			synchronized (lst) {
//				ListIterator<Integer> itr = lst.listIterator();
//				
//				while(itr.hasNext()) {
//					itr.set(itr.next() + 1);
//				}
//			}
//		};
		
		ExecutorService exr = Executors.newFixedThreadPool(3);
		
		exr.submit(task);
		exr.submit(task);
		exr.submit(task);
		
		exr.shutdown();
		exr.awaitTermination(100, TimeUnit.SECONDS);
		System.out.println(lst);
	}
}
