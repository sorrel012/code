package codeReview;

import java.util.Arrays;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {

	int index = 0;
	int value = 0;

	int[] list = { 5, 6, 1, 3, 2, 8, 7, 4, 10, 9 };

	Scanner scan = new Scanner(System.in);

	System.out.print("삽입 위치: ");
	index = scan.nextInt();

	System.out.print("값: ");
	value = scan.nextInt();

	System.out.println("원본: " + Arrays.toString(list));

	insert(list, index, value);

	System.out.println("결과: " + Arrays.toString(list));

	scan.close();

    } //main

    private static int[] insert(int[] list, int index, int value) {

	for(int i = list.length - 1; i > index; i--) {

	    list[i] = list[i-1];
	}

	list[index] = value;

	return list;

    } //insert

}
