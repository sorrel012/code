package com.test.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex12_BufferedReader {
    public static void main(String[] args) throws Exception {


	BufferedReader reader = new BufferedReader
		(new InputStreamReader(System.in)); // 입력 도구 생성하기 > reader

	System.out.print("문자 입력: ");
	int code = reader.read();
	System.out.printf("출력: %c\n", code);
	System.out.println("종료");

	System.out.println();


	BufferedReader reader2 = new BufferedReader
		(new InputStreamReader(System.in));

	System.out.print("이름 입력: ");
	String txt = reader2.readLine();
	System.out.printf("안녕하세요. %s님.\n",txt);

	System.out.println();


	BufferedReader reader3 = new BufferedReader
		(new InputStreamReader(System.in));

	System.out.print("숫자 입력: ");
	String input = reader3.readLine();
	int num = Integer.parseInt(input); // > 숫자를 입력 받아야 할 때는 형변환 필요
	System.out.println(100-num);

	System.out.println();


	BufferedReader reader4 = new BufferedReader
		(new InputStreamReader(System.in));

	System.out.print("숫자 입력: ");
	String input2 = reader4.readLine();
	double num2 = Double.parseDouble(input2); // > 숫자를 입력 받아야 할 때는 형변환 필요
	System.out.println(100-num2);

    }
}
