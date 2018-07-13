
public class SubStringAnswer {

	public static void main(String[] args) {

//		String str1 = "/to 홍길동 Hello~  Hi";
//		String str2 = "안녕하세요";
//
//		// 1. "/to 대상" 에 다음 변수 입력, 초기화 토글
//		String sToHeader = "/to aaaaa";
//
//		// 3. 고정 대상인 상태에서 임시 대상에게 귓속말
//		if (str1.indexOf("/to") >= 0) {
//			System.out.println(str2);
//		} else {
//			// 2.무조건 붙여서 보내기
//			System.out.println(sToHeader + str2);
//		}
		
		StrFunc();
	}

	public static void StrFunc() {

		String str1 = "/to 홍길동 Hello~  Hi";
		String str2 = "/list";
		String str3 = "안녕하세요.";

		if (str1.indexOf("/to") >= 0) {
			int nTmp1 = str1.indexOf(" ");
			String strTmp = str1.substring(nTmp1 + 1);

			nTmp1 = strTmp.indexOf(" ");
			strTmp = strTmp.substring(nTmp1 + 1);
			System.out.println(strTmp);
		}

	}

}
