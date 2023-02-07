package com.test.java;

public class Ex25_Method {

    public static void main(String[] args) {

	System.out.println(getNum());
	test();
	hello();
	hello();

	String name = "홍길동";
	hi(name);

	score();
	score2(100);
	String result = score3("홍길동");

	aaa();

    } //main

    private static void aaa() {

	int num = 10;
	int sum = 0;

	num++;
	num *= 2;
	sum = num + 100;

	System.out.println(sum);
    }

    private static String score3(String string) {
	return null;
    }

    private static void score2(int i) {
    }

    private static void score() {
    }

    private static void hi(String name) {
	System.out.println(name + " 안녕~");
	System.out.println(name + " 하이~");
	System.out.println(name + " 하하하~");
    }

    private static void hello() {
	System.out.println("안녕하세요.");
	System.out.println("반갑습니다.");
	System.out.println("환영합니다.");
    }

    public static void test() {
	System.out.println("one");
	System.out.println("two");
    }

    public static int getNum() {

	return 100;
    }

}
