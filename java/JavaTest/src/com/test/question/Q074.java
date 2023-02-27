package com.test.question;

/*

요구사항]아래와 같이 출력하시오.

- 오름차순
- 칸 수: 1 -> 3 -> 5 // -> 3 -> 1
- 0 수 : 2 -> 1 -> 0 -> 1 -> 2


0,2
1,1 / 1,2 / 1,3
2,0 / 2,1 / 2,2 / 2,3 / 2,4 /


3,1 / 3,2 / 3,3
4,2

 */

public class Q074 {

    public static void main(String[] args) {

   	int[][] list = new int[5][5];
   	int num = 1;

   	for(int i = 0; i < list.length/2 + 1; i++) {
   	    for(int j = list.length/2 - i; j <= list.length/2 + i; j++) {

		list[i][j] = num;
		num++;

	    }
   	}

   	for(int i = list.length/2 + 1; i < list.length; i++) {
   	    for(int j = i-2; j <= 6-i; j++) {

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
