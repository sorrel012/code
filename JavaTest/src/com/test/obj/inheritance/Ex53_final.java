package com.test.obj.inheritance;

public class Ex53_final {
	
	public static void main(String[] args) {

		//지역 변수
		int a = 10;
		a = 20;
		a = 30;
		
		final int b = 10;
		//b = 20; > 불가
		
		// 비권장 > 일반 변수처럼 보임
		final int c;
		c = 10;
		
		// 권장
		final int d= 10;
		
		//상수명은 모두 대문자로 작성 > 변수와 구분짓기 위해
		final double PI = 3.14;

	} //main
	
}


class Gender {
	
	//남자(1), 여자(2)
}
