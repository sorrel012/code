package com.test.question;

/*

요구사항]아래와 같이 출력하시오.

- 짝수 행: 큰 -> 작
- 홀수 행: 작 -> 큰

 */

public class Q071 {

    public static void main(String[] args) {

   	int[][] list = new int[5][5];
   	int num = 25;

   	for(int i = 0; i < list.length; i++) {
   	    for(int j = 0; j < list[0].length; j++) {

   		list[i][j] = num;
   		num--;

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
