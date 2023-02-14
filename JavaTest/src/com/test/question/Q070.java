package com.test.question;

/*

요구사항]아래와 같이 출력하시오.

- 홀수행 : 오 -> 왼
- 짝수행 : 왼 -> 오

 */

public class Q070 {

    public static void main(String[] args) {

	int[][] list = new int[5][5];
	int num = 1;

	for(int i = 0; i < list.length; i++) {

	    if(i % 2 == 0) {
		for(int j = 0; j < list[0].length; j++) {

		    list[i][j] = num;
		    num++;

		}
	    } else {
		for(int j = list[0].length - 1; j >= 0; j--) {

		    list[i][j] = num;
		    num++;
		}
	    }


	}

	 printArr(list);

    } //main

    private static void printArr(int[][] list) {

	for(int i = 0; i < list.length; i++) {
	    for(int j = 0; j < list[0].length; j++) {

		System.out.printf("%2d\t", list[i][j]);
	    }

	    System.out.println();
	}

    } //printArr

}
