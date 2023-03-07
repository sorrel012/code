package com.test.question;

import java.util.Scanner;

public class Q011 {

    /*

     요구사항] 숫자를 2개 입력받아 연산식을 반환하는 메소드를 선언하시오.

     - String add(int, int)
     - String subtract(int, int)
     - String multiply(int, int)
     - String divide(int, int)
     - String mod(int, int)

     1. 연산 메서드 5가지 생성하기 > int 반환 필요
     2. Scanner 불러오기
     3. 라벨 출력
     4. 첫 번째 숫자 입력 받기
     5. 라벨 출력
     6. 두 번째 숫자 입력 받기
     7. 메소드 호출하기

     */

    public static void main(String[] args) {

	Scanner scan = new Scanner(System.in);

	System.out.print("첫 번째 숫자: ");
	int num1 = scan.nextInt();

	System.out.print("두 번째 숫자: ");
	int num2 = scan.nextInt();
	System.out.println();

	System.out.println(add(num1, num2));
	System.out.println(sub(num1, num2));
	System.out.println(mul(num1, num2));
	System.out.println(div(num1, num2));
	System.out.println(mod(num1, num2));
	
	scan.close();

    } //main

    private static String mod(int num1, int num2) {
	String result = String.format("%d %% %d = %d", num1, num2, num1 % num2);
	return result;
    } //mod

    private static String div(int num1, int num2) {
	String result = String.format("%d / %d = %.1f", num1, num2, (double)num1/ num2);
	return result;
    } //div

    private static String mul(int num1, int num2) {
	String result = String.format("%d * %d = %d", num1, num2, num1 * num2);
	return result;
    } //mul

    private static String sub(int num1, int num2) {
	String result = String.format("%d - %d = %d", num1, num2, num1 - num2);
	return result;
    } //sub

    private static String add(int num1, int num2) {
	String result = String.format("%d + %d = %d", num1, num2, num1 + num2);
	return result;
    } //add
}
