class Board{}
class PBoard extends Board{}


public class C02ClassCastException {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Board pbd1 = new PBoard();
		PBoard pbd2 = (PBoard)pbd1;		//OK!
		
		System.out.println(".. intermediate location ..");
		
		Board ebd1 = new Board();
		PBoard ebd2 = (PBoard)ebd1; // Excption!
	}

}
