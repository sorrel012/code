package com.test.question;

import java.util.Scanner;

/*

요구사항]이메일 주소를 입력 받아 아이디와 도메인을 각각 추출하시오.

1. 변수 선언
2. 입력 도구 생성
3. 라벨 출력 + 이메일 입력 받기
4. split로 구분하여 따로 출력하기

*/

public class Q081 {

    public static void main(String[] args) {

	String email = "";
	String id = "";
	String domain = "";

	Scanner scan = new Scanner(System.in);

	System.out.print("이메일: ");
	email = scan.nextLine();

	String[] emailArr = email.split("@");

	id = emailArr[0];
	domain = emailArr[1];

	System.out.println("아이디: " + id);
	System.out.println("도메인: " + domain);

	scan.close();

    } //main

}
