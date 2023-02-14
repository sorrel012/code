package com.test.question;

import java.util.Arrays;

/*

요구사항]중복되지 않는 임의의 숫자 6개를 만드시오.(로또)

- 숫자의 범위: 1 ~ 45
- 오름차순 정렬

1. 변수 선언
2. 배열 생성
3. 난수 6개 발생하여 배열에 넣기 (for문)
4. 배열 오름차순 정렬하기
5. 배열 출력하기

 */

public class Q066 {

    public static void main(String[] args) {

	int randomNum = 0;

	int[] lotto = new int[6];

	for(int i = 0; i < 6; i++) {

	    randomNum = (int)(Math.random() * 45) + 1;
	    lotto[i] = randomNum;
	}

	sort(lotto);

	System.out.println(Arrays.toString(lotto));


    } //main

    private static int[] sort(int[] lotto) {

	for (int i = 0; i < lotto.length - 1; i ++) {

	    for (int j = 0; j < lotto.length - 1 - i; j++) {

		if (lotto[j] > lotto[j+1]) {
		    int tmp = lotto[j];
		    lotto[j] = lotto[j+1];
		    lotto[j+1] = tmp;

		}

	    }

	}

	return lotto;
    }

}
