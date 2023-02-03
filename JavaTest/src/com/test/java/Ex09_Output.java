package com.test.java;

public class Ex09_Output {
    public static void main(String[] args) {

	//숫자 + 형식문자 > 정렬
	int num = 123;

	System.out.printf("[%d]\n", num);
	System.out.printf("[%10d]\n", num);
	System.out.printf("[%-10d]\n", num);
	System.out.println();


	// %.숫자f
	double num2 = 3.581;

	System.out.println(num2);
	System.out.printf("%f\n", num2);
	System.out.printf("%.2f\n", num2);
	System.out.printf("%.1f\n", num2);
	System.out.printf("%.0f\n", num2);

	System.out.printf("%10.1f\n", num2);
	System.out.println();

	// %,d, %,f
	int price = 123456789;

	System.out.printf("금액 : %d원\n", price);
	System.out.printf("금액 : %,d원\n", price);
	System.out.println();

	// 전체 너비 20칸 + 천단위 표기 + 소수점 아래 2자리까지
	double num3 = 1234567.89012345;

	System.out.printf("%,20.2f\n", num3);
	System.out.println();
	System.out.println();
	System.out.println();

	//메뉴판 출력

	// 주의!!! 숫자를 출력할 땐 반드시 단위를 표기해야 함.
	System.out.println("======================");
	System.out.println("       음료 가격");
	System.out.println("======================");
	System.out.printf("콜라:\t\t%,6d\n", 2500);
	System.out.printf("사이다:\t\t%,6d\n", 3500);
	System.out.printf("아메리카노:\t\t%,6d\n", 5000);
	System.out.printf("케이크:\t\t%,6d\n", 12000);


    }
}
