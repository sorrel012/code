package com.test.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex12_BufferedReader2 {
    public static void main(String[] args) throws Exception {

	//요구사항] 사용자로부터 숫자 2개 입력 받기 > 두 수의 합 구하기(연산 과정도 같이 출력)

	// 1. 라벨 출력
		//System.out.print("숫자 입력: ");
	// 2. 숫자 1개 입력
		//System.out.println("5");
	// 3. 라벨 출력
		//System.out.print("숫자 입력: ");
	// 4. 숫자 1개 입력
		//System.out.println("10");
	// 5. 두 수의 합
	// 6. 연산 과정 출력
		//System.out.println("5 + 10 = 15");

	BufferedReader reader = new BufferedReader
		(new InputStreamReader(System.in));

	System.out.print("문자 입력: ");
	int code = reader.read();

    }
}
