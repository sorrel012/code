package com.test.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex19_Operator {
    public static void main(String[] args) throws IOException {

	//비교 연산자
	int a = 10;
	int b = 3;

	System.out.println(a > b);
	System.out.println(a >= b);
	System.out.println(a < b);
	System.out.println(a == b);
	System.out.println(a != b);
	System.out.println();


	boolean b1 = true;
	boolean b2 = true;

	System.out.println(b1 == b2);
	System.out.println(b1 != b2);

	String s1 = "홍길동";
	String s2 = "홍길동";
	String s3 = "아무개";
	String s4 = "홍";
	s4 += "길동";

	System.out.println(s1 == s2);
	System.out.println(s1 == s3);
	System.out.println(s4);
	System.out.println(s1 == s4);
	System.out.println(s1.equals(s2));
	System.out.println(s1.equals(s4));
	System.out.println();


	//논리 연산자

	//요구사항] 사용자 나이 입력 > 19세 이상~ 60세 미만
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	System.out.print("당신의 나이는 몇 살인가요?: ");
	String input = reader.readLine();
	int age = Integer.parseInt(input);
	System.out.println(age >= 19 && age < 60);
	System.out.println();

	System.out.println(true && true);
	System.out.println(true && false);
	System.out.println(false || false);
	System.out.println(false || true);
	System.out.println(!true);
	System.out.println();

	a = 10; //1010
	b = 3; //0011

	System.out.println(a & b); //0010 > 2
	System.out.println(a | b); //1011 > 11
	System.out.println(a ^ b); //1001 > 9
	System.out.println(true ^ true);
	System.out.println(true ^ false);
	System.out.println(false ^ true);
	System.out.println(false ^ false);

    }
}
