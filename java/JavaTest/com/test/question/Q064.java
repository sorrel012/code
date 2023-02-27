package com.test.question;

import java.util.Arrays;

/*

요구사항]1~20 사이의 난수를 담고 있는 배열을 생성하고 최댓값과 최솟값을 출력하시오.

- 난수를 20개 발생 후 배열에 넣는다.
- 난수는 1 ~ 20 사이

1. 배열 생성
2. 난수 발생하여 배열에 넣기 (for문)
3. 원본 배열 출력하기
4. 배열 정렬하기
5. 최댓값, 최솟값 출력하기

 */

public class Q064 {

    public static void main(String[] args) {

	String txt = "";

	int[] random = new int[20];

	for(int i = 0; i < 20; i++) {

	    int randomNum = (int)(Math.random() * 20) + 1;
	    random[i] = randomNum;
	    txt += randomNum + ", ";
	}

	System.out.printf("원본: %s\n", txt);

	Arrays.sort(random);

	System.out.println("최댓값: " + random[19]);
	System.out.println("최솟값: " + random[0]);



    } //main
}
