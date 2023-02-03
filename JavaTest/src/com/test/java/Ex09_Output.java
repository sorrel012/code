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
    }
}
