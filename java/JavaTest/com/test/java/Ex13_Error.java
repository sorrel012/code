package com.test.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex13_Error {

    public static void main(String[] args) throws IOException {

	BufferedReader reader = new BufferedReader
		(new InputStreamReader(System.in));

	System.out.print("숫자 입력: ");

	String input = reader.readLine();

	int num = Integer.parseInt(input);

	System.out.println(100 / num);
    }

}
