package com.test.question;

import java.util.Arrays;
import java.util.Scanner;

/*

요구사항]배열의 요소를 순차적으로 2개씩 더한 결과를 배열로 생성한 뒤 출력하시오.

- 원본 배열 길이: 사용자 입력
- 원본 배열 요소: 난수(1~9)
- 결과 배열 길이: 사용자 입력 / 2

1. 변수 선언
2. 입력 도구 생성
3. 라벨 출력 + 배열 길이 입력 받기
4. 배열 생성 (원본 , 결과)
5. for문: 입력 받은 길이만큼 난수 생성하여 원본 배열에 저장
6. 반복문 활용하여 순차적으로 2개씩 더한 결과를 결과 배열에 저장
7. 원본, 결과 배열 출력

 */

public class Q069 {

    public static void main(String[] args) {

	int length = 0;

	Scanner scan = new Scanner(System.in);

	System.out.print("배열 길이: ");
	length = scan.nextInt();

	int[] original = new int[length];
	int[] result = new int[length/2];

	for(int i = 0; i < length; i++) {

	    original[i] = (int)(Math.random() * 9) + 1;

	}

	result = sum(original);

	System.out.println("원본: " + Arrays.toString(original));
	System.out.println("결과: " + Arrays.toString(result));

	scan.close();

    } //main

    private static int[] sum(int[] original) {

	int length = original.length;

	int[] arraySum = new int[length/2];

	if(length % 2 != 0) {
	    arraySum = new int[length/2 + 1];
	    arraySum[length / 2] = original[length - 1];
	}

	for(int i = 0; i < length/2; i++) {

	    arraySum[i] = original[i*2] + original[i*2+1];
	}

	return arraySum;

    } //sum

}
