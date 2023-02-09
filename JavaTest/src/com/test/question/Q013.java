package com.test.question;

import java.util.Scanner;

public class Q013 {
    /*

    요구사항] 국어, 영어, 수학 점수를 전달하면 '합격' 혹은 '불합격'이라는 단어를 반환하는 메소드를 선언하시오.

    - String test(int kor, int eng, int math)
    - 평균 점수 60점 이상은 '합격'이다.
    - 평균 점수 60점 미만은 '불합격'이다.
    - 과락: 한 과목 이상 40점 미만이면 불합격이다.

    1. 합불 결과 반환 메소드 선언
    	1-1. 평균 점수 구하기
    	1-2. 평균 점수 60점 이상 && 과락 없는지 판단하기
    	1-3. 결과값 반환

    2. 입력 도구 생성
    3. 라벨 출력
    4. 국어 점수 입력 받기
    5. 라벨 출력
    6. 영어 점수 입력 받기
    7. 라벨 출력
    8. 수학 점수 입력 받기
    9. 메소드 호출하여 결과 받아 오기
    10. 결과 출력하기

     */

    public static void main(String[] args) {

	Scanner scan = new Scanner(System.in);

	System.out.print("국어: ");
	int kor = scan.nextInt();

	System.out.print("영어: ");
	int eng = scan.nextInt();

	System.out.print("수학: ");
	int math = scan.nextInt();

	String passFail = test(kor, eng, math);

	System.out.printf("%s입니다.\n", passFail);
	
	scan.close();

    } //main

    private static String test(int kor, int eng, int math) {

	int average = (kor + eng + math) / 3;

	String result = average >= 60 && kor >= 40 && eng >= 40 && math >= 30 ? "합격" : "불합격";

	return result;
    } //test
}
