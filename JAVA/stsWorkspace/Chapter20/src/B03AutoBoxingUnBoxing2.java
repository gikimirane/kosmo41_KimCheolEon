
public class B03AutoBoxingUnBoxing2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Integer num = 10;
		
		num++;	// new Integer(num.intValue() + 1); -> 오토 박싱과 언박싱
		System.out.println(num);
		
		num += 3;	// new Integer(num.intValue() + 3);	
		System.out.println(num);
		
		int r = num + 5;			//오토 언박싱
		Integer rObj = num - 5;		//오토 언박싱
		
		System.out.println(r);
		System.out.println(rObj);

	}

}
