package com.test.java;

import java.util.Arrays;
import java.util.Random;

public class Ex07 {

	public static void main(String[] args) {

		// 요구사항] 1~20 사이의 난수를 담고 있는 배열을 생성하고 최댓값과 최솟값을 출력하시오.

		int[] list = new int[20];
		int min = 0;
		int max = 0;

		Random rnd = new Random();

		for (int i=0; i<list.length; i++) {

			list[i] = rnd.nextInt(20) + 1; //+1

		}

		System.out.print("원본: ");

		for (int i=0; i<list.length; i++) {

			System.out.print(list[i] + ", ");

		}

		System.out.println();

		Arrays.sort(list); //정렬

		max = list[19];
		min = list[0];

		System.out.printf("최댓값: %d\n", max);
		System.out.printf("최솟값: %d\n", min);

	}

}
