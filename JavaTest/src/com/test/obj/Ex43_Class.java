package com.test.obj;

public class Ex43_Class {

	public static void main(String[] args) {

		Person p1 = new Person();

		p1.setName("홍길동");
		p1.setAge(20);
		p1.setAddress("서울시");

		String[] nick = { "멍멍이", "왈왈이", "쫑쫑이" };

//		p1.setNick(nick);
//
//		System.out.println(Arrays.toString(p1.getNick()));

		System.out.println();
		System.out.println();


		Person p2 = new Person();

		p2.setName("아무개");
		p2.setAddress("부산시");
		p2.setAge(30);

		String[] nick2 = { "강아지", "고양이", "송아지", "병아리", "고슴도치" };

//		p2.setNick(nick2);
//
//		System.out.println(Arrays.toString(p2.getNick()));

		Person p3 = new Person();

		p3.setName("아무개");
		p3.setAddress("부산시");
		p3.setAge(30);

		p3.addNick("강아지");
		p3.addNick("고양이");
		p3.addNick("고슴도치");

		System.out.println(p3.getNick());
		System.out.println(p3.getNick());

	} //main

}
