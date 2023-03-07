package com.test.java;

import java.util.Scanner;

public class Ex04 {

    public static void main(String[] args) {

	// 요구사항] 숫자 1개를 입력받아 1부터 입력한 숫자까지의 합을 출력하시오.

	int num = 0;
	int sum = 0;

	Scanner scan = new Scanner(System.in);

	System.out.print("숫자: ");
	num = scan.nextInt();

	for (int i = 1; i <= num; i++) {
	    sum += i;
	}

	System.out.printf("1 ~ %,d = %,d\n", num, sum);

	scan.close();

    }

}
