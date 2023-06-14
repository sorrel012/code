package com.test.aop1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {

		//주업무 객체
		//Memo memo = new MemoImpl();
		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/test/aop1/memo.xml");
		
		Memo memo = (Memo)context.getBean("memo");
		
		memo.add("스프링 AOP");
		
		try {
			String txt = memo.read(15);
			System.out.println(txt);
			
		} catch (Exception e) {
			e.printStackTrace();
			//DB insert..
			//담당자 메일 or 메시지
		}
		
		memo.edit(5, "수정한 내용");
		
		memo.del(5);

	} //main
	
}
