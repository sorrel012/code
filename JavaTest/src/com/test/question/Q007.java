package com.test.question;

import java.util.Scanner;

public class Q007 {
    public static void main(String[] args) {
	//요구사항] 영문 소문자를 1글자 입력 받은 후 대문자로 변환해서 출력하시오.

	//참고: 문자 코드

	//1. 라벨 출력
	//2. 소문자 입력 받기
	//3. 소문자를 대문자로 변환하기
	//4. 변환 결과 출력하기

	Scanner scan = new Scanner(System.in);

	System.out.print("문자 입력: ");
	char lowerCase = scan.nextLine().charAt(0);
	int lowerCaseCode = lowerCase;
	char upperCase = (char)(lowerCaseCode - 32);

	System.out.printf("소문자 '%c'의 대문자는 '%c'입니다.\n", lowerCase, upperCase);

    }
}
