package com.test.java;

public class Ex23_Method {

    public static void main(String[] args) {

	hello("홍길동"); //"홍길동" > 실인자
	hello("아무개");
	System.out.println();

	checkAge(26);
	checkAge(5);
	System.out.println();

	score("한효원", 100,95,80);


    } //main

    public static void hello(String name) { //String name : 가인자

	System.out.printf("%s님 안녕하세요.\n", name);

    } //hello

    public static void checkAge(int age) {

	String result = age >= 19 ? "성인" : "미성년자";
	System.out.printf("입력한 %d세는 %s입니다.\n", age, result);

    } //checkAge


    /**
     * 성적을 출력합니다.
     * @param name 학생 이름
     * @param kor  국어 점수
     * @param eng  영어 점수
     * @param math 수학 점수
     */
    public static void score(String name, int kor, int eng, int math) {

	System.out.println("=================");
	System.out.printf("   %s의 성적표\n", name);
	System.out.println("=================");

	System.out.printf("국어: %4d점\n", kor);
	System.out.printf("영어: %4d점\n", eng);
	System.out.printf("수어: %4d점\n", math);

	System.out.printf("총점: %4d점\n",	kor + eng + math);
	System.out.printf("평균:   %4.1f점\n", (kor + eng + math) / (double)3);


    }

}
