class MyCopyBook{
	int price;
	String title;
	
	MyCopyBook(String t, int p){
		title = t;
		price = p;
	}
	// 언제 사용하느냐? 초기값을 일치시키고 싶을때?
	MyCopyBook(MyCopyBook copy){
		title = copy.title;
		price = copy.price;
	}
	
	void print() {
		System.out.println("제      목 : " + title);
		System.out.println("가      격 : " + price);
	}
}

public class CopyBooks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MyCopyBook bookCopy = new MyCopyBook("게임스쿨", 10000);
		bookCopy.print();
		
		// 아마 이 부분을 염두에두고 말씀하시는 것 같다. bookCopy2 는 bookCopy 로 초기화된후에 사용함
		// 질문하였는데, 생각한게 맞음. - 형태가 같은 클래스들 쭉 쓸때 초기화를 담당할 객체 냅두고 걔로 다 초기화시켜버리는거임
		MyCopyBook bookCopy2 = new MyCopyBook(bookCopy);
		bookCopy2.title = "모바일게임";
		bookCopy2.print();

	}

}
