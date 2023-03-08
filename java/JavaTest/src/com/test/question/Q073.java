package com.test.question;

/*

요구사항]아래와 같이 출력하시오.

- 오름차순
- 0으로 채우는 칸 ++

 */

public class Q073 {

    public static void main(String[] args) {

   	int[][] list = new int[5][5];
   	int num = 1;

   	for(int i = 0; i < list.length; i++) {
   	    for(int j = 0; j < list[0].length-i; j++) {

   		list[i][j] = num;
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
