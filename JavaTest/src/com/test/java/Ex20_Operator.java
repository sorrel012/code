package com.test.java;

import java.util.Scanner;

public class Ex20_Operator {
    public static void main(String[] args) {
	//대입 연산자

	int n = 10;
	System.out.println(n);

	//요구사항] n에 1을 더해서 다시 n에 넣어라 > 누적
	n += 7; //복합 연산자
	System.out.println(n);

	n -= 1;
	System.out.println(n);

	n -= 3;
	System.out.println(n);

	n *= 4;
	System.out.println(n);

	n /= 4;
	System.out.println(n);

	n %= 7;
	System.out.println(n);

	n %= 4;
	System.out.println(n);

	// 증감 연산자
	n = 10;
	System.out.println("n = " + n);

	++n;
	System.out.println("++n = " + n);
	n++;
	System.out.println("n++; 후 n = " + n);
	System.out.println("n++ = " + n++);
	System.out.println("n = " + n);

	--n;
	System.out.println("n--; 후 n = " + n);
	System.out.println("n-- = " + n--);
	System.out.println("n = " + n);
	System.out.println();

	//개선 전1
	n = 10;
	int result = 0;
	result = 10 + ++n;
	System.out.println(result);

	//개선 후1 > 되도록 증감 연산자는 다른 연산자와 한 문장에서 사용하지 말 것
	n = 10;
	result = 0;
	++n;
	result = 10 + n;
	System.out.println(result);

	n = 10;
	result = 0;
	result = 10 + n++;
	System.out.println(result);
	System.out.println(n);

	int o = 10;

	System.out.println(--o-o--); //9-9 = 0
	System.out.println(o); //8

	//조건 연산자

	boolean flag = true;
	String m1 = "참";
	String m2 = "거짓"	;

	String m3 = flag ? m1: m2;

	System.out.println("m3 = " + m3);
	System.out.println();

	//나이 > 성인?
	Scanner scan = new Scanner(System.in);

	System.out.print("나이: ");

	int age = scan.nextInt();

	System.out.println(age >= 19 ? "통과" : "거절");
	System.out.println(age % 2 == 0 ? "짝수" : "홀수");
	
	scan.close();
	
	
	//문자열 연산자
	
	System.out.println(10 + 20); //		+ > 산술 연산자
	
	System.out.println("홍길동" + "아무개"); // + > 문자열 연산자
	
	System.out.println(10 + 20 + 30);	//60
	System.out.println(10 + 20 + "30");	//3030
	System.out.println(10 + "20" + 30);	//102030
	System.out.println("10" + 20 + 30);	//102030
	System.out.println("10" + (20 + 30));	//1050
	
    }
}