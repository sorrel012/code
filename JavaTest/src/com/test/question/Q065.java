package com.test.question;

import java.util.Scanner;

/*

요구사항]난수를 담고 있는 배열을 생성한 뒤 아래와 같이 출력하시오.

- 난수를 20개 발생 후 배열에 넣는다.
- 난수는 1 ~ 20 사이
- 배열을 탐색하여 범위에 만족하는 숫자만 출력한다.

1. 변수 선언
2. 배열 생성
3. 난수 20개 발생하여 배열에 넣기 (for문)
4. 입력 도구 생성
5. 라벨 출력 + 최대 범위 입력 받기
6. 라벨 출력 + 최소 범위 입력 받기
7. 반복문 + 조건문 사용하여 범위 만족하는 숫자 출려하기

 */

public class Q065 {

    public static void main(String[] args) {

	String original = "";
	String result = "";

	int max = 0;
	int min = 0;

	int[] random = new int[20];

	for(int i = 0; i < 20; i++) {

	    int randomNum = (int)(Math.random() * 20) + 1;
	    random[i] = randomNum;

	    if(i == 19) {
		original += randomNum;

	    } else {
		original += randomNum + ", ";
	    }
	}

	Scanner scan = new Scanner(System.in);

	System.out.print("최대 범위: ");
	max = scan.nextInt();

	System.out.print("최소 범위: ");
	min = scan.nextInt();

	result = range(random, min, max);

	System.out.printf("원본: %s\n", original);
	System.out.printf("결과: %s\n", result);

	scan.close();

    } //main

    private static String range(int[] random, int min, int max) {

	String txt = "";

	for(int i = 0; i < random.length; i++) {

	    if(random[i] >= min && random[i] <= max) {

		txt += random[i] +", ";  // Q 마지막에 쉼표 없애는 법?
	    }

	}

	return txt;

    } //range

}
