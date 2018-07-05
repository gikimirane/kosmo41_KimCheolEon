import java.util.*;

public class A02isNumber2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String value = "1234";
		String ch = "";
		boolean isNumber = true;

		for (int i = 0; i < value.length(); i++) {
			ch = value.substring(i, i+1);

			try {
				int num = Integer.parseInt(ch);
			} catch (Exception e) {
				isNumber = false;
				break;
			}

		}

		if (isNumber) {
			System.out.println(value + "는 숫자입니다");
		} else {
			System.out.println(value + "는 숫자가 아닙니다.");
		}

	}

}
