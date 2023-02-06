package com.test.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Ex17_Casting {
    public static void main(String[] args) throws IOException {

	//요구사항] 숫자 2개를 입력 받아 두수의 합을 구하시오.

	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	System.out.print("첫 번째 숫자: ");
	String input1 = reader.readLine();

	System.out.print("두 번째 숫자: ");
	String input2 = reader.readLine();

	int num1 = Integer.parseInt(input1);
	int num2 = Integer.parseInt(input2);

	System.out.printf("두 숫자의 합은 %d입니다.\n", num1 + num2);

	//참조형(String) > 값형
	// - 래퍼클래스/parseXXX()

	byte n1 = Byte.parseByte("10");
	short n2 = Short.parseShort("10");
	int n3 = Integer.parseInt("10");
	long n4 = Long.parseLong("10");
	float n5 = Float.parseFloat("3.14");
	double n6 = Double.parseDouble("3.14");
	boolean n7 = Boolean.parseBoolean("true");

	//값형 > 참조형(String)
	// - String.valueOf();
	String s1 = String.valueOf(10);
	String s2 = String.valueOf(3.14);
	String s3 = String.valueOf("true");
    }
}
