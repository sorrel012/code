package com.test.question;

public class Q017 {

    /*

    요구사항] 인자로 받은 이름들을 직급 순으로 출력하는 메소드를 선언하시오.

    - 사원 → 대리 → 과장 → 부장
    - void position(String)
    - void position(String, String)
    - void position(String, String, String)
    - void position(String, String, String, String)

    1. 메소드 생성
    2. 메소드 호출(출력)

    */

    public static void main(String[] args) {

	position("홍길동");
	position("홍길동", "유재석");
	position("홍길동", "유재석", "박명수");
	position("홍길동", "유재석", "박명수", "정형돈");

    } //main

    private static void position(String name) {
	System.out.printf("사원: %s\n\n", name);
    }

    private static void position(String name1, String name2) {
	System.out.printf("사원: %s\n", name1);
	System.out.printf("대리: %s\n\n", name2);
    }

    private static void position(String name1, String name2, String name3) {
	System.out.printf("사원: %s\n", name1);
	System.out.printf("대리: %s\n", name2);
	System.out.printf("과장: %s\n\n", name3 );
    }

    private static void position(String name1, String name2, String name3, String name4) {
	System.out.printf("사원: %s\n", name1);
	System.out.printf("대리: %s\n", name2);
	System.out.printf("과장: %s\n", name3);
	System.out.printf("부장: %s\n\n", name4);
    }


}
