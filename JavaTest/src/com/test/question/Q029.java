package com.test.question;

import java.io.IOException;
import java.util.Scanner;

public class Q029 {
    
    /*
    
    요구사항]숫자 2개와 연산자 1개를 입력받아 연산 과정과 결과를 출력하시오.
    
    - 정수만 입력하시오.(유효성 검사 필요없음)
    - 나머지 연산 결과는 소수이하 첫째자리까지 출력하시오.
    - 연산자는 산술 연산자(+, -, *, /, %)만 입력하시오.
    
    1. 입력 도구 생성
    2. 라벨 출력 + 첫 번째 숫자 입력 받기
    3. 라벨 출력 + 두 번째 숫자 입력 받기
    4. 라벨 출력 + 산술 연산자 입력 받기
    5. 조건문: 연산자 유효성 검사 후 연산 결과 출력
    
     */
    
    public static void main(String[] args) throws IOException {

	int num1, num2 = 0;
	String operator = "";
	
	Scanner scan = new Scanner(System.in);

	System.out.print("첫 번째 숫자: ");
	num1 = scan.nextInt();

	System.out.print("두 번째 숫자: ");
	num2 = scan.nextInt();
	
	scan.nextLine(); //개행문자 처리

	System.out.print("연산자: ");
	operator = scan.next();
	
	if (operator.equals("+")) {
	    System.out.printf("%d + %d = %d\n", num1, num2, num1 + num2);
	} else if (operator.equals("-")) {
	    System.out.printf("%d - %d = %d\n", num1, num2, num1 - num2);
	} else if (operator.equals("*")) {
	    System.out.printf("%d * %d = %d\n", num1, num2, num1 * num2);
	} else if (operator.equals("/")) {
	    System.out.printf("%d / %d = %.1f\n", num1, num2, (double)num1 / num2);
	} else if (operator.equals("%")) {
	    System.out.printf("%d %% %d = %d\n", num1, num2, num1 % num2);
	} else {
	    System.out.println("연산이 불가능합니다.");
	}

    } //main
}
