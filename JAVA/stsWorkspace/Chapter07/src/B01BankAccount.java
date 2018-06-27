class BankAccount{
	
	int balance = 0;
	
	public int deposit(int amount) {
		balance += amount;
		return balance;
	}
	
	public int withdraw(int amount) {
		balance -= amount;
		return balance;
	}
	
	public int checkMyBalance() {
		System.out.println("잔액 : " + balance);
		return balance;
	}
	
}


public class B01BankAccount {
	public static void main(String[] args) {
	
		//두 개 인스턴스 생성
		BankAccount yoon = new BankAccount();
//		BankAccount park = new BankAccount();
		BankAccount park = yoon;
		
		//각 인스턴스 대상 예금 진행
		yoon.deposit(3000);
		park.deposit(2000);
		
		//각 인스턴스 대상 출금 진행;
		yoon.withdraw(400);
		park.withdraw(300);
		
		//각 인스턴스 대상 잔액 조회
		yoon.checkMyBalance();
		park.checkMyBalance();		
	}
}
