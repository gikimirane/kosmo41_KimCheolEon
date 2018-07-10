import java.io.Serializable;

public class E01Sbox implements Serializable { //인스턴스 직렬화 기본 조건
	String s;
	
	public E01Sbox(String s) {
		this.s = s;
	}
	public String get() {
		return s;
	}
}
