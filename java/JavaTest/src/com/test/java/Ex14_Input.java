package com.test.java;

import java.util.Scanner;

public class Ex14_Input {
    public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);

	System.out.print("이름: ");
	String name = scan.nextLine();
	System.out.printf("안녕하세요. %s님.\n", name);

	System.out.println();

	System.out.print("나이: ");
	int age = scan.nextInt();
	System.out.printf("10년 후 나이는 %d살입니다.\n", age + 10);
    }
}
