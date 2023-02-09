package com.test.question;

import java.util.Scanner;

public class Q006 {
    public static void main(String[] args) {
	//요구사항] 사용자의 한달 수입을 입력받아 세후 금액을 출력하시오.

	//참고: 세금: 수입의 3.3%

	//1. 라벺 출력
	//2. 한달 수입 입력 받기
	//3. 세금 계산하기
	//4. 세후 금액 계산하기
	//5. 세후 금액, 세금 출력하기

	Scanner scan = new Scanner(System.in);

	System.out.print("한 달 수입 금액(원): "); 			//1.
	int income = scan.nextInt();				//2.
	double tax = income * 0.033;				//3.
	double afterTax = income - tax;				//4.

	System.out.printf("세후 금액(원): %,d원\n", (int)afterTax);	//5-1.
	System.out.printf("세금(원): %,d원\n", (int)tax);		//5-2.
	
	scan.close();

    }
}
