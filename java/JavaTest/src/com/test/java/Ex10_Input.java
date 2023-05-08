package com.test.java;

public class Ex10_Input {
    public static void main(String[] args) throws Exception {
	//요구사항] 사용자에게 문자 1개를 입력 받아 화면에 출력하시오.

	//1. 안내 메시지 출력
	//2. 키 입력 받기
	//3. 입력 받은 키를 화면에 출력하기

	// 설계 > 화면 설계 > 화면 구현

	System.out.print("문자를 입력하세요 : "); // 1.라벨
	int code = System.in.read();
	System.out.printf("입력한 문자는 %c입니다.\n", code);
	// <문자 코드값>
	// A : 65
	// a : 97
	// 0 : 48


//	Scanner sc = new Scanner(System.in); // 2. 사용자 입력 - scanner
//	String input = sc.nextLine();
//	System.out.printf("입력한 문자는 %s입니다.\n", input); // 3. 출력
    }
}
