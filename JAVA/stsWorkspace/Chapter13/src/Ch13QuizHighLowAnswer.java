import java.util.Random;
import java.util.Scanner;

public class Ch13QuizHighLowAnswer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);

		Random rand = new Random();

		while (true) {
			System.out.println("나는 지금 0부터 100 사이의 값 중에 하나를 생각하겠습니다.");
			System.out.println("당신은 그 숫자를 6회 안에 맞추시면 됩니다.");

			int com = rand.nextInt(101);
			

			for (int i = 0; i < 6; i++) {
				int user = s.nextInt();

				if (com < user)
					System.out.println(user + " 는 제가 정한 숫자보다 큽니다.");
				if (com > user)
					System.out.println(user + " 는 제가 정한 숫자보다 작습니다.");
				if (com == user) {
					if (com < user)
						System.out.println(user + " 는 정답입니다.");
					break;
				}

				if (i < 5) {
					System.out.println((6 - i - 1) + "회 남았습니다.");
				} else {
					System.out.println("모든 기회를 다 사용했습니다.");
					System.out.println("생각한 숫자 : " + com);
				}
			}

			System.out.println("게임을 더 진행하시겠습니다? (y/n)");
			String str = s.next();
			if (!str.equals("y")) {
				System.out.println("안녕히 가세요.");
				break;
			}
		}

	}

}
