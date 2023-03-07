package com.test.question;

/*

- 각 행 별로 값 담기 + 누적합 담기
- 누적 합 출력하고 행 바꾸기
- 열별 합 구해서 담기 + 총계 담기

*/

public class Q075 {

    public static void main(String[] args) {

	int[][] list = new int[5][5];

	int num = 1;

	for(int i = 0; i < list.length - 1; i++) {

	    int sum = 0;

	    for(int j = 0; j < list[0].length - 1; j++) {

		list[i][j] = num;
		sum += num;
		num++;

	    }
	    list[i][list.length-1] = sum;

	}

	int total = 0;

	for(int i = 0; i < list[0].length-1; i++) {

	    num = i + 1;
	    int sum = num;

	    for(int j = 0; j < list[0].length - 2; j++) {

		num += 4;
		sum += num;
	    }

	    list[list.length-1][i] = sum;

	    total += sum;

	}

	list[list.length-1][list.length-1] = total;

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
