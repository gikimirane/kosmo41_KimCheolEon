abstract class Unit{
	abstract void attack();
}

class Marine extends Unit{
	
	public void attack() {
		System.out.println("총으로 공격");
		System.out.println("공격력 10");
	}
}

class Zealot extends Unit{
	
	public void attack() {
		System.out.println("손으로 공격");
		System.out.println("공격력 8");		
	}
}

class Zergling extends Unit{
	
	public void attack() {
		System.out.println("입으로 공격");
		System.out.println("공격력 9");
	}
}


public class A06Test_Polymorphism2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//테란	
		Unit unit1 = new Marine();
		unit1.attack();
		
		Unit unit2 = new Zealot();
		unit2.attack();
		
		Unit unit3 = new Zergling();
		unit3.attack();
	}
}
