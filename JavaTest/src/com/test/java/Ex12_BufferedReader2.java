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

	System.out.print("숫자 입력: ");
	String input1 = reader.readLine();

	System.out.print("숫자 입력: ");
	String input2 = reader.readLine();

	int num1 = Integer.parseInt(input1);
	int num2 = Integer.parseInt(input2);

	//Q. 정수형으로 입력 받을 때 reader.read() 를 사용하면 되지 않나요?
	//   왜 굳이 readLine()을 써서 문자열로 입력 받고 다시 정수형으로 변환하나요?
	//A: read()는 여러 개를 입력할 수 없다! 객체를 여러 개 생성해서 각기 다른 참조 변수를 사용해야 한다.
	//   그렇지만 readLine()을 사용하면 여러 번 입력 받을 수 있다. 객체 하나를 여러 번 사용 가능!


	System.out.printf("%d + %d = %d\n", num1, num2, num1 + num2);

    }
}
