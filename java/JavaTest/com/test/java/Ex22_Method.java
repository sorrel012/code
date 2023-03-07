package com.test.java;

public class Ex22_Method {
    //요구사항] "안녕하세요." x 5회 출력
    public static void main(String[] args) {
	hello();
	hello();
	hello();
	hello();
	hello();
    }
//  접근지정자	정적키워드	반환자료형	메소드명	인자리스트	> 선언부, 시그니처(sign)
    public	static 	void	hello	() {
	System.out.println("안녕하세요");	//	> 구현부(Body)
    }
}
