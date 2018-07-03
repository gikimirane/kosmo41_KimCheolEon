class Person{
	String name;
	
	public Person(String name) {
		this.name = name;
	}
	
	@Override
	protected void finalize() throws Throwable{
		super.finalize();	//상위 클래스의 finalize 메소드 호출
		System.out.println("destroyed : " + name);
	}
}

public class A01ObjectFInalize {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Person p1 = new Person("Yoon");
		Person p2 = new Person("Park");
		
		p1 = null;
		p2 = null;
		
		System.gc();				//gc 만 살리면 프로그램 종료후에 destroyed 실행
		System.runFinalization();	//runfinalization 같이 살리면 죽기전에 실행하는데..?
		
		System.out.println("end of program");
	}

}
