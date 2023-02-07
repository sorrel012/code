package com.test.question;

public class Q009 {

    /*

     요구사항] 이름을 전달하면 이름뒤에 '님'을 붙여서 반환하는 메소드를 선언하시오.

     String getName(String name)
     name: OOO(이름)
     return: OOO(이름)님

     1. getName 메소드 선언하기
     	1-1. 매개변수로 이름 전달 받기
     	1-2. 이름 뒤에 '님' 붙여서 반환하기
     2. getName 반환값 result 변수에 저장하기
     3. 고객명 출력하기

     */

    public static void main(String[] args) {

	String result = getName("홍길동");
	System.out.printf("고객: %s\n",  result);

    } //main

    private static String getName(String name) {
	return name+"님";
    } //getName

}
