package com.test.obj.constructor;

public class Ex48_Constructor {

	public static void main(String[] args) {
		
		Student s1 = new Student();
		
		s1.setName("홍길동");
		s1.setKor(100);
		s1.setEng(90);
		s1.setMath(80);
		
		System.out.println(s1.info());
		
		
		Student s2 = new Student("아무개", 90, 85, 95);
		
		System.out.println(s2.info());

	} //main

}
