package com.study.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// 검색된 클래스를 빈으로 등록할 때, 클래스의 첫 글자를 소문자로 바꾼 이름을
// 빈의 이름으로 사용한다.
@Component
public class Hello {
	@Value("홍길동")
	private String name;
	@Value("전우치")
	private String nickname;
	@Autowired
	@Qualifier("printerA")
	private Printer printer;

	// 생성용 Setter 메서드 없어도 된다. (초기에 생성하는 거 말하는듯)
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public void setNickname(String nickname) {
//		this.nickname = nickname;
//	}

	public void setPrinter(Printer printer) {
		this.printer = printer;
	}

	public String sayHello() {
		return "Hello " + name + " : " + nickname;
	}

	public void print() {
		printer.print(sayHello());
	}
}
