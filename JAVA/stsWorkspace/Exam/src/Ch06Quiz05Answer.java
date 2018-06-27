// System Resource 효율적인 사용

import java.util.Scanner;

public class Ch06Quiz05Answer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("단어 입력 : ");
		String word = s.next();
		
		String[] array_word = new String[word.length()];
		
		for(int i = 0; i < array_word.length; i++) {
			array_word[i] = Character.toString(word.charAt(i));
		}
		
		int nMax1 = array_word.length;
		int nMax2 = array_word.length/2;
		
		for(int i = 0; i < nMax2; i++) {
			if(!array_word[i].equals(array_word[nMax1-1-i])){
				System.out.println("회문이 아닙니다. " + i + " : " + (nMax1-1-i));
				return;
			}
		}
		
		System.out.println("회문입니다.");

	}

}
