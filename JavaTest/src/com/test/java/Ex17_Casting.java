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
    }
}
