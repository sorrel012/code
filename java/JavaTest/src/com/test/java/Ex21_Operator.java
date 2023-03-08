package com.test.java;

import java.util.Scanner;

public class Ex21_Operator {
    public static void main(String[] args) {
	//요구사항] 사용자로부터 문자 1개를 입력 > 영어 소문자인지 검사?

	//시나리오
	//1. Scanner 생성하기
	//2. 라벨 출력하기
	//3. 문자 1을 입력 받기
	//4. 입력 받은 문자가 영어 소문자인지 검사? ★
	//5. 결과 출력

	Scanner scan = new Scanner(System.in); //1.

	//화면 설계
	System.out.print("문자 입력: "); //2.

	//System.out.println("a"); //3.
	String input = scan.nextLine();
	char ch = input.charAt(0);
	int code = ch;

	String result = ((code >= 97) && (code <= 122)) ? "소문자입니다." : "소문자가 아닙니다.";

	System.out.printf("입력받은 문자 '%c'은/는 %s\n", ch, result);

    }
}
