package com.text.obj.constructor;

public class Ex48_Constructor {

	public static void main(String[] args) {

		//배열은 따로 초기화를 안 해도 자동으로 생성자가 초기화 해줌.
		int[] ns = new int[5];
		
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
