package com.test.java;

public class Ex11_Input {
    public static void main(String[] args) throws Exception {
	System.out.print("문자 입력: ");

	int code = System.in.read();

	System.out.println(code);
	System.out.printf("%c\n", code);
	System.out.println();

	code = System.in.read();

	System.out.println(code);
	System.out.printf("%c\n", code);
	System.out.println();

	code = System.in.read();

	System.out.println(code);
	System.out.printf("%c\n", code);
	System.out.println();
    }
}
