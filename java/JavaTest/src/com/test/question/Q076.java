package com.test.question;

import java.util.Scanner;

/*

요구사항] 성적을 입력받아 아래와 같이 출력하시오.

 - String[][] score = new String[10][3];

 1. 변수 선언
 2. 배열 생성
 3. 입력 도구 생성
 4. 라벨 출력 + 점수 입력받기 (국영수)
 5. 점수 / 10 의 개수만큼 네모를 배열에 담는 메소드 구현

 */

public class Q076 {

    public static void main(String[] args) {

	int kor = 0;
	int eng = 0;
	int math = 0;

	String[][] score = new String[10][3];

	Scanner scan = new Scanner(System.in);

	System.out.print("국어 점수: ");
	kor = scan.nextInt();

	System.out.print("영어 점수: ");
	eng = scan.nextInt();

	System.out.print("수학 점수: ");
	math = scan.nextInt();

	setScore(score, kor, 0);
	setScore(score, eng, 1);
	setScore(score, math, 2);

	printArr(score);
	System.out.println("-------------------");
	System.out.println("국어\t영어\t수학");

	scan.close();

    } //main

    private static String[][] setScore(String[][] score, int subject, int column) {

	for(int i = 9; i >= 10 - subject/10; i--) {

	    score[i][column] = "■";

	}

	return score;

    }

    private static void printArr(String[][] list) {

	for(int i = 0; i < list.length; i++) {
	    for(int j = 0; j < list[0].length; j++) {

		System.out.printf("%2s\t", list[i][j]);
	    }

	    System.out.println();
	}

    } //printArr

}
