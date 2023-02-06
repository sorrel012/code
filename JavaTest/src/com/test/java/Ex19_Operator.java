package com.test.java;

import java.io.IOException;

public class Ex19_Operator {
    public static void main(String[] args) throws IOException {

	int a = 10;
	int b = 3;

	System.out.println(a > b);
	System.out.println(a >= b);
	System.out.println(a < b);
	System.out.println(a == b);
	System.out.println(a != b);
	System.out.println();

	//요구사항] 사용자 나이 입력 > 성인(19세 이상) O, X

//	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

//	System.out.print("당신의 나이는 몇 살인가요?: ");
//	String input = reader.readLine();
//	int age = Integer.parseInt(input);
//
//	System.out.println(age >= 19);
//	System.out.println();


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

    }
}
