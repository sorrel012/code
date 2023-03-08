package com.test.question;

/*

요구사항]아래와 같이 출력하시오.

- 열 먼저 -> 행 나중 저장

 */

public class Q072 {

    public static void main(String[] args) {

   	int[][] list = new int[5][5];
   	int num = 1;

   	for(int i = 0; i < list.length; i++) {
   	    for(int j = 0; j < list[0].length; j++) {

   		list[j][i] = num;
   		num++;

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
