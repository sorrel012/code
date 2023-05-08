package com.test.question;

import java.util.Scanner;

/*

요구사항] 문장을 입력 받아 역순으로 출력하시오.

1. 변수 선언
2. 입력 도구 생성
3. 라벨 출력 + 문장 입력 받기
4. for문 + charAt() 활용하여 역순 출력

*/

public class Q080 {

    public static void main(String[] args) {

	String sentence = "";

	Scanner scan = new Scanner(System.in);

	System.out.print("문장 입력: ");
	sentence = scan.nextLine();

	System.out.print("역순 결과: \"");
	for(int i = sentence.length()-1; i >= 0; i--) {

	    char c = sentence.charAt(i);
	    System.out.print(c);
	}

	System.out.println("\"");

	scan.close();

    } //main

}
