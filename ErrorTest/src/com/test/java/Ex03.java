package com.test.java;

import java.util.Scanner;

public class Ex03 {

	public static void main(String[] args) {

		// 요구사항] 년도를 입력받아 해당 년도가 '평년' 인지 '윤년' 인지 출력하시오.
		int year = 0;
		String result = "";

		Scanner scan = new Scanner(System.in);

		System.out.print("년도 입력: ");
		year = scan.nextInt();

		if (year % 4 != 0) {
			if (year % 100 == 0) {
				if (year % 400 != 0) {
					result = "윤년";
				} else {
					result = "평년";
				}
			} else {
				result = "윤년";
			}
		} else {
			result = "평년";
		}

		System.out.printf("%d년은 '%s'입니다.\n", year, result); //형식지정자 수정

		scan.close();

	}

}
