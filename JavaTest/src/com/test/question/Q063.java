package com.test.question;

/*

요구사항]int 배열을 매개변수로 받아 내용을 문자열로 반환하는 dump 메소드를 구현하시오.

- String dump(int[] list)

1. 배열 생성
2. 배열 초기화(값 수정)
3. dump 메소드 구현
4. 배열 출력

 */

public class Q063 {

    public static void main(String[] args) {

	int[] list = new int[4];

	list[0] = 10;
	list[1] = 20;
	list[2] = 30;
	list[3] = 40;

	String result = dump(list);
	System.out.printf("nums = %s\n", result);

    } //main

    private static String dump(int[] list) {

	String txt = "[ ";

	for(int i = 0; i < list.length; i++) {

	    if(i == list.length - 1) {
		txt += list[i] + " ]";
		break;
	    }

	    txt += list[i] + ", ";

	}


	return txt;
    }
}
