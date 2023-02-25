package com.test.question;

import java.util.Scanner;

/*

요구사항]학생의 이름을 N개 입력받아 아래와 같이 출력하시오.

- 이름을 오름차순 정렬하시오.

1. 변수 선언
2. 입력 도구 생성
3. 라벨 출력 + 학생수 입력 받기
4. 배열 생성
5. 라벨 출력 + 학생명 (for문으로 입력 숫자만큼 반복)
6. for문으로 오름차순 정렬하기
7. for문으로 배열 출력하기

 */

public class Q062 {

	public static void main(String[] args) {

		int numberOfStudent = 0;
		String studentName = "";

		Scanner scan = new Scanner(System.in);

		System.out.print("학생 수: ");
		numberOfStudent = scan.nextInt();

		scan.skip("\r\n");

		String[] students = new String[numberOfStudent];

		for(int i = 0; i < numberOfStudent; i++) {

			System.out.print("학생명: " );
			studentName = scan.nextLine();
			students[i] = studentName;
		}

		sortAsc(students); //?students = sortAsc(students) 라고 안 써도 되는 이유?? 변수명이 같으니 자동으로 들어가는 것?

		System.out.printf("입력한 학생은 총 %d명입니다.\n", numberOfStudent);

		for(int i = 0; i < numberOfStudent; i++) {

			System.out.printf("%d. %s\n", i + 1, students[i]);
		}

		scan.close();

	} //main

	private static String[] sortAsc(String[] students) {

		for (int i = 0; i < students.length - 1; i++) {

			for (int j = 0; j < students.length - 1 - i; j++) {

				if (students[j].compareTo(students[j+1]) > 0) {
					String tmp = students[j];
					students[j] = students[j+1];
					students[j+1] = tmp;

				}

			}

		}

		return students;

	} //sortAsc

}
