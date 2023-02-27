package com.test.java;

public class Ex27_Overloading {
    public static void main(String[] args) {

	drawLine();
	drawLine("*");
	drawLine("#");

    } //main

    //요구사항] 선을 그리는 메소드
    public static void drawLine() {

	System.out.println("==============================");

    }

    //추가사항] 선의 모양 변경
    public static void drawLine(String s) {

	for(int i = 0; i < 30; i++) {
	    System.out.print(s);
	}
	System.out.println();

    }

}
