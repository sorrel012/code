package com.test.question;

public class Q010 {

    /*

     요구사항] 숫자 1개를 전달하면 4자리로 출력하는 메소드를 선언하시오.

     - void digit(int num)
     - 3항 연산자 사용(조건문 사용 금지)
     - 입력한 숫자가 4자리 이상이면 그대로 출력한다.

     1. 숫자를 입력하면 4자리로 출력해주는 digit 메서드 선언하기
     	1-1. 매개변수 입력받기
     	1-2. 3항연산자 이용하여 자릿수 검증하고 출력
     2. 메소드 호출하기

     */

    public static void main(String[] args) {

	digit(1);
	digit(12);
	digit(321);
	digit(5678);
	digit(98765);

    } //main

    private static void digit(int num) {

	String numToString = String.valueOf(num);

	numToString = numToString.length() == 1 ? "000" + numToString : numToString.length() == 2 ? "00" + numToString :
	    numToString.length() == 3 ? "0" + numToString : "" + numToString;

	System.out.printf("%d → %s\n", num, numToString);
    } //digit
}
