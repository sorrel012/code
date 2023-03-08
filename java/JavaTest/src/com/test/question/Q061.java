package com.test.question;

import java.util.Scanner;

/*

요구사항]숫자를 5개 입력받아 배열에 담은 뒤 역순으로 출력하시오.

- int[] nums = new int[5];

1. 배열 생성
2. 변수 선언
3. 입력 도구 생성
4. 라벨 출력 + 숫자 입력 받기 (for문으로 5번 반복)
5. for문으로 역순으로 배열 값 출력하기

 */

public class Q061 {

    public static void main(String[] args) {

	int[] nums = new int[5];
	int num = 0;

	Scanner scan = new Scanner(System.in);

	for(int i = 0; i < 5; i++) {
	    System.out.print("숫자: ");
	    num = scan.nextInt();
	    nums[i] = num;
	}

	for(int i = 4; i >= 0; i--) {
	    System.out.printf("nums[%d] = %d\n", i, nums[i]);
	}

	scan.close();

    } //main
}
