package com.test.question;

public class Q008 {

    /*

    요구사항] 인삿말을 출력하는 메소드 3개를 출력하시오.

    - void hello()
    - void introduce()
    - void bye()

    1. hello 메소드 선언
    2. introduce 메소드 선언
    3. bye 메소드 선언
    4. 1~3에서 선언한 메소드 호출

    */

    public static void main(String[] args) {

	hello();
	introduce("홍길동");
	bye();


    } //main

    private static void hello() {

	System.out.println("안녕하세요.");

    } //hello

    /**
     * 자신을 소개하는 메소드
     * @param name
     */
    private static void introduce(String name) {

	System.out.printf("저는 %s입니다.\n", name);

    } //introduce

    private static void bye() {

	System.out.println("안녕히 가세요.");

    } //bye
}
