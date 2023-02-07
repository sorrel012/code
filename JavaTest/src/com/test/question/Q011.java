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

	int addNum = add(5, 3);
	int subNum = sub(5, 3);
	int mulNum = mul(5, 3);
	double divNum = div(5, 3);
	int modNum = mod(5, 3);

	System.out.printf("%d + %d = %d\n", num1, num2, addNum);
	System.out.printf("%d - %d = %d\n", num1, num2, subNum);
	System.out.printf("%d * %d = %d\n", num1, num2, mulNum);
	System.out.printf("%d / %d = %.1f\n", num1, num2, divNum);
	System.out.printf("%d %% %d = %d\n", num1, num2, modNum);

    } //main

    private static int mod(int num1, int num2) {
	return num1 % num2;
    } //mod

    private static double div(int num1, int num2) {
	return (double)num1 / num2;
    } //div

    private static int mul(int num1, int num2) {
	return num1 * num2;
    } //mul

    private static int sub(int num1, int num2) {
	return num1 - num2;
    } //sub

    private static int add(int num1, int num2) {
	return num1 + num2;
    } //add
}
