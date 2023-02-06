package com.test.question;

import java.util.Scanner;

public class Q001 {
    public static void main(String[] args) {
	//요구사항

	//1. 라벨 출력
	//2. 사용자 입력 받기
	//3. 나이 계산하기
	//4. 출력하기

	Scanner scan = new Scanner(System.in);

	//화면 설계
	System.out.print("태어난 년도: "); //1.

	int birthYear = scan.nextInt(); //2.

	int age = 2023 - birthYear + 1; //3.

	System.out.printf("나이: %d", age); //4.

    }
}
