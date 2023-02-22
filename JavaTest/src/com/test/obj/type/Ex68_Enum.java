package com.test.obj.type;

public class Ex68_Enum {

	public static void main(String[] args) {

		//요구사항] 의류 쇼핑몰 > 티셔츠 > 고객 방문 > 색상 선택(빨강, 노랑, 파랑)

		//	m1();
		//	m2();
		m3();

	} //main

	private static void m1() {

		//Case 1. 주관식 > 오타 발생 확률 높음..
		String color = "빨강";

		if (color.equals("빨강") || color.equals("노랑") || color.equals("파랑") ) {
			System.out.println("판매 가능");

		} else {
			System.out.println("재고 없음");
		}
	}


	private static void m2() {

		//Case 2.객관식
		int input = Color.YELLOW;

		if(input == 0 || input == 1 || input == 2) {
			System.out.println("판매 가능");

		} else {
			System.out.println("재고 없음");
		}

	}

	private static void m3() {
		
		//Case3. Enum
		Colors input2 = Colors.RED;
		
		if (input2 == Colors.RED || input2 == Colors.YELLOW || input2 == Colors.BLUE) {
			System.out.println("판매 가능");

		} else {
			System.out.println("재고 없음");
		}
		
		Gender gender = Gender.FEMALE;
		
	}

}

class Color {
	public final static int RED = 0;
	public final static int YELLOW = 1;
	public final static int BLUE = 2;
}

enum Colors {
	RED,
	YELLOW,
	BLUE
}

enum Gender {
	MALE,
	FEMALE
}