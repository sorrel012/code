package com.test.java;

import java.util.Scanner;

public class Ex05 {

	public static void main(String[] args) {

		// 요구사항] 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 = 55

		int begin = 0;
		int end = 0;
		int sum = 0;
		String txt = "";

		Scanner scan = new Scanner(System.in);

		System.out.print("시작 숫자: ");
		begin = scan.nextInt();

		System.out.print("종료 숫자: ");
		end = scan.nextInt();

		for (int i = begin; i < end; i++) {

			sum += i;
			txt += i+ " + ";

		}

		sum += end;
		txt += end;

		System.out.println(txt + " = " + sum);

		scan.close();

	}

}
