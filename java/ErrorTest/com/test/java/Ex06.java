package com.test.java;

import java.util.Scanner;

public class Ex06 {

	public static void main(String[] args) {

		// 요구사항] 학생의 이름을 N개 입력받아 아래와 같이 출력하시오.
		String name = "";

		Scanner scan = new Scanner(System.in);

		System.out.print("학생 수: ");
		String[] list = new String[scan.nextInt()];

		scan.skip("\r\n"); //추가

		for (int i = 0; i < list.length; i++) { // <= -> <

			System.out.print("학생명: ");
			name = scan.nextLine();

			list[i] = name; // 0->i

		}

		System.out.println();

		sort(list);

		System.out.printf("입력한 학생은 총 %d명입니다.\n", list.length);

		for (int i = 0; i < list.length; i++) {
			System.out.printf("%d. %s\n", i + 1, list[i]);
		}

		scan.close();

	}

	private static String[] sort(String[] list) { //반환값 설정

		String temp = "";

		for (int i = 0; i < list.length - 1; i++) {
			for (int j = 0; j < list.length - 1 - i; j++) {
			    // i++ -> j++ 루프변수 수정
			    // - i 추가

				if (list[j].compareTo(list[j + 1]) > 0) { // 연산자 수정
					temp = list[j];
					list[j] = list[j+1];
					list[j + 1] = temp;
				}

			}
		}

		return list;

	}

}
