package com.test.java;

public class Ex05_Variable {
    public static void main(String[] args) {
	//정수형
	byte b1;
	b1 = 10; //데이터를 표현한 10 > 리터럴(Literal), 상수(Constant) > 정수형 리터럴
	System.out.println(b1);

	System.out.println(Integer.MAX_VALUE); //int 최댓값
	System.out.println(Integer.MIN_VALUE); //int 최솟값

	long l1 =  3000000000L; //long에 대입할 상수 범위 이해 필요

	//실수형
	double d1 = 3.14; // 실수형 리터럴
	System.out.println(d1);

	//float  > 단전도형
	//double > 배정도형

	float f1;

	f1 = 123.1234567890123456789012345678901234567890F; // 소수점 아래 5자리까지
	System.out.println("f1 = " + f1);

	d1 = 123.1234567890123456789012345678901234567890D; // 소수점 아래 14자리
	System.out.println("d1 = " + d1);

	f1 = 922000000000F;
	System.out.println("f1 = " + f1);

	d1 = 123456789012345678901234567890123456789D;
	System.out.println("d1 = " + d1);

	//문자형
	char c1 = 'A'; // 문자 리터럴 표기법
	System.out.println("c1 = " + c1);

	c1 = '가';
	System.out.println("c1 = " + c1);

	c1 = '@';
	System.out.println("c1 = " + c1);

	c1 = '1'; //숫자 1 x , 문자 1!
	System.out.println("c1 = " + c1);

	c1 = '\0';
	System.out.println("c1 = " + c1); // 빈 문자 > null 값

	//논리형
	boolean flag;

	flag = true; // > 논리형 리터럴
	flag = false;

	System.out.println(flag);

	//문자열, String - 참조형 > 문자들의 집합 > char 여러 개 모인 형태(한 개 이상)

	String name;
	name = "홍길동"; //문자열 리터럴("")
	System.out.println(name);

    }
}
