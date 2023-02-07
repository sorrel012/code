package com.test.question;

import java.util.Scanner;

public class Q012 {
    /*

     요구사항] 숫자를 전달하면 '짝수' 혹은 '홀수' 라는 단어를 반환하는 메소드를 선언하시오.

     - String getNumber(int)

     1. 짝수 / 홀수 반환하는 메소드 선언
     	1-1. 짝수인지 홀수인지 3항 연산자 이용하여 확인
     	1-2. 결과 반환
     2. 입력 도구 생성
     3. 라벨 출력
     3. 숫자 입력 받기
     4. 메소드 호출
     5. 결과 출력

     */

    public static void main(String[] args) {

	Scanner scan = new Scanner(System.in);

	System.out.print("숫자: ");
	int num = scan.nextInt();

	String evenOdd = getNumber(num);

	System.out.printf("입력하신 숫자 '%d'는(은) '%s'입니다.\n", num, evenOdd);

    } //main

    private static String getNumber(int num) {

	return num % 2 == 0 ? "짝수" : "홀수";

    } //getNumber
}
