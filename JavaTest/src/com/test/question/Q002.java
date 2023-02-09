package com.test.question;

import java.util.Scanner;

public class Q002 {
    public static void main(String[] args) {
	//요구사항] 숫자 2개를 입력받아 아래의 연산식을 출력하시오.

	//조건1.출력 숫자에 천단위 표기하시오.
	//조건2.결과값은 소수 이하 1자리까지 표기하시오.

	//1. Scanner 클래스 출력
	//2. 라벨 출력
	//3. 사용자에게 첫 번째 숫자 입력 받기
	//4. 라벨 출력
	//5. 사용자에게 두 번째 숫자 입력 받기
	//6. 연산식 출력하기

	Scanner scan = new Scanner(System.in);

	//화면 설계
	System.out.print("첫 번째 숫자: "); //1.
	int num1 = scan.nextInt(); //2.

	System.out.print("두 번째 숫자: "); //3.
	int num2 = scan.nextInt();//4.

	System.out.printf("%d + %d = %,d\n", num1, num2, num1 + num2); //5.
	System.out.printf("%d - %d = %,d\n", num1, num2, num1 - num2);
	System.out.printf("%d * %d = %,d\n", num1, num2, num1 * num2);
	System.out.printf("%d / %d = %,.1f\n", num1, num2, (double)num1 / num2);
	System.out.printf("%d %% %d = %,d\n", num1, num2, num1 % num2);
	
	scan.close();

    }
}
