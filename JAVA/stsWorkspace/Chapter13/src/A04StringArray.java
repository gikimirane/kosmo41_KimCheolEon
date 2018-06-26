
public class A04StringArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] sr = new String[7];
				
		sr[0] = new String("Java");
		sr[1] = new String("System");
		sr[2] = new String("Compiler");
		sr[3] = new String("Park");
		sr[4] = new String("Tree");
		sr[5] = new String("Dinner");
		sr[6] = new String("Brunch Cafe");
		
		//각 원소에 문자열 넣고
		//하나씩 렝스 세서 더함
		int cNum = 0;
		for(int i =0; i < sr.length; i++) {
			cNum += sr[i].length();			
		}
		System.out.println("총 문자의 수 : " + cNum);
	}

}
