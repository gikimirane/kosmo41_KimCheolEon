class Person{
	private int regiNum;
	private int passNum;
	
	Person(int rnum, int pnum){
		regiNum = rnum;
		passNum = pnum;
	}
	
	Person(int rnum){
//		regiNum = rnum;
//		passNum = 0;
		this(rnum, 0);
	}
	
	void showPersonalInfo() {
		System.out.println(regiNum);
		System.out.println(passNum);
	}
}


public class A01ContructorOverloading {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//여권 있는 사람
		Person jung = new Person(335777, 112333);
		
		//여권 없는 사람
		Person hong = new Person(775444);
		
		jung.showPersonalInfo();
		hong.showPersonalInfo();
	}

}
