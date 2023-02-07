package com.test.java;

public class Ex24_Method {

    public static void main(String[] args) {

	System.out.println(getNum());
	System.out.println(checkAge(15));

    } //main

    public static int getNum() {

	return 10;

    } //getNum

    public static String checkAge(int age) {

	String result = age >= 19 ? "성인" : "미성년자";

	return result;

    } //checkAge

}
