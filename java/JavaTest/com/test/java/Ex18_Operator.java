package com.test.java;

public class Ex18_Operator {
    public static void main(String[] args) {
	//산술 연산자

	int a = 10;
	int b = 3;

	System.out.printf("%d + %d = %d\n", a, b, a + b);
	System.out.printf("%d - %d = %d\n", a, b, a - b);
	System.out.printf("%d * %d = %d\n", a, b, a * b);
	System.out.printf("%d / %d = %d\n", a, b, a / b); //몫
	System.out.printf("%d %% %d = %d\n", a, b, a % b); //나머지

	double c = 10;
	double d = 3;
	System.out.printf("%d / %d = %f\n", (int)c, (int)d, c/d);
	System.out.println();

	System.out.println(10 / 3);
	System.out.println(10.0 / 3);
	System.out.println(10 / 3.0);
	System.out.println(10.0 / 3.0);
	System.out.println();


	int e = 1000000000; //10억
	int f = 2000000000; //20
	System.out.println(e + f); // > overflow
	System.out.println(e + (long)f); // overflow 해결을 위해 둘 중 하나라도 long으로 형변환해야 함.

	e = 300000;
	f = 500000;
	System.out.println(e * (long)f);
	System.out.println();


	e = 10;
	f = 3;
	System.out.println(e % f);

	e = 10;
	f = 10;
	System.out.println(e % f);

	e = 10;
	f = 11;
	System.out.println(e % f);
	System.out.println();

	//달력 만들기 > 로직
	//1. 2023년 2월 1일 > 무슨 요일?
	//2. 2023년 2월의 마지막 일은 무슨 요일?

	//조건(날짜 % 7 > 나머지 4)

	byte b1 = 10;
	byte b2 = 20;

	System.out.println(b1 + b2);

	byte b3 = (byte)(b1 + b2); //b1 + b2 > int / () > 연산자 우선순위를 높여준다.


    }
}
