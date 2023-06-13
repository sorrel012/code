package com.test.di02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {

		//스프링 설명
		//1. XMl 설정
		//2. 어노테이션 설정
		//3. 자바 설정
		
		
		//스프링 환경
		//- 객체 생성 ~ 소멸 > 스프링 관리
		//- XML 기발 > 설정 XML 정의
		
		//Pen 객체 생성하기
		Pen p1=  new Pen();
		p1.write();

		//Pen 객체 생성하기 > 스프링을 통해서 생성하기
		//ApplicationContext context = new ClassPathXmlApplicationContext("file:/src/main/java/com/test/di02/di02.xml");
		ApplicationContext context = new ClassPathXmlApplicationContext("com/test/di02/di02.xml");
		
		
		Pen p2 = (Pen)context.getBean("pen"); //id
		p2.write();
		
		Brush b1 = (Brush)context.getBean("b1"); //name
		b1.draw();
		
		Brush b2 = (Brush)context.getBean("b2"); //name
		b2.draw();
		
		Brush b3 = (Brush)context.getBean("brush"); //name
		b3.draw();
		
		
		// ----------------------------------------------
		
		//Hong hong = new Hong(펜);
		
		Hong hong = (Hong)context.getBean("hong");
		hong.run();
		
		Lee lee = (Lee)context.getBean("lee");
		lee.run();
		
	} //main
	
}
