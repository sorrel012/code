package com.test.java;

public class Ex23_Method {

    public static void main(String[] args) {

	hello("홍길동");
	hello("아무개");

    } //main

    public static void hello(String name) {
	System.out.printf("%s님 안녕하세요.\n", name);
    } //hello

}
