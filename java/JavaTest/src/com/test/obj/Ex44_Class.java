package com.test.obj;

public class Ex44_Class {

	public static void main(String[] args) {

//		Member hong = new Member();
//
//		hong.setName("홍길동");
//		hong.setId("hong");
//
//		Calendar regdate = Calendar.getInstance();
//		regdate.set(2023, 0, 10);
//		hong.setRegedate(regdate);
//
//		System.out.printf("%tF\n", hong.getRegedate() );


		Member lee = new Member();

		lee.setName("이순신");
		lee.setId("lee");
		lee.setRegdate(2023, 1, 10);

		System.out.println(lee.getRegdate());


	} //main

}
